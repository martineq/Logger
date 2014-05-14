package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Martín Quiroz
 *
 *
 *  config.properties file used:
 ********************************************************
 *	separator=+
 *	format=%d{HH:mm:ss} + %p + %t %n %m + %F %n hola - fin
 *	level=WARN
 *	path=C:\\ + C:\\logs
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
		String[] paths = new String[] { "C:\\", "C:\\logs" };
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
	public void testBelongsToLevelFilter() {
		assertEquals(true,loggerSettings.belongsToLevelFilter("WARN"));
		assertEquals(true,loggerSettings.belongsToLevelFilter("FATAL"));
		assertEquals(false,loggerSettings.belongsToLevelFilter("INFO"));
	}

}
