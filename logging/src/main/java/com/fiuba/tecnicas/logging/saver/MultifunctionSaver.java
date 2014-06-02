package com.fiuba.tecnicas.logging.saver;


public class MultifunctionSaver extends LogSaver {
	
	private ConsoleSaver inConsole;
	private FileSaver inFile;
	
	public MultifunctionSaver(){
		inConsole = new ConsoleSaver();
		inFile = new FileSaver();
		
	}
	@Override
	public String save(String messageToSave) {
		inFile.save(messageToSave);
		return inConsole.save(messageToSave);
	}

}
