package com.fiuba.tecnicas.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	
	private static Logger Instance = null;
	private static boolean activo = true;
	private static LoggerSettings configuracion;
	
	private Logger(){
		configuracion = new LoggerSettings();
	}
	public static Logger getInstance(){
		if (Instance == null) { 
            Instance = new Logger();
        }
		return Instance;
		
	}
	
	public Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException(); 
	}
	
	final private void loggearMensaje(String message, String nivel) throws LoggerInactivoException{
		if(canLog(nivel)){
			Log log = new Log(nivel);
			log.setConfig(configuracion);
			log.save();
		}
			
				
			
		
	}
	private boolean canLog(String nivel) {
		return activo && configuracion.perteneceAlFiltroElNivel(nivel);
	}
	
	final public void warn(String mensaje){
		try{
			loggearMensaje(mensaje,"WARN");
		
		}catch(LoggerInactivoException e){
			e.printStackTrace();
		}
		
	}
	
	final public void debug(String mensaje){
		try{
			loggearMensaje(mensaje,"DEBUG");
		
		}catch(LoggerInactivoException e){
			e.printStackTrace();
		}
	}
	
	final public void error(String mensaje){
		try{
			loggearMensaje(mensaje,"ERROR");
		
		}catch(LoggerInactivoException e){
			e.printStackTrace();
		}
	}
	
	final public void info(String mensaje){
		try{
			loggearMensaje(mensaje,"INFO");
		
		}catch(LoggerInactivoException e){
			e.printStackTrace();
		}
	}
	
	final public void fatal(String mensaje){
		try{
			loggearMensaje(mensaje,"FATAL");
		
		}catch(LoggerInactivoException e){
			e.printStackTrace();
		}
		
	}
	
	final public LoggerSettings getSettings(){
		return configuracion;
	}
	
	final public void activar(){
		activo = true;
	}
	
	final public void desactivar(){
		activo = false;
	}
	
	final public boolean EstaActivado(){
		return activo;
	}
	
}
