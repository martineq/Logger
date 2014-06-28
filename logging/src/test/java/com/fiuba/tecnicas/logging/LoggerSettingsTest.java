package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fiuba.tecnicas.logging.saver.LogSaver;

/**
 * @author Martin Quiroz
 *
 *  Based on config file selected (properties), "LoggerTest" configuration.
 */
public class LoggerSettingsTest {

	private static LoggerSettings loggerSettings;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		loggerSettings = new LoggerSettings();
		loggerSettings.fileUploadProperties("LoggerTest");
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
	public void testWarnBelongsToLevelFilterWarn() {
		assertTrue(loggerSettings.belongsToLevelFilter("WARN"));
	}
	
	@Test
	public void testErrorBelongsToLevelFilterWarn() {
		assertTrue(loggerSettings.belongsToLevelFilter("ERROR"));
	}
	
	@Test
	public void testFatalBelongsToLevelFilterWarn() {
		assertTrue(loggerSettings.belongsToLevelFilter("FATAL"));
	}
	
	@Test
	public void testDebugDoesNotBelongToLevelFilterWarn() {
		assertFalse(loggerSettings.belongsToLevelFilter("DEBUG"));
	}
	
	@Test
	public void testInfoDoesNotBelongToLevelFilterWarn() {
		assertFalse(loggerSettings.belongsToLevelFilter("INFO"));
	}
	
	@Test
	public void testTraceDoesNotBelongToLevelFilterWarn(){
		assertFalse(loggerSettings.belongsToLevelFilter("TRACE"));
	}

	@Test
	public void testGetSaverClass(){
		LogSaver logSaver = loggerSettings.getSaver();
		MailAppender mailAppender = (MailAppender) logSaver;
		assertTrue(mailAppender.save("hola").equals("Mail-hola"));
	}
	
	@Test
	public void testGetSaverArguments(){
		LogSaver logSaver = loggerSettings.getSaver();
		MailAppender mailAppender = (MailAppender) logSaver;
		assertTrue(mailAppender.getArgs().equals("arg_A arg_B"));
	}
	
	@Test
	public void testGetCustomFilters(){
		assertEquals("%m", loggerSettings.getCustomFilters());
	}	
	
}
