package com.fiuba.tecnicas.logging;

public class MessagePattern extends Pattern{

	@Override
	public String getMessage() {
		return this.log.getMessage();
	}

}
