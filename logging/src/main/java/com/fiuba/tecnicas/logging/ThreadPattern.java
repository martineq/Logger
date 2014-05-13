package com.fiuba.tecnicas.logging;

public class ThreadPattern extends Pattern {

	@Override
	public String getMessage() {
		return this.log.getThread();
	}

}
