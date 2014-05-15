package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Martin Quiroz
 *
 *  config.properties file used:
 ********************************************************
 *	separator=+
 *	format=%d{HH:mm:ss} + %p + %t %n %m + %F %n hola - fin
 *	level=WARN
 *	path=log1.txt + log2.txt
 *	console=true
 ********************************************************
 */
public class LoggerSettingsTest {

	private static LoggerSettings loggerSettings;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		loggerSettings = new LoggerSettings();
		loggerSettings.fileUploadProperties();
	}

	@Test
	public void testGetLevelFilter() {
		assertEquals("WARN", loggerSettings.getLevelFilter().toString());
	}

	@Test
	public void testGetSeparator() {
		assertEquals("+", loggerSettings.getSeparator());
	}

	@Test
	public void testGetFilePaths() {
		String[] paths = new String[] { "log1.txt", "log2.txt" };
		assertArrayEquals(paths, loggerSettings.getFilePaths());
	}

	@Test
	public void testConsoleLogEnabled() {
		assertEquals(true,loggerSettings.consoleLogEnabled());
	}

	@Test
	public void testGetFormat() {
		assertEquals("%d{HH:mm:ss} + %p + %t %n %m + %F %n hola - fin",loggerSettings.getFormat());
	}

	@Test
	public void testFileLogEnabled() {
		assertEquals(true,loggerSettings.fileLogEnabled());
	}

	@Test
	public void warnBelongsToLevelFilterWarn() {
		assertTrue(loggerSettings.belongsToLevelFilter("WARN"));
	}
	
	@Test
	public void errorBelongsToLevelFilterWarn() {
		assertTrue(loggerSettings.belongsToLevelFilter("ERROR"));
	}
	
	@Test
	public void fatalBelongsToLevelFilterWarn() {
		assertTrue(loggerSettings.belongsToLevelFilter("FATAL"));
	}
	
	@Test
	public void debugDoesNotBelongToLevelFilterWarn() {
		assertFalse(loggerSettings.belongsToLevelFilter("DEBUG"));
	}
	
	@Test
	public void infoDoesNotBelongToLevelFilterWarn() {
		assertFalse(loggerSettings.belongsToLevelFilter("INFO"));
	}	

}
