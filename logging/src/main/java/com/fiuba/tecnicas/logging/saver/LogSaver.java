package com.fiuba.tecnicas.logging.saver;

import java.util.Date;

import com.fiuba.tecnicas.logging.LoggerSettings;

public abstract class LogSaver {
	public Date date;
	public String level;
	public LoggerSettings config;
	public String message;

	public LogSaver() {
	}

	public abstract String save(String messageToSave);
}