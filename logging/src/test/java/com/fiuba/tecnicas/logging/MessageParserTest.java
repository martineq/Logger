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
		Date date = new Date();
		MessageParser messageParser = new MessageParser(messageToParse,date);
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateformated = formatter.format(date);
		assertEquals(messageParser.getMessage(), dateformated);
    }	
	
	
}
