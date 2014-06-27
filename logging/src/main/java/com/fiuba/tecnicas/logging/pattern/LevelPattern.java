package com.fiuba.tecnicas.logging.pattern;




public class LevelPattern extends Pattern {

	@Override
	public String getMessage() {
		String message = this.log.getLevel();
		
		String result = this.applyFilter(message);
		return result.equals("") ? "" :message + attribute;
	}
	
	@Override
	public boolean equals(Object object){
		return object instanceof LevelPattern;
	}
}
