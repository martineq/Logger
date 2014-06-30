package com.fiuba.tecnicas.filters;


public class LevelFilter extends Filter {

	@Override
	public boolean passFilter() {
		return this.log.getLevel().matches(filter);
	}

}
