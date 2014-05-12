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
	
	final private void loggearMensaje(Message message, String nivel) throws LoggerInactivoException{
		if(activo){
			if(configuracion.perteneceAlFiltroElNivel(nivel)){
				if(configuracion.estaActivadoLoggPorArchivo()){
					FileWriter fichero = null;
					PrintWriter pw = null;
					try{
						fichero = new FileWriter(configuracion.getRutaArchivo(),true);
						pw = new PrintWriter(fichero);
						//pw.println(evento); //aca se escribe en el archivo lo que se va a loguear
					}catch(IOException e){
						e.printStackTrace();
					}
					if(fichero != null){
						try{
							fichero.close();
						}catch(IOException e){
							e.printStackTrace();
						}
					}
						
				}
				if(configuracion.estaActivadoLoggPorConsola()){
					//System.out.println(evento) //se escribe por consola lo que se va a loggear
				}
			}
		}else
			throw new LoggerInactivoException();
	}
	
	final public void warn(Message mensaje){
		try{
			loggearMensaje(mensaje,"WARN");
		
		}catch(LoggerInactivoException e){
			e.printStackTrace();
		}
		
	}
	
	final public void debug(Message mensaje){
		try{
			loggearMensaje(mensaje,"DEBUG");
		
		}catch(LoggerInactivoException e){
			e.printStackTrace();
		}
	}
	
	final public void error(Message mensaje){
		try{
			loggearMensaje(mensaje,"ERROR");
		
		}catch(LoggerInactivoException e){
			e.printStackTrace();
		}
	}
	
	final public void info(Message mensaje){
		try{
			loggearMensaje(mensaje,"INFO");
		
		}catch(LoggerInactivoException e){
			e.printStackTrace();
		}
	}
	
	final public void fatal(Message mensaje){
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
