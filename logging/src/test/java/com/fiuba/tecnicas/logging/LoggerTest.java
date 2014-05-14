package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoggerTest {
	
	@Test
	public void logAWarnTest() {
		Logger logger = Logger.getInstance();
		logger.getSettings().fileUploadProperties();
		logger.activate();
		logger.warn("Warn De Prueba para que lo veas x tv");
		
	}
	
	@Test
	public void IsActivatedShouldReturnTrue() {
		Logger logger = Logger.getInstance();
		assertTrue(logger.isActivated());
		
	}
	
	@Test
	public void thisEnabledThenDisableShouldReturnFalseTest() {
		Logger logger = Logger.getInstance();
		logger.deactivate();
		assertFalse(logger.isActivated());
		
	}
	
		
	
}
