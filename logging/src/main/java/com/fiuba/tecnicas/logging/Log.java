package com.fiuba.tecnicas.logging;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class Log {

		
	private Date date;
	private String level;
	LoggerSettings config;
	private String message;
	private String thread;
	
	public Log(String message, String level){
		this.message = message;
		date = new Date();
		this.level = level;
	}
	public Date getDate() {
		return this.date;
		
	}
	
	public String getSeparator(){
		System.out.println(this.config);
		return this.config.getSeparator();
	}
	public void save(){
		String messageToSave = getMessageToSave();
		if(this.config.consoleLogEnabled()){
			showMessage(messageToSave);
		}
		if(this.config.fileLogEnabled()){
			saveInFiles(messageToSave);
		}
	}
	private void showMessage(String messageToSave) {
		System.out.println(messageToSave);
	}
	
	private void saveInFiles(String messageToSave) {
		String[] filesName = config.getFilePaths();
		 for(String fileName:filesName){
			 
		 }
		
	}
	
	private String getMessageToSave() {
		MessageParser messageParser = new MessageParser(config.getFormat());
		messageParser.setLog(this);
		String messageToSave = messageParser.getMessage();
		return messageToSave;
	}
	public void setConfig(LoggerSettings config) {
		this.config = config;
		
	}
	public String getThread() {
		return this.thread;
	}
	public String getMessage() {
		return this.message;
		
	}
	public String getLevel() {
		return this.level;
	}

}
