package com.fiuba.tecnicas.logging.saver;

public class ConsoleSaver extends LogSaver {

	private String error;

	public ConsoleSaver(String error) {
		this.error = error;
	}

	public ConsoleSaver() {
	}

	@Override
	public String save(String messageToSave) {
		
		System.out.println(error);
		System.out.println(messageToSave);
		return "";
	}

}
