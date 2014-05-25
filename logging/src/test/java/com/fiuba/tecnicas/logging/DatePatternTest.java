package com.fiuba.tecnicas.logging;

import org.junit.Test;

import com.fiuba.tecnicas.logging.pattern.DatePattern;

public class DatePatternTest {
	
	@Test
	public void detectInvalidDatePatternTest() { 
		String messageToParse = "%e{HH:mm:ss}";
		DatePattern datePattern  =  new DatePattern();
		datePattern.setAttributes(messageToParse);
	}


	
}
