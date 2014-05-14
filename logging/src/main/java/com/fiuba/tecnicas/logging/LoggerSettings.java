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
	
	final static String RUTA_ARCHIVO_PROPERTIES = "config.properties";
	final static String SEPARADOR_ETIQUETA = "separator";
	final static String SEPARADOR_VALOR_DEFAULT = "-";
	final static String NIVEL_ETIQUETA = "level";
	final static String NIVEL_VALOR_DEFAULT = "INFO";
	final static String FORMATO_ETIQUETA = "format";
	final static String FORMATO_VALOR_DEFAULT = "%d{HH:mm:ss} - %p - %m";
	final static String RUTAS_LOG_ETIQUETA = "path";
	final static String USO_CONSOLA_ETIQUETA = "console";
	final static String VERDADERO_ETIQUETA = "true";
    final static String REGEX_ESPACIOS = "\\s+";
    final static String REGEX_AGREGAR_SEPARADOR_DEFAULT = "|%n";

    private boolean consoleLogging;
    private String separator;
	private LoggerLevels levelFilter;
	private String formatList;
	private String[] filePaths;
	
	public LoggerSettings(){
		consoleLogging = false;
		separator = SEPARADOR_VALOR_DEFAULT;
		levelFilter = LoggerLevels.valueOf(NIVEL_VALOR_DEFAULT);
		formatList = FORMATO_VALOR_DEFAULT;
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
	 * @param nivel
	 * @return 
	 * 
	 * Valids if the parameter corresponds to a level on the right (top) or at the same level
	 * 
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
	      properties.load(new FileInputStream(RUTA_ARCHIVO_PROPERTIES));
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
        separator = properties.getProperty(SEPARADOR_ETIQUETA,SEPARADOR_VALOR_DEFAULT);
        String level = properties.getProperty(NIVEL_ETIQUETA,NIVEL_VALOR_DEFAULT); 
        levelFilter =  LoggerLevels.valueOf(level);
        if( (properties.getProperty(USO_CONSOLA_ETIQUETA,NIVEL_VALOR_DEFAULT)).equals(VERDADERO_ETIQUETA) ){
        	consoleLogging = true;
        }
        obtainFormats(properties);
        obtainPaths(properties);
    }

    private void obtainFormats(Properties properties){
    	formatList = properties.getProperty(FORMATO_ETIQUETA,FORMATO_VALOR_DEFAULT);
    }
    
    private void obtainPaths(Properties properties){
    	String paths = properties.getProperty(RUTAS_LOG_ETIQUETA);
    	if(paths != null) filePaths = divideStringWithSeparator(paths);
    }

    private String[] divideStringWithSeparator(String string){
    	string = string.replaceAll(REGEX_ESPACIOS,"");
    	return string.split("["+separator+"]"+REGEX_AGREGAR_SEPARADOR_DEFAULT);	
    }
   
}
