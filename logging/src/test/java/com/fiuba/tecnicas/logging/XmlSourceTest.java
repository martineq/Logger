package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fiuba.tecnicas.logging.sourceSettings.SourceSettings;
import com.fiuba.tecnicas.logging.sourceSettings.XmlSource;

/**
 * @author Martin Quiroz
 *
 * Based on config.xml file, "LoggerTest" configuration.
 */
public class XmlSourceTest {

	private static SourceSettings source;

	@BeforeClass
	public static void setUpBeforeClass() {
		source = new XmlSource();
		source.load("config");
	}

	@Test
	public final void testGetSeparatorValue() {
		assertEquals("+",source.getValue("separator","otroValor","LoggerTest"));
	}

	@Test
	public final void testGetFormatValue() {
		assertEquals("%d{HH:mm:ss} + %p + %t %n %m + %F %n hola - fin",source.getValue("format","otroValor","LoggerTest"));
	}

	@Test
	public final void testGetLevelValue() {
		assertEquals("WARN",source.getValue("level","otroValor","LoggerTest"));
	}

	@Test
	public final void testGetPathValue() {
		assertEquals("log1.txt + log2.txt",source.getValue("path","otroValor","LoggerTest"));
	}

	@Test
	public final void testGetConsoleValue() {
		assertEquals("true",source.getValue("console","otroValor","LoggerTest"));
	}

	@Test
	public final void testIsAvailable() {
		assertEquals(true,source.isAvailable());
	}
	
	@Test
	public final void testGetRegexFilterValue() {
		assertEquals(".*INFO.*",source.getValue("regexFilter","otroValor","LoggerTest"));
	}
	
	@Test
	public final void testGetCustomFilterValue() {
		assertEquals("%m",source.getValue("customFilter","otroValor","LoggerTest"));
	}
	
	@Test
	public final void testGetCustomSaveValue() {
		assertEquals("com.fiuba.tecnicas.logging.MailAppender + arg_A + arg_B",source.getValue("customSave","otroValor","LoggerTest"));
	}

}
