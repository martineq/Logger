package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
	

}
