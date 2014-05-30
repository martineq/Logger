package com.fiuba.tecnicas.logging;

public class LoggerFactory {
	private static LoggerFactory Instance = null;
	
	private LoggerFactory(){
		
	}
	
	public static LoggerFactory getInstance(){
		if (Instance == null) { 
            Instance = new LoggerFactory();
        }
		return Instance;
		
	}
	
	final public Logger getLogger(String loggerName){
		return new Logger(loggerName);
	}
	
	/**
	 * @throws CloneNotSupportedException para que no se pueda clonar el objeto y poder cumplir
	 * 		 con las condiones del patron Singleton
	 */
	public Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException(); 
	}

}
