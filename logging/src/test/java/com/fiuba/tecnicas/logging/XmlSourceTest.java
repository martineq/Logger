package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fiuba.tecnicas.logging.sourceSettings.SourceSettings;
import com.fiuba.tecnicas.logging.sourceSettings.XmlSource;

/**
 * @author Martin Quiroz
 *
 *  config.xml file used:
 ********************************************************
 * <settings>
 *     <separator>+</separator>
 *     <format>%d{HH:mm:ss} + %p + %t %n %m + %F %n hola - fin</format>
 *     <level>WARN</level>
 *     <path>log1.txt + log2.txt</path>
 * 	   <console>true</console>
 *     <regexFilter>.*INFO.*</regexFilter>
 *     <customFilter>%p INFO .*%m Inicio de Programa .*</customFilter>
 *     <customSave>MailAppender</customSave></settings>
 * </settings>
 ********************************************************
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
		assertEquals("+",source.getValue("separator","otroValor"));
	}

	@Test
	public final void testGetFormatValue() {
		assertEquals("%d{HH:mm:ss} + %p + %t %n %m + %F %n hola - fin",source.getValue("format","otroValor"));
	}

	@Test
	public final void testGetLevelValue() {
		assertEquals("WARN",source.getValue("level","otroValor"));
	}

	@Test
	public final void testGetPathValue() {
		assertEquals("log1.txt + log2.txt",source.getValue("path","otroValor"));
	}

	@Test
	public final void testGetConsoleValue() {
		assertEquals("true",source.getValue("console","otroValor"));
	}

	@Test
	public final void testIsAvailable() {
		assertEquals(true,source.isAvailable());
	}
	
	@Test
	public final void testGetRegexFilterValue() {
		assertEquals(".*INFO.*",source.getValue("regexFilter","otroValor"));
	}
	
	@Test
	public final void testGetCustomFilterValue() {
		assertEquals("%p INFO .*%m Inicio de Programa .*",source.getValue("customFilter","otroValor"));
	}
	
	@Test
	public final void testGetCustomSaveValue() {
		assertEquals("MailAppender",source.getValue("customSave","otroValor"));
	}

}
