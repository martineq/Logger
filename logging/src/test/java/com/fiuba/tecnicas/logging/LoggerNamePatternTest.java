package com.fiuba.tecnicas.logging;

import static org.junit.Assert.assertEquals;

import java.text.Format;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.fiuba.tecnicas.logging.formatter.UserFormatter;
import com.fiuba.tecnicas.logging.pattern.DatePattern;

public class LoggerNamePatternTest {
	@Test
	public void withGShowLoggerNameTest(){
		String messageToParse = "%g";
		Log log = new Log("ojo con el test","WARN");
		LoggerSettings setting = new LoggerSettings();
		log.setConfig(setting);
		UserFormatter userFormatter = new UserFormatter(messageToParse);
		userFormatter.setLog(log);
		assertEquals("LoggerTest",userFormatter.getMessage());
	}
}