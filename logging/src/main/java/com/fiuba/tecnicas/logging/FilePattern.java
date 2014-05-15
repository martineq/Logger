package com.fiuba.tecnicas.logging;

public class FilePattern  extends Pattern{

	@Override
	public String getMessage() {
		String message = "";
		for(String fileName : log.getFilePaths()){
			message += fileName;
			message += " ";
		}
		message += this.attribute;
		return message;
	}
	
	
	/**
	 * @see comentario de metodo setAttributes de ThreadPattern, pero en este caso con patron %F
	 */
	public void setAttributes(String attribute){
		this.attribute = attribute.substring(1);
	}

}
