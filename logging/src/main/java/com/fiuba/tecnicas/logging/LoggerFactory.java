package com.fiuba.tecnicas.logging;

import java.util.HashMap;


public class LoggerFactory {
	private static LoggerFactory Instance = null;
	
	
	private static HashMap<String, Logger> loggerMap;

	
	private LoggerFactory(){
		loggerMap = new HashMap<String, Logger>();
	}
	
	public static LoggerFactory getInstance(){
		if (Instance == null) { 
            Instance = new LoggerFactory();
        }
		return Instance;
		
	}
	
	final public Logger getLogger(String loggerName){
		 Logger aLogger = loggerMap.get(loggerName);
		    if (aLogger == null) {
		     aLogger = new Logger(loggerName);
		     loggerMap.put(loggerName, aLogger);
		    }
		
		return aLogger;
	}
	
	/**
	 * @throws CloneNotSupportedException para que no se pueda clonar el objeto y poder cumplir
	 * 		 con las condiones del patron Singleton
	 */
	public Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException(); 
	}

}
