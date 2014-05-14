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
		loggerSettings.fileUploadProperties();
	}

	@Test
	public void testGetLevelFilter() {
		assertEquals("WARN", loggerSettings.getLoggerLevel().toString());
	}

	@Test
	public void testGetSeparator() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetFilePaths() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetSimpleDateFormat() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetLoggerLevel() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testConsoleLogEnabled() {
		fail("Not yet implemented"); // TODO
	}

}
