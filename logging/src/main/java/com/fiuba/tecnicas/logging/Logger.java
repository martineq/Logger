package com.fiuba.tecnicas.logging;

public class Logger {
	
	private boolean active;
	private LoggerSettings configuration;
	private String name;
	
	
	public Logger(String loggerName){
		name = loggerName;
		active = true;
		configuration = new LoggerSettings();
		configuration.setLoggerName(loggerName);
	}
	
	
	private void logMessage(String message, String nivel){
		if(canLog(nivel)){
			Log log = new Log(message,nivel);
			log.setConfig(configuration);
			log.save();
		}
			
	}
	
	private boolean canLog(String nivel) {
		return active && configuration.belongsToLevelFilter(nivel);
	}
	
	final public void trace(String mensaje){
		logMessage(mensaje,"TRACE");
	}
	
	final public void warn(String mensaje){
			logMessage(mensaje,"WARN");
		
	}
	
	final public void debug(String mensaje){
		logMessage(mensaje,"DEBUG");
	}
	
	final public void error(String mensaje){
		logMessage(mensaje,"ERROR");
	}
	
	final public void info(String mensaje){
		logMessage(mensaje,"INFO");
	}
	
	final public void fatal(String mensaje){
		logMessage(mensaje,"FATAL");		
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
	
	public String getName(){
		return this.name;
	}
}
