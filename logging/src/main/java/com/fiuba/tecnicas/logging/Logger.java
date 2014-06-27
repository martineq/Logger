package com.fiuba.tecnicas.logging;

import com.fiuba.tecnicas.logging.logException.LoggerException;



public class Logger {
	
	protected boolean active;
	protected LoggerSettings configuration;
	protected String name;
	private LoggerException logger;
	
	
	public Logger(String loggerName){
		name = loggerName;
		active = true;
		configuration = new LoggerSettings();
		configuration.setLoggerName(loggerName);
		this.getSettings().fileUploadProperties();
		this.activate();
	}

	private void initLoggerException() {
		if(logger == null)
			logger = new LoggerException(name);
		logger.setConfiguration(configuration);
	}
	
	public void setConfiguration(LoggerSettings configuration) {
		this.configuration = configuration;
		
	}
	
	private void logMessage(String message, String nivel){
		if(canLog(nivel)){
			Log log = new Log(message,nivel);
			log.setConfig(configuration);
			log.save();
		}
			
	}
	
	protected boolean canLog(String nivel) {
		return active && configuration.belongsToLevelFilter(nivel);
	}
	
	public void trace(String mensaje){
		logMessage(mensaje,"TRACE");
	}
	
	public void trace(String mensaje,Throwable exception){
		logException(exception, mensaje,"TRACE");
	}

	private void logException(Throwable exception, String mensaje,String type) {
		this.initLoggerException();
		logger.logMessage(mensaje,exception,type);
	}
	
	final public void warn(String mensaje){
			logMessage(mensaje,"WARN");
		
	}
	
	final public void warn(String mensaje,Throwable exception){
		logException(exception, mensaje,"WARN");
	
	}
	
	final public void debug(String mensaje){
		logMessage(mensaje,"DEBUG");
	}
	
	final public void debug(String mensaje,Throwable exception){
		logException(exception, mensaje,"DEBUG");
	}
	
	final public void error(String mensaje){
		logMessage(mensaje,"ERROR");
	}
	
	final public void error(String mensaje,Throwable exception){
		logException(exception, mensaje,"ERROR");
	}
	
	final public void info(String mensaje){
		logMessage(mensaje,"INFO");
	}
	
	final public void info(String mensaje,Throwable exception){
		logException(exception, mensaje,"INFO");
	}
	
	final public void fatal(String mensaje){
		logMessage(mensaje,"FATAL");		
	}
	
	final public void fatal(String mensaje,Throwable exception){
		logException(exception, mensaje,"FATAL");
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
