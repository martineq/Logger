package com.fiuba.tecnicas.logging;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


import static org.junit.Assert.assertEquals;



public class MessageParserTest {
	
	@Test
    public void parseDateTest() {
		
		String messageToParse = "%d{HH:mm:ss}";
		Log log = new Log("ojo con el test","WARN");
		LoggerSettings setting = new LoggerSettings();
		log.setConfig(setting);
		MessageParser messageParser = new MessageParser(messageToParse);
		messageParser.setLog(log);
		Format formatter = new SimpleDateFormat("HH:mm:ss");
		String dateformated = formatter.format(log.getDate());
		assertEquals(messageParser.getMessage(), dateformated);
    }	
	
	@Test
    public void parseLevelTest() {
		
		String messageToParse = "%p";
		
		Log log = new Log("ojo con el test","WARN");
		LoggerSettings setting = new LoggerSettings();
		log.setConfig(setting);
		MessageParser messageParser = new MessageParser(messageToParse);
		messageParser.setLog(log);
		
		assertEquals(messageParser.getMessage(), "WARN");
    }	
	
	@Test
    public void parseMessageTest() {
		
		String messageToParse = "%m";
		Log log = new Log("ojo con el test","WARN");
		LoggerSettings setting = new LoggerSettings();
		log.setConfig(setting);
		MessageParser messageParser = new MessageParser(messageToParse);
		messageParser.setLog(log);
		
		assertEquals(messageParser.getMessage(), "ojo con el test");
    }
	
	
}
