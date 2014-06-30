package com.fiuba.tecnicas.logging.formatter;

import com.fiuba.tecnicas.logging.Log;
import com.google.gson.Gson;
/**
 * 
 * Clase que formatea como JSON
 *
 */
public class JsonFormatter extends Formatter {

	
	@Override
	public void setLog(Log log) {
		this.log = log;
		
	}

	@Override
	public String getMessage() {
		this.parseFilters();
		if (isAValidMessage()){
			return this.formatMessage();
		}
		return "";	
	}

	

	private String formatMessage() {
		LogJson logJson = new LogJson(log);
		Gson gson = new Gson();
		String json = gson.toJson(logJson);
		return json;
	}


	@Override
	public void setCustomFilters(String customFilters) {
		this.customFilters = customFilters;
		
		
	}



}
