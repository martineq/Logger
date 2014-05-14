package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;

import org.junit.Test;

public class LogTest {
	
	@Test
	public void getMessageTest(){
		Log log = new Log("este es un log","INFO");
		assertEquals("este es un log",log.getMessage());
	}
	
	@Test
	public void getLevelTest(){
		Log log = new Log("este es un log","INFO");
		assertEquals("INFO",log.getLevel());
	}
	
	@Test
	public void getCurrentDateLogTest(){
		Log log = new Log("este es un log","WARN");
		Date fechaActual = new java.util.Date(); 
		assertEquals(fechaActual.toString(),log.getDate().toString());
	}
	
	@Test
	public void getSeparatorShouldReturnDefaultSeparatorTest(){
		Log log = new Log("error de fichero","FATAL");
		LoggerSettings setting = new LoggerSettings();
		log.setConfig(setting);
		assertEquals("-",log.getSeparator());
		
	}
	
	@Test
	public void getSeparatorShouldReturnTheNewSeparatorTest(){
		Log log = new Log("inicio programa","INFO");
		LoggerSettings setting = new LoggerSettings();
		String newSeparator = "+";
		log.setConfig(setting);
		setting.fileUploadProperties();
		assertEquals(log.getSeparator(),newSeparator);
	}
	
	

}
