package com.fiuba.tecnicas.logging;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.fiuba.tecnicas.logging.formatter.UserFormatter;



import static org.junit.Assert.assertEquals;



public class MessageParserTest {
	
	@Test
    public void parseDateTest() {
		
		String messageToParse = " %d{HH:mm:ss}";
		Log log = new Log("ojo con el test","WARN");
		LoggerSettings setting = new LoggerSettings();
		log.setConfig(setting);
		UserFormatter userFormatter = new UserFormatter(messageToParse);
		userFormatter.setLog(log);
		userFormatter.setCustomFilters("");
		Format formatter = new SimpleDateFormat("HH:mm:ss");
		String dateformated = formatter.format(log.getDate());
		assertEquals(userFormatter.getMessage(), dateformated);
    }	
	
	@Test
    public void parseLevelTest() {
		
		String messageToParse = " %p";
		
		Log log = new Log("ojo con el test","WARN");
		LoggerSettings setting = new LoggerSettings();
		log.setConfig(setting);
		UserFormatter userFormatter = new UserFormatter(messageToParse);
		userFormatter.setLog(log);
		userFormatter.setCustomFilters("");
		assertEquals(userFormatter.getMessage(), "WARN");
    }	
	
	@Test
    public void parseMessageTest() {
		
		String messageToParse = " %m";
		Log log = new Log("ojo con el test","WARN");
		LoggerSettings setting = new LoggerSettings();
		log.setConfig(setting);
		UserFormatter userFormatter = new UserFormatter(messageToParse);
		userFormatter.setLog(log);
		userFormatter.setCustomFilters("");
		
		assertEquals(userFormatter.getMessage(), "ojo con el test");
    }
	
	
}
