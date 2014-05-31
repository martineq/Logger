package com.fiuba.tecnicas.logging.formatter;

import com.fiuba.tecnicas.logging.Log;
import com.google.gson.Gson;

public class JsonFormatter implements Formatter {

	private Log log;

	@Override
	public void setLog(Log log) {
		this.log = log;
		
	}

	@Override
	public String getMessage() {
		return this.formatMessage();
	}

	private String formatMessage() {
		LogJson logJson = new LogJson(log);
		Gson gson = new Gson();
		String json = gson.toJson(logJson);
		return json;
	}

}
