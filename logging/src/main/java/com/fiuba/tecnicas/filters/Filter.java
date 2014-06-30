package com.fiuba.tecnicas.filters;

import com.fiuba.tecnicas.logging.Log;

public abstract class Filter {

	protected String filter ="";
	protected Log log;
	
	public void setAttributes(String filter) {
		this.filter = filter.substring(1);
	}

	public void setLog(Log log) {
		this.log = log;
		
	}

	public abstract boolean passFilter();

}
