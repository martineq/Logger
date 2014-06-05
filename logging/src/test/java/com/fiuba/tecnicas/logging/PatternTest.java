package com.fiuba.tecnicas.logging;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fiuba.tecnicas.logging.pattern.FilePattern;
import com.fiuba.tecnicas.logging.pattern.LevelPattern;
import com.fiuba.tecnicas.logging.pattern.MessagePattern;

public class PatternTest {

	@Test
	public void getMessageOfLevelPatternWithTraceLogAndFilterTraceOrInfoShouldReturnTrace() {
		Log aLog = new Log("contenido del mensaje","TRACE");
		LevelPattern aPattern = new LevelPattern();
		aPattern.setLog(aLog);
		aPattern.setAttributes(" ");
		aPattern.addFilter("pTRACE|INFO");
		assertEquals(aPattern.getMessage(),"TRACE");
		
	}
	
	@Test
	public void getMessageOfLevelPatternWithInfoLogAndFilterTraceOrInfoShouldReturnInfo() {
		Log aLog = new Log("contenido del mensaje","INFO");
		LevelPattern aPattern = new LevelPattern();
		aPattern.setLog(aLog);
		aPattern.setAttributes(" ");
		aPattern.addFilter("pTRACE|INFO");
		assertEquals(aPattern.getMessage(),"INFO");
		
	}
	
	@Test
	public void getMessageOfMessagePatternWithMessageThatDoesNotMatchTheFilterShouldReturnEmptyString(){
		Log aLog = new Log("contenido del mensaje","INFO");
		MessagePattern aPattern = new MessagePattern();
		aPattern.setLog(aLog);
		aPattern.addFilter("m^A.*");
		assertEquals(aPattern.getMessage(),"");
	}
		
		
	@Test
	public void getMessageOfMessagePatternWithMessageMatchesTheFilterShouldReturnTheLogMessage(){
		Log unLog = new Log("contenido del mensaje","INFO");
		MessagePattern aPattern = new MessagePattern();
		aPattern.setLog(unLog);
		aPattern.setAttributes("m");
		aPattern.addFilter("m.*del.*");
		assertEquals(aPattern.getMessage(),"contenido del mensaje");
		
	}

}
