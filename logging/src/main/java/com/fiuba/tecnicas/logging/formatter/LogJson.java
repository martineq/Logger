package com.fiuba.tecnicas.logging.formatter;

import java.util.Date;

import com.fiuba.tecnicas.logging.Log;
/**
 * 
 * Clase que toma los elementos de un log a formatearse en 
 * formato Json.
 *
 */
public class LogJson {

	private Date datetime;
	private String level;
	private Object logger;
	private String message;

	public LogJson(Log log) {
		this.setDatetime(log.getDate());
		this.setLevel(log.getLevel());
		this.setLogger(log.getLoggerName());
		this.setMessage(log.getMessage());
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Object getLogger() {
		return logger;
	}

	public void setLogger(Object logger) {
		this.logger = logger;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}




}
