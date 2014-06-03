package com.fiuba.tecnicas.logging.saver;

import com.fiuba.tecnicas.logging.LoggerSettings;

public class ConsoleSaver extends LogSaver {

	private String error;

	public ConsoleSaver(String error) {
		this.error = error;
	}

	public ConsoleSaver() {
	}

	public ConsoleSaver(LoggerSettings loggerSettings) {
		this.config = loggerSettings;
	}

	@Override
	public String save(String messageToSave) {
		if(error!=null){
			System.out.println(error);
		}
		System.out.println(messageToSave);
		return messageToSave;
	}

}
