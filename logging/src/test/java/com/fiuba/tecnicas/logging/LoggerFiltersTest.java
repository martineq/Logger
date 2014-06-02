package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoggerFiltersTest {

	@Test
	public void filterDefaultDoesNotRepresentAnyFilter() {
		LoggerFilters filter = new LoggerFilters();
		String message = "pasa la prueba";
		assertTrue(filter.matchesTheLoggerFilter(message));
	}
	
	@Test
	public void infoMessageDoesNotMatchTheWarnFilter() {
		LoggerFilters filter = new LoggerFilters();
		filter.setRegexFilter(".*WARN.*");
		String message = "12:57:53 + INFO + main + inicio";
		assertFalse(filter.matchesTheLoggerFilter(message));
	}
	
	@Test
	public void infoMessageMatchesTheInfoFilter() {
		LoggerFilters filter = new LoggerFilters();
		filter.setRegexFilter(".*INFO.*main.*");
		String message = "12:57:53 + INFO + main + inicio";
		assertTrue(filter.matchesTheLoggerFilter(message));
	}
	
	@Test
	public void infoMessageMatchesTheInfoMainFilter() {
		LoggerFilters filter = new LoggerFilters();
		filter.setRegexFilter(".*INFO.*\\+ main \\+.*");
		String message = "12:57:53 + INFO + main + inicio";
		assertTrue(filter.matchesTheLoggerFilter(message));
	}
	
	@Test
	public void infoMessageMatchesTheInfoInicioFilter() {
		LoggerFilters filter = new LoggerFilters();
		filter.setRegexFilter(".*INFO.*\\+ inicio");
		String message = "12:57:53 + INFO + main + inicio";
		assertTrue(filter.matchesTheLoggerFilter(message));
	}
	
	@Test
	public void infoMessageMatchesFormatFilter() {
		LoggerFilters filter = new LoggerFilters();
		filter.setRegexFilter("[0-2][0-9]:[0-5][0-9]:[0-5][0-9] \\+ INFO.*\\+ inicio");
		String message = "12:57:53 + INFO + main + inicio";
		assertTrue(filter.matchesTheLoggerFilter(message));
	}
	
	@Test
	public void infoMessageDoesNotMatchFormatFilter() {
		LoggerFilters filter = new LoggerFilters();
		filter.setRegexFilter("[0-2][0-9]:[0-5][0-9]:[0-5][0-9] \\+ INFO \\+ inicio \\+ main.*");
		String message = "12:57:53 + INFO + main + inicio";
		assertFalse(filter.matchesTheLoggerFilter(message));
	}
	
	
	@Test
	public void infoMessageDoesNotMatchTimeFilter() {
		LoggerFilters filter = new LoggerFilters();
		filter.setRegexFilter("1[4-9]:[0-5][0-9]:[0-5][0-9].*");
		String message = "12:57:53 + INFO + main + inicio";
		assertFalse(filter.matchesTheLoggerFilter(message));
	}
	
	@Test
	public void infoMessageMatchesTimeFilter() {
		LoggerFilters filter = new LoggerFilters();
		filter.setRegexFilter("1[0-2]:[0-5][0-9]:[0-5][0-9].*");
		String message = "12:57:53 + INFO + main + inicio";
		assertTrue(filter.matchesTheLoggerFilter(message));
	}
	
	@Test
	public void warnMessageMatchesTimeFilter() {
		LoggerFilters filter = new LoggerFilters();
		filter.setRegexFilter("1[0-2]:[0-5][0-9]:[0-5][0-9].*");
		String message = "12:57:53 + WARN + main + Warn De Prueba 2  Excepcion por un Warn + log1.txt log2.txt  + hola - fin";
		assertTrue(filter.matchesTheLoggerFilter(message));
	}
	
}
