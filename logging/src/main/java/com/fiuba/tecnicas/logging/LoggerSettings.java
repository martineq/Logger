package com.fiuba.tecnicas.logging;

import java.util.HashMap;
import java.util.Map;

public class LoggerSettings {
	
	//private LoggerLevels nivelesDeLogg;
	private LoggerLevels levelFilter;
	private String separator;
	private String rutaArchivoDestino;
	private String dateFormat;
	private boolean loggingPorConsola;
	private boolean loggingPorArchivo;
	
	
	public void LoggerSettings(){
		levelFilter = LoggerLevels.INFO;
		separator = "-";
		rutaArchivoDestino = "Log.txt";
		dateFormat = "HH:mm:ss";
		loggingPorArchivo = false;
		loggingPorConsola = true;
	}
	
	public void setLevelFilter(String nivel){
		levelFilter =  LoggerLevels.valueOf(nivel);
		
	}
	
	public void setSeparator(String sep){
		separator = sep  ;
		
	}
	
	public void setRutaArchivo(String file){
		rutaArchivoDestino = file;
		
	}
	
	public void setDateFormat(String formatoFecha){
		dateFormat = formatoFecha;
		
	}
	
	public String getLevelFilter(){
		return levelFilter.toString();
	}
	
	public String getSeparator(){
		return separator;
	}
	
	public String getDateFormat(){
		return dateFormat;
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
		loggingPorArchivo = true;
	}
}
