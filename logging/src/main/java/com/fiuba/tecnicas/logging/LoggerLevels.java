package com.fiuba.tecnicas.logging;

public enum LoggerLevels {
	INFO(0), DEBUG(1), WARN(2), ERROR(3), FATAL(4);
	
	private int valor;
	
	LoggerLevels(int p) {
	      valor = p;
	}
	
	public int getId() {
	      return valor;
	 } 
}
