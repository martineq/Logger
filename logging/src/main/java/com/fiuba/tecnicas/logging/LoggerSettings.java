package com.fiuba.tecnicas.logging;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.fiuba.tecnicas.logging.formatter.*;
import com.fiuba.tecnicas.logging.saver.ConsoleSaver;
import com.fiuba.tecnicas.logging.saver.FileSaver;
import com.fiuba.tecnicas.logging.saver.LogSaver;
import com.fiuba.tecnicas.logging.saver.MultifunctionSaver;
import com.fiuba.tecnicas.logging.sourceSettings.*;

/**
 * @author Martin Quiroz
 * 
 * Reads and saves the settings source file for use by the MessageParser
 */
public class LoggerSettings {
	
	final static String SOURCE_FILE_NAME = "config";
	final static String SEPARATOR_LABEL = "separator";
	final static String SEPARATOR_DEFAULT_VALUE = "-";
	final static String LEVEL_LABEL = "level";
	final static String LEVEL_DEFAULT_VALUE = "TRACE";
	final static String FORMAT_LABEL = "format";
	final static String FORMAT_DEFAULT_VALUE = "%d{HH:mm:ss} - %p - %m";
	final static String LOG_PATH_LABEL = "path";
	final static String CONSOLE_USE_LABEL = "console";
	final static String CONSOLE_TRUE_LABEL = "true";
	final static String REGEX_SPACE = "\\s+";
    final static String REGEX_ADD_DEFAULT_SEPARATOR = "|%n";
    final static String EMPTY_STRING = "";
    final static String SPACE_STRING = " ";
	final static String REGEX_FILTER_LABEL = "regexFilter";
	final static String CUSTOM_FILTER_LABEL = "customFilter";
	final static String CUSTOM_SAVE_LABEL = "customSave";
	final static int SPLIT_ALL = 0;
	final static int SPLIT_IN_TWO = 2;
	
    private boolean consoleLogging;
    private String separator;
	private LoggerLevels levelFilter;
	private String formatList;
	private String[] filePaths;
	private String loggerName;
	private String userCustomSave;
	private String userCustomSaveArgs;
	private LoggerFilters filters;
	
	public LoggerSettings(){
		consoleLogging = true;
		separator = SEPARATOR_DEFAULT_VALUE;
		levelFilter = LoggerLevels.valueOf(LEVEL_DEFAULT_VALUE);
		formatList = FORMAT_DEFAULT_VALUE;
		filePaths = new String[0];
		filters = new LoggerFilters();
		userCustomSave = EMPTY_STRING;
		userCustomSaveArgs = EMPTY_STRING;
	}

	public String getLevelFilter(){
		return levelFilter.toString();
	}

	public String getSeparator(){
		return separator;
	}
	
	public String[] getFilePaths(){
		return filePaths;
	}
	
	public boolean consoleLogEnabled(){
		return consoleLogging;
	}
	
    public String getFormat(){
    	return formatList;
    }
    
    public boolean fileLogEnabled(){
    	return (filePaths.length > 0);
    }
	
	/**
	 * @author Martin Quiroz
	 * @param level name of level
	 * @return if corresponds to a level
	 * 
	 * Valids if the parameter corresponds to a level on the right (top) or at the same level
	 */
	public boolean belongsToLevelFilter(String level){
		return (levelFilter.lessOrEqualThan(level));
	}

	/**
	 * @author Martin Quiroz
	 * Loads the source file and saves the values readed
	 * On file error, loads default values
	 */
	public void fileUploadProperties(){
		SourceSettings usedSource = new DefaultSource();
		List<SourceSettings> sourceList = new ArrayList<SourceSettings>();
		boolean available = false;
		loadSources(sourceList);

		for (int i = 0; (!available) && (i < sourceList.size()) ; i++) {
			sourceList.get(i).load(SOURCE_FILE_NAME);
			if( available = sourceList.get(i).isAvailable() ){ usedSource = sourceList.get(i);} 
		}

		loadPropertiesValues(usedSource);
	}

	private void loadSources(List<SourceSettings> sourceList){
		sourceList.add(new PropertiesSource());
		sourceList.add(new XmlSource());
	}

    private void loadPropertiesValues(SourceSettings source){
        separator = source.getValue(SEPARATOR_LABEL,SEPARATOR_DEFAULT_VALUE);
        obtainLevelFilter(source);
        if( !((source.getValue(CONSOLE_USE_LABEL,CONSOLE_TRUE_LABEL)).equals(CONSOLE_TRUE_LABEL)) ){
        	consoleLogging = false;
        }
        obtainFormats(source);
        obtainPaths(source);
        obtainUserCustomSaveAndArgs(source);
        filters.setRegexFilter(source.getValue(REGEX_FILTER_LABEL,EMPTY_STRING));
    }

    private void obtainUserCustomSaveAndArgs(SourceSettings source){
    	String string = source.getValue(CUSTOM_SAVE_LABEL,EMPTY_STRING);
    	if (!string.equals(EMPTY_STRING)){
        	String[] splitString = divideStringWithSeparator(string,SPLIT_IN_TWO);
        	userCustomSave = splitString[0];
        	if(splitString.length > 1){
        		userCustomSaveArgs = splitString[1].replaceAll("["+separator+"]"+REGEX_ADD_DEFAULT_SEPARATOR,SPACE_STRING);	
        	}
    	}
    }
    
    private void obtainFormats(SourceSettings source){
    	formatList = source.getValue(FORMAT_LABEL,FORMAT_DEFAULT_VALUE);
    }

    private void obtainPaths(SourceSettings source){
    	String paths = source.getValue(LOG_PATH_LABEL,EMPTY_STRING);
    	if( !(paths.equals(EMPTY_STRING)) ){ filePaths = divideStringWithSeparator(paths,SPLIT_ALL);}
    }

    private void obtainLevelFilter(SourceSettings source){
    	String level = source.getValue(CUSTOM_FILTER_LABEL,EMPTY_STRING); 
    	if(level.equals(EMPTY_STRING)){ level = source.getValue(LEVEL_LABEL,LEVEL_DEFAULT_VALUE);} 
        levelFilter =  LoggerLevels.valueOf(level);
    }   
    
    private String[] divideStringWithSeparator(String string, int numberOfSplits){
    	string = string.replaceAll(REGEX_SPACE,EMPTY_STRING);
       	return string.split("["+separator+"]"+REGEX_ADD_DEFAULT_SEPARATOR,numberOfSplits);
    	
    }
    
	public String getLoggerName() {
		return loggerName;
	}
	
	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}

	public Formatter getFormatter() {
		FormatterManager manager = new FormatterManager(getFormat());
		return manager.getFormatter();
	}

	public LogSaver getSaver() {
		if(userCustomSave != EMPTY_STRING ){
			try {
				Constructor<?> constructor = Class.forName(userCustomSave).getConstructor(String.class);
				return (LogSaver) constructor.newInstance(userCustomSaveArgs);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ConsoleSaver("User Class Not Found Error");
			}
		}
		if(consoleLogEnabled() && fileLogEnabled()){
			return new MultifunctionSaver(this);
		}
		if(fileLogEnabled()){
			return new FileSaver(this);
		}
		if(consoleLogEnabled()){
			return new ConsoleSaver(this);
		}
		
		return null;
		
	}

	public LoggerFilters getLoggerFilters() {
		return filters;
	}

}
