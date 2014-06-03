package com.fiuba.tecnicas.logging.saver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.fiuba.tecnicas.logging.LoggerSettings;


public class FileSaver extends LogSaver {

	public FileSaver(LoggerSettings loggerSettings) {
		this.config = loggerSettings;
	}

	@Override
	public String save(String messageToSave) {
		
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
		 return "";
	}

}
