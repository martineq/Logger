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
		assertEquals("valorSeparator",source.getValue("separator","valorSeparator", null));
	}

	@Test
	public final void testGetFormatValue() {
		assertEquals("valorFormat",source.getValue("format","valorFormat", null));
	}

	@Test
	public final void testGetLevelValue() {
		assertEquals("valorLevel",source.getValue("level","valorLevel", null));
	}

	@Test
	public final void testGetPathValue() {
		assertEquals("valorPath",source.getValue("path","valorPath", null));
	}

	@Test
	public final void testGetConsoleValue() {
		assertEquals("valorConsole",source.getValue("console","valorConsole", null));
	}

	@Test
	public final void testIsAvailable() {
		assertEquals(true,source.isAvailable());
	}

}
