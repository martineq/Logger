package com.fiuba.tecnicas.logging.saver;

import com.fiuba.tecnicas.logging.LoggerSettings;


public class MultifunctionSaver extends LogSaver {
	
	private ConsoleSaver inConsole;
	private FileSaver inFile;
	
	public MultifunctionSaver(LoggerSettings loggerSettings){
		this.config = loggerSettings;
		inConsole = new ConsoleSaver();
		inFile = new FileSaver(this.config);
		
	}
	
	@Override
	public String save(String messageToSave) {
		
		inFile.save(messageToSave);
		return inConsole.save(messageToSave);
	}

}
