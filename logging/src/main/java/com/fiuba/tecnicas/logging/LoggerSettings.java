package com.fiuba.tecnicas.logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * @author mquiroz
 * Lee y guarda las configuraciones del archivo de Properties para su uso por el log
 */
public class LoggerSettings {
	
	final static String RUTA_ARCHIVO_PROPERTIES = "config.properties";
	final static String RUTA_ARCHIVO_LOG = "log.txt";
	final static String SEPARADOR_ETIQUETA = "separator";
	final static String SEPARADOR_VALOR_DEFAULT = "-";
	final static String NIVEL_ETIQUETA = "level";
	final static String NIVEL_VALOR_DEFAULT = "INFO";
	final static String FORMATO_ETIQUETA = "format";
	final static String FORMATO_VALOR_DEFAULT = "%d{HH:mm:ss} - %p - %m";
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
	
	private LoggerLevels nivelesDeLog;
	private LoggerLevels levelFilter;
	private String separator;
	private String rutaArchivoDestino;
	SimpleDateFormat simpleDateFormat;
	private boolean loggingPorConsola;
	private boolean loggingPorArchivo;
	
	public LoggerSettings(){
		levelFilter = LoggerLevels.INFO;
		separator = SEPARADOR_VALOR_DEFAULT;
		rutaArchivoDestino = RUTA_ARCHIVO_LOG;  // TODO: Ver si finalmente se carga del archivo de properties o no
		simpleDateFormat = new SimpleDateFormat(FECHA_VALOR_DEFAULT);
		loggingPorArchivo = false;
		loggingPorConsola = true;
	}
	
	public void setRutaArchivo(String file){
		rutaArchivoDestino = file;
	}
	
	public String getLevelFilter(){
		return levelFilter.toString();
	}
	
	public String getSeparator(){
		return separator;
	}
	
	public String getRutaArchivo(){
		return rutaArchivoDestino;
	}
	
	public SimpleDateFormat getSimpleDateFormat(){
		return simpleDateFormat;
	}
	
	public void activarLogginPorConsola(){
		loggingPorConsola = true;
	}
	
	public void desactivarLogginPorConsola(){
		loggingPorConsola = false;
	}
	
	public void activarLogginPorArchivo(){
		loggingPorArchivo = true;
	}
	
	public void desactivarLogginPorArchivo(){
		loggingPorArchivo = false;
	}
	
	public boolean perteneceAlFiltroElNivel(String nivel){
		LoggerLevels level = LoggerLevels.valueOf(nivel);
		return (level.getId() >= levelFilter.getId());
	}
	
	public boolean estaActivadoLoggPorConsola(){
		return loggingPorConsola;
	}
	
	public boolean estaActivadoLoggPorArchivo(){
		return loggingPorArchivo;
	}
	
	public void cargarArchivoProperties(){
	    Properties properties = new Properties();
	    try {
	      properties.load(new FileInputStream(RUTA_ARCHIVO_PROPERTIES));
	    } catch (IOException e) {
	    	System.out.println( "Error de archivo" );
	    	// TODO: Se podrían cargar todos valores por defecto sin depender del archivo
	    }
	    cargarValoresDeProperties(properties);
	}


    private void cargarValoresDeProperties(Properties properties){
        separator = properties.getProperty(SEPARADOR_ETIQUETA,SEPARADOR_VALOR_DEFAULT);
        String level = properties.getProperty(NIVEL_ETIQUETA,NIVEL_VALOR_DEFAULT); 
        nivelesDeLog =  LoggerLevels.valueOf(level);
        obtenerFormatos(properties);
    }


    private void obtenerFormatos(Properties properties){
    	String format = properties.getProperty(FORMATO_ETIQUETA,FORMATO_VALOR_DEFAULT);
    	dividirYCargarFormatos(format);
    }
    
    
    private void dividirYCargarFormatos(String format){
    	format = format.replaceAll(REGEX_ESPACIOS,"");
        String[] formatList = format.split("["+separator+"]"+REGEX_AGREGAR_SEPARADOR_DEFAULT);	
        cargarFormatos(formatList);
    }
    
    
    private void cargarFormatos(String[] formatList){
        for(String formatUnit:formatList){
        	// TODO: Cambiar los println's por la funcionalidad. OJO que hay que tener en cuenta la posición en el vector en la que se enuentra para replicarla a la hora de imprimir el log
        	if(formatUnit.startsWith(OPERADOR_PATRON)==false) System.out.println("cargo literal: "+formatUnit);
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_NIVEL)) System.out.println("cargo %p");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_HILO)) System.out.println("cargo %t");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_MENSAJE)) System.out.println("cargo %m");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+OPERADOR_PATRON)) System.out.println("cargo caracter: %");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_SEPARADOR)) System.out.println("cargo separador");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_LINEA)) System.out.println("cargo %L");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_ARCHIVO)) System.out.println("cargo %F");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_METODO)) System.out.println("cargo %M");
        	else if(formatUnit.startsWith(OPERADOR_PATRON+INDICADOR_FECHA)){
        		System.out.print("cargo valor fecha: ");
        		cargarFormatoHora(formatUnit);
        	}
        	
         }
    }
	

    private void cargarFormatoHora(String formatoDateObtenido){
    	String stringDateFormat = formatoDateObtenido.substring(3, formatoDateObtenido.length()-1);
   	   	simpleDateFormat = new SimpleDateFormat(stringDateFormat);
        System.out.println(simpleDateFormat.format(new Date()));	
    }
    



	
}
