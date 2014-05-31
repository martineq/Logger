package com.fiuba.tecnicas.logging;

import java.util.ArrayList;
import java.util.List;
import com.fiuba.tecnicas.logging.formatter.*;
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

    private boolean consoleLogging;
    private String separator;
	private LoggerLevels levelFilter;
	private String formatList;
	private String[] filePaths;
	private String loggerName;
	
	public LoggerSettings(){
		consoleLogging = true;
		separator = SEPARATOR_DEFAULT_VALUE;
		levelFilter = LoggerLevels.valueOf(LEVEL_DEFAULT_VALUE);
		formatList = FORMAT_DEFAULT_VALUE;
		filePaths = new String[0];
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
			if( available = sourceList.get(i).isAvailable() ) usedSource = sourceList.get(i); 
		}

		loadPropertiesValues(usedSource);
	}

	private void loadSources(List<SourceSettings> sourceList){
		sourceList.add(new PropertiesSource());
		sourceList.add(new XmlSource());
	}
	
    private void loadPropertiesValues(SourceSettings source){
        separator = source.getValue(SEPARATOR_LABEL,SEPARATOR_DEFAULT_VALUE);
        String level = source.getValue(LEVEL_LABEL,LEVEL_DEFAULT_VALUE); 
        levelFilter =  LoggerLevels.valueOf(level);
        if( !((source.getValue(CONSOLE_USE_LABEL,CONSOLE_TRUE_LABEL)).equals(CONSOLE_TRUE_LABEL)) ){
        	consoleLogging = false;
        }
        obtainFormats(source);
        obtainPaths(source);
    }

    private void obtainFormats(SourceSettings source){
    	formatList = source.getValue(FORMAT_LABEL,FORMAT_DEFAULT_VALUE);
    }

    private void obtainPaths(SourceSettings source){
    	String paths = source.getValue(LOG_PATH_LABEL,EMPTY_STRING);
    	if( !(paths.equals(EMPTY_STRING)) ) filePaths = divideStringWithSeparator(paths);
    }

    private String[] divideStringWithSeparator(String string){
    	string = string.replaceAll(REGEX_SPACE,"");
    	return string.split("["+separator+"]"+REGEX_ADD_DEFAULT_SEPARATOR);	
    }

	public String getLoggerName() {
		return loggerName;
	}
	
	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}

	public Formatter getFormatter() {
		return new UserFormatter(this.getFormat());
	}
   
}
