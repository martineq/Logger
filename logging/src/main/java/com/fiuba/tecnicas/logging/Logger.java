package com.fiuba.tecnicas.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	
	private static Logger Instance = null;
	private static boolean active = true;
	private static LoggerSettings configuration;
	
	private Logger(){
		configuration = new LoggerSettings();
	}
	public static Logger getInstance(){
		if (Instance == null) { 
            Instance = new Logger();
           Instance.activate();
        }
		return Instance;
		
	}
	
	/**
	 * @throws CloneNotSupportedException para que no se pueda clonar el objeto y poder cumplir
	 * 		 con las condiones del patron Singleton
	 */
	public Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException(); 
	}
	
	final private void loggMessage(String message, String nivel){
		if(canLog(nivel)){
			Log log = new Log(message,nivel);
			log.setConfig(configuration);
			log.save();
		}
			
				
			
		
	}
	private boolean canLog(String nivel) {
		return active && configuration.belongsToLevelFilter(nivel);
	}
	
	final public void warn(String mensaje){
			loggMessage(mensaje,"WARN");
		
	}
	
	final public void debug(String mensaje){
		loggMessage(mensaje,"DEBUG");
	}
	
	final public void error(String mensaje){
		loggMessage(mensaje,"ERROR");
	}
	
	final public void info(String mensaje){
		loggMessage(mensaje,"INFO");
	}
	
	final public void fatal(String mensaje){
		loggMessage(mensaje,"FATAL");		
	}
	
	final public LoggerSettings getSettings(){
		return configuration;
	}
	
	final public void activate(){
		active = true;
	}
	
	final public void deactivate(){
		active = false;
	}
	
	final public boolean isActivated(){
		return active;
	}
	
}
