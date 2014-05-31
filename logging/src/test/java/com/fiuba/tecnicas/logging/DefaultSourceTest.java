/**
 * 
 */
package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fiuba.tecnicas.logging.sourceSettings.DefaultSource;
import com.fiuba.tecnicas.logging.sourceSettings.SourceSettings;

/**
 * @author Mart
 *
 */
public class DefaultSourceTest {

	private static SourceSettings source;

	@BeforeClass
	public static void setUpBeforeClass() {
		source = new DefaultSource();
		source.load("config");
	}

	@Test
	public final void testGetSeparatorValue() {
		assertEquals("valorSeparator",source.getValue("separator","valorSeparator"));
	}

	@Test
	public final void testGetFormatValue() {
		assertEquals("valorFormat",source.getValue("format","valorFormat"));
	}

	@Test
	public final void testGetLevelValue() {
		assertEquals("valorLevel",source.getValue("level","valorLevel"));
	}

	@Test
	public final void testGetPathValue() {
		assertEquals("valorPath",source.getValue("path","valorPath"));
	}

	@Test
	public final void testGetConsoleValue() {
		assertEquals("valorConsole",source.getValue("console","valorConsole"));
	}

	@Test
	public final void testIsAvailable() {
		assertEquals(true,source.isAvailable());
	}

}
