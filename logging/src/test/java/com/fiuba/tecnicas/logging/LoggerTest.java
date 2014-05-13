package com.fiuba.tecnicas.logging;

import org.junit.Test;

public class LoggerTest {
	
	@Test
	public void logAWarnTest() {
		Logger logger = Logger.getInstance();
		logger.warn("Warn De Prueba para que lo veas x tv");
		
	}
}
