package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fiuba.tecnicas.logging.formatter.JsonFormatter;
import com.fiuba.tecnicas.logging.formatter.LogJson;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonFormatTest {
	
	@Test
	public void logMessageAsJsonTest(){
		LoggerSettings setting = new LoggerSettings();
		Log log = new Log("Debug en json", "DEBUG");
		log.setConfig(setting);
		JsonFormatter formatter = new JsonFormatter();
		formatter.setLog(log);
		
		String myJSONString = formatter.getMessage();
		
		LogJson logJson = new Gson().fromJson(myJSONString, LogJson.class);
		
		assertEquals("Debug en json",logJson.getMessage());
	}
	
	
	@Test
	public void logLevelAsJsonTest(){
		LoggerSettings setting = new LoggerSettings();
		Log log = new Log("Debug en json", "DEBUG");
		log.setConfig(setting);
		JsonFormatter formatter = new JsonFormatter();
		formatter.setLog(log);
		
		String myJSONString = formatter.getMessage();
		
		LogJson logJson = new Gson().fromJson(myJSONString, LogJson.class);
		
		assertEquals("DEBUG",logJson.getLevel());
	}
}
