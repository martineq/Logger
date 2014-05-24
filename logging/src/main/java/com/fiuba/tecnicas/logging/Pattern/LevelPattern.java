package com.fiuba.tecnicas.logging.Pattern;




public class LevelPattern extends Pattern {

	@Override
	public String getMessage() {
		String message = this.log.getLevel();
		message += this.attribute;
		return message;
	}
	
	/**
	 * @see comentario de metodo setAttributes de ThreadPattern, pero en este caso con patron %p
	 */
	/*public void setAttributes(String attribute){
		this.attribute = attribute.substring(1);
	}*/
}
