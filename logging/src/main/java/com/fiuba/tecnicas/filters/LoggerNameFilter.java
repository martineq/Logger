package com.fiuba.tecnicas.filters;

public class LoggerNameFilter extends Filter {

	@Override
	public boolean passFilter() {
		return this.log.getLoggerName().matches(filter);
	}

}
