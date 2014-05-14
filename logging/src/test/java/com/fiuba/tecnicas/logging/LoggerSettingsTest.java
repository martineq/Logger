package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Mart
 *
 */
public class LoggerSettingsTest {

	private LoggerSettings loggerSettings;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		loggerSettings = new LoggerSettings();
		//loggerSettings.fileUploadProperties();
	}

	@Test
	public void testGetLevelFilter() {
		assertEquals("INFO", loggerSettings.getLoggerLevel().toString());
	}
	
	
	@Test
	public void testGetSeparatorShouldReturnTheDefaultSeparator() {
		String defaultSeparator = "-";
		assertEquals(defaultSeparator, loggerSettings.getSeparator());
	}
	
	
	@Test
	public void testGetSimpleDateFormatShouldReturnTheDefaultDateFormat() {
		String defaultSimpleDateFormat = "HH:mm:ss";
		assertEquals(defaultSimpleDateFormat,loggerSettings.getSimpleDateFormat().toPattern());
	}
	

	@Test
	public void testConsoleLogEnabledShouldBeTrue() {
		assertTrue(loggerSettings.consoleLogEnabled());
	}

}
