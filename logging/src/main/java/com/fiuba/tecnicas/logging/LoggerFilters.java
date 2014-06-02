package com.fiuba.tecnicas.logging;

public class LoggerFilters {
	
	private String userRegex;
	
	
	
	public LoggerFilters(){
		userRegex = ".*";
	}
	
	public void setRegexFilter(String regex){
		userRegex = regex;
	}
	
	public boolean matchesTheLoggerFilter(String logMsg){
		//String[] matchResult = logMsg. split(userRegex);
		//System.out.println(matchResult.length);
		//si tiene tamaño mayor a 1 es porque no todo el mensaje cumplia con el patron de userRegex
		return (logMsg.matches(userRegex));
		
	}

}
