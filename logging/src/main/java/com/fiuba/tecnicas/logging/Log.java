package com.fiuba.tecnicas.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class Log {

		
	private Date date;
	private String level;
	LoggerSettings config;
	private String message;
	
	public static void main( String[] args ){
		
	}
	
	public Log(String message, String level){
		this.message = message;
		date = new Date();
		this.level = level;
	}

	public Date getDate() {
		return this.date;
		
	}
	
	public String getSeparator(){
		return this.config.getSeparator();
	}
	public String save(){
		String messageToSave = getMessageToSave();
		if(this.config.consoleLogEnabled()){
			showMessage(messageToSave);
		}
		if(this.config.fileLogEnabled()){
			saveInFiles(messageToSave);
		}
		return messageToSave;
	}
	private void showMessage(String messageToSave) {
		System.out.println(messageToSave);
	}
	
	private void saveInFiles(String messageToSave) {
		String[] filesName = config.getFilePaths();
		FileWriter file = null;
		PrintWriter pw = null;
		 for(String fileName:filesName){
			 try{
				 file = new FileWriter(fileName,true);
				 pw = new PrintWriter(file);
				 pw.println(messageToSave); //aca se escribe en el archivo lo que se va a loguear
			 }catch(IOException e){
				 e.printStackTrace();
				
			 }
			if(file != null){
				try{
					file.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		 }
		
	}
	
	/**
	 * 
	 * @return messageToSave, es el mensaje que realmente se debe loggear teniendo en cuenta
	 * 		   la configuracion del log y el formato del mensaje.
	 */
	private String getMessageToSave() {
		MessageParser messageParser = new MessageParser(config.getFormat());
		messageParser.setLog(this);
		String messageToSave = messageParser.getMessage();
		return messageToSave;
	}
	public void setConfig(LoggerSettings config) {
		this.config = config;
		
	}
	
	public String getMessage() {
		return this.message;
		
	}
	public String getLevel() {
		return this.level;
	}
	
	public String[] getFilePaths(){
		return this.config.getFilePaths();
	}
	

}
