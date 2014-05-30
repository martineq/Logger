package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoggerTest {
	
	@Test
	public void logAWarnTest() {
		LoggerFactory loggerFactory = LoggerFactory.getInstance();
		Logger unLogger = loggerFactory.getLogger("Logger A");
		unLogger.getSettings().fileUploadProperties();
		unLogger.activate();
		unLogger.warn("Warn De Prueba");
		
	}
	
	@Test
	public void IsActivatedShouldReturnTrue() {
		LoggerFactory loggerFactory = LoggerFactory.getInstance();
		Logger unLogger = loggerFactory.getLogger("Logger A");
		assertTrue(unLogger.isActivated());
		
	}
	
	@Test
	public void thisEnabledThenDisableShouldReturnFalseTest() {
		LoggerFactory loggerFactory = LoggerFactory.getInstance();
		Logger unLogger = loggerFactory.getLogger("Logger A");
		unLogger.deactivate();
		assertFalse(unLogger.isActivated());
		
	}
	
	@Test
	public void getNameShouldReturnTheLoggerName(){
		LoggerFactory loggerFactory = LoggerFactory.getInstance();
		Logger unLogger = loggerFactory.getLogger("Logger B");
		assertEquals("Logger B",unLogger.getName());
		
	}
	
		
	
}
