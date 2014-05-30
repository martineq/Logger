package com.fiuba.tecnicas.logging;

public enum LoggerLevels {
	TRACE(0), DEBUG(1), INFO(2), WARN(3), ERROR(4), FATAL(5);
	
	private int valor;
	
	LoggerLevels(int p) {
	      valor = p;
	}
	
	public int getId() {
	      return valor;
	 }

	public boolean lessThanOrEqual(String enumerator){
		LoggerLevels level = LoggerLevels.valueOf(enumerator);
		return (level.getId() >= this.getId());
	}
}
