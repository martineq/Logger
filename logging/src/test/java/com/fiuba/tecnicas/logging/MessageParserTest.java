package com.fiuba.tecnicas.logging;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


import static org.junit.Assert.assertEquals;



public class MessageParserTest {
	
	@Test
    public void parseDate() {
		
		String messageToParse = "%d{HH:mm:ss}";
		Log log = new Log("WARN");
		MessageParser messageParser = new MessageParser(messageToParse);
		messageParser.setLog(log);
		Format formatter = new SimpleDateFormat("HH:mm:ss");
		String dateformated = formatter.format(log.getDate());
		assertEquals(messageParser.getMessage(), dateformated);
    }	
	
	
}
