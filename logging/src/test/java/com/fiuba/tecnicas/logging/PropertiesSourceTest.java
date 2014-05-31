/**
 * 
 */
package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fiuba.tecnicas.logging.sourceSettings.PropertiesSource;
import com.fiuba.tecnicas.logging.sourceSettings.SourceSettings;

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
public class PropertiesSourceTest {

	private static SourceSettings source;

	@BeforeClass
	public static void setUpBeforeClass() {
		source = new PropertiesSource();
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

}
