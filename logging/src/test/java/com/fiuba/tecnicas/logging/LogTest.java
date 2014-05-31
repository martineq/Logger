package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class LogTest {
	
	private static LoggerSettings loggerSettings;
	
	/**
	 * definicion del setup, en el cual se crea un LoggerSettings y se levanta el archivo 
	 * propretie. Postereriormente se abren todos los archivos de loggeo (si es que hay) 
	 * para vaciar su contenido.
	 * @throws IOException
	 * 
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws IOException{
		loggerSettings = new LoggerSettings();
		loggerSettings.fileUploadProperties();
		String[] files = loggerSettings.getFilePaths();
		BufferedWriter bw = null;
		for(String fileName:files){
			bw = new BufferedWriter(new FileWriter(fileName));
			bw.write("");
			bw.close();
			}
	}
	
	
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
		String newSeparator = "+";
		log.setConfig(loggerSettings);
		assertEquals(log.getSeparator(),newSeparator);
	}
	
	/**
	 * comprobamos que en todos los archivos de loggeo se haya loggeado el mensaje correcto.
	 * 
	 */
	@Test
	public void saveLogInFileShouldWriteToTheAppropriateFilesTest(){
		Log log = new Log("inicion de programa","INFO");
		log.setConfig(loggerSettings);
		String messageToSave = log.save();
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    String[] files = loggerSettings.getFilePaths();
	    for(String fileName:files){
	    	try {
	    		archivo = new File (fileName);
	    		fr = new FileReader (archivo);
	    		br = new BufferedReader(fr);

	    		String linea;
	    		while((linea=br.readLine())!=null)
	    			assertEquals(linea,messageToSave);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
	}
	

}
