package com.fiuba.tecnicas.logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Martin Quiroz
 * 
 * Reads and saves the settings Properties file for use by the MessageParser
 */
public class LoggerSettings {
	
	final static String PROPERTIES_FILE_PATH = "config.properties";
	final static String SEPARATOR_LABEL = "separator";
	final static String SEPARATOR_DEFAULT_VALUE = "-";
	final static String LEVEL_LABEL = "level";
	final static String LEVEL_DEFAULT_VALUE = "INFO";
	final static String FORMAT_LABEL = "format";
	final static String FORMAT_DEFAULT_VALUE = "%d{HH:mm:ss} - %p - %m";
	final static String LOG_PATH_LABEL = "path";
	final static String CONSOLE_USE_LABEL = "console";
	final static String TRUE_LABEL = "true";
    final static String REGEX_SPACE = "\\s+";
    final static String REGEX_ADD_DEFAULT_SEPARATOR = "|%n";

    private boolean consoleLogging;
    private String separator;
	private LoggerLevels levelFilter;
	private String formatList;
	private String[] filePaths;
	
	public LoggerSettings(){
		consoleLogging = false;
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
	 * @param nivel - name of level
	 * @return if corresponds to a level
	 * 
	 * Valids if the parameter corresponds to a level on the right (top) or at the same level
	 */
	public boolean belongsToLevelFilter(String nivel){
		LoggerLevels level = LoggerLevels.valueOf(nivel);
		return (level.getId() >= levelFilter.getId());
	}

	/**
	 * @author Martin Quiroz
	 * Loads the Properties file
	 */
	public void fileUploadProperties(){
	    Properties properties = new Properties();
	    
	    try {
	      properties.load(new FileInputStream(PROPERTIES_FILE_PATH));
	    } catch (IOException e) {
	    	System.out.println( "Error de archivo. Se cargan valores por defecto." );
	    }
	    
	    if(properties.isEmpty() == false){
	    	valuesLoadingProperties(properties);
	    }else{
	    	consoleLogging = true;
	    }
	}

    private void valuesLoadingProperties(Properties properties){
        separator = properties.getProperty(SEPARATOR_LABEL,SEPARATOR_DEFAULT_VALUE);
        String level = properties.getProperty(LEVEL_LABEL,LEVEL_DEFAULT_VALUE); 
        levelFilter =  LoggerLevels.valueOf(level);
        if( (properties.getProperty(CONSOLE_USE_LABEL,LEVEL_DEFAULT_VALUE)).equals(TRUE_LABEL) ){
        	consoleLogging = true;
        }
        obtainFormats(properties);
        obtainPaths(properties);
    }

    private void obtainFormats(Properties properties){
    	formatList = properties.getProperty(FORMAT_LABEL,FORMAT_DEFAULT_VALUE);
    }
    
    private void obtainPaths(Properties properties){
    	String paths = properties.getProperty(LOG_PATH_LABEL);
    	if(paths != null) filePaths = divideStringWithSeparator(paths);
    }

    private String[] divideStringWithSeparator(String string){
    	string = string.replaceAll(REGEX_SPACE,"");
    	return string.split("["+separator+"]"+REGEX_ADD_DEFAULT_SEPARATOR);	
    }
   
}
