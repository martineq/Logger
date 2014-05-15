package com.fiuba.tecnicas.logging;

public class ThreadPattern extends Pattern {

	@Override
	public String getMessage() {
		String message = Thread.currentThread().getName();
		message += this.attribute;
		return message;
	}
	
	
	/** nos quedamos en el atributo attribute con el string comprendido entre patron %t 
	 * y el proximo % o fin de linea.
	 * @param attribute , string que continua despues del %, hasta el proximo patron
	 *  (proximo %).
	 */
	public void setAttributes(String attribute){
		this.attribute = attribute.substring(1);
	}

}
