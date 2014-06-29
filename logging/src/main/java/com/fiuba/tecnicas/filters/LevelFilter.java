package com.fiuba.tecnicas.filters;


public class LevelFilter extends Filter {

	@Override
	public boolean passFilter() {
		return filter.matches(this.log.getLevel());
	}

}
