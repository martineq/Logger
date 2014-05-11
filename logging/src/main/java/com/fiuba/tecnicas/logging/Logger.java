package com.fiuba.tecnicas.logging;

public class Logger {
	
	private static Logger Instance = null;
	private static boolean activo = true;
	private Logger(){
		
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
	
	final public void warn(Message mensaje){
		
	}
	
	final public void debug(Message mensaje){
		
	}
	
	final public void error(Message mensaje){
		
	}
	
	final public void info(Message mensaje){
		
	}
	
	final public void fatal(Message mensaje){
		
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
