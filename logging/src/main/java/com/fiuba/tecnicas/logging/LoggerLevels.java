package com.fiuba.tecnicas.logging;

public enum LoggerLevels {
	DEBUG(0), INFO(1), WARN(2), ERROR(3), FATAL(4);
	
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
