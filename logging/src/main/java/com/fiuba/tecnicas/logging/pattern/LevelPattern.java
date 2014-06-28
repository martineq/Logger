package com.fiuba.tecnicas.logging.pattern;




public class LevelPattern extends Pattern {

	@Override
	public String getMessage() {
		String message = this.log.getLevel();
		
		return this.applyFilter(message);
	}
	
	@Override
	public boolean equals(Object object){
		return object instanceof LevelPattern;
	}
}
