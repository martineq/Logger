package com.fiuba.tecnicas.logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Vector;


/**
 * @author mquiroz
 * Lee y guarda las configuraciones del archivo de Properties para ser usado por el logger
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
	final static String FECHA_VALOR_DEFAULT = "HH:mm:ss";
    final static String REGEX_ESPACIOS = "\\s+";
    final static String REGEX_AGREGAR_SEPARADOR_DEFAULT = "|%n";
    final static String OPERADOR_PATRON = "%";
    final static String INDICADOR_FECHA = "d";
	final static String INDICADOR_NIVEL = "p";
	final static String INDICADOR_HILO = "t";
	final static String INDICADOR_MENSAJE = "m";
	final static String INDICADOR_SEPARADOR = "n";
	final static String INDICADOR_LINEA = "L";
	final static String INDICADOR_ARCHIVO = "F";
	final static String INDICADOR_METODO = "M";

	private LoggerLevels levelFilter;//TODO: Ver que representa levelFilter
	
	//private LoggerLevels loggerLevel;
	private Vector<String> formatList; //TODO: Reemplazar la carga en los String por lo implementado para c/u de los formatos. Ver loadFormats()
	private String[] filePaths;
	private String separator;
	private boolean fileLogging;
	private boolean consoleLogging;
	SimpleDateFormat simpleDateFormat;

	public LoggerSettings(){
		levelFilter = LoggerLevels.valueOf("INFO");
		separator = SEPARADOR_VALOR_DEFAULT;
		simpleDateFormat = new SimpleDateFormat(FECHA_VALOR_DEFAULT);
		consoleLogging = true;
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
	
	public SimpleDateFormat getSimpleDateFormat(){
		return simpleDateFormat;
	}

	public LoggerLevels getLoggerLevel(){
		return levelFilter;
	}
	
	/**
	 * se valida si el parametro corresponde a un nivel a la derecha (superior) o al mismo nivel filtro
	 * @param nivel
	 * @return
	 */
	public boolean perteneceAlFiltroElNivel(String nivel){
		LoggerLevels level = LoggerLevels.valueOf(nivel);
		return (level.getId() >= levelFilter.getId());
	}
	
	public boolean consoleLogEnabled(){
		return consoleLogging;
	}
	
	 
    public String getFormat(){
    	return "%d{HH:mm:ss} - %p - %t %m";
    }
    
    public boolean fileLogEnabled(){
    	return fileLogging;
    }
	/**
	 * Carga el archivo properties
	 */
	public void fileUploadProperties(){
	    Properties properties = new Properties();
	    try {
	      properties.load(new FileInputStream(RUTA_ARCHIVO_PROPERTIES));
	    } catch (IOException e) {
	    	System.out.println( "Error de archivo" );
	    	// TODO: Se podrian cargar todos valores por defecto sin depender del archivo
	    }
	    valuesLoadingProperties(properties);
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
    	String format = properties.getProperty(FORMATO_ETIQUETA,FORMATO_VALOR_DEFAULT);
    	divideAndLoadFormats(format);
    }

    
    private void divideAndLoadFormats(String format){
        String[] formatList = divideStringWithSeparator(format);
        loadFormats(formatList);
    }
    
    
    private void loadFormats(String[] formats){
        for(String formatUnit:formats){
        	// TODO: Cambiar los ".add(String)" por la funcionalidad. Se tiene en cuenta la posicion en el vector en la que se enuentra para replicarla a la hora de imprimir el log
        	if(formatUnit.startsWith(OPERADOR_PATRON)==false) formatList.add(formatUnit);
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_NIVEL)) formatList.add("p");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_HILO)) formatList.add("t");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_MENSAJE)) formatList.add("m");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+OPERADOR_PATRON)) formatList.add("%");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_SEPARADOR)) formatList.add(separator);
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_LINEA)) formatList.add("L");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_ARCHIVO)) formatList.add("F");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_METODO)) formatList.add("M");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_FECHA)){
        		formatList.add("d");
        		uploadTimeFormat(formatUnit);
        	}
        	
         }
    }


    private void uploadTimeFormat(String formatoDateObtenido){
    	String stringDateFormat = formatoDateObtenido.substring(3, formatoDateObtenido.length()-1);
   	   	simpleDateFormat = new SimpleDateFormat(stringDateFormat);
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
