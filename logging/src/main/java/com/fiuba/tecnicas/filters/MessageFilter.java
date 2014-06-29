package com.fiuba.tecnicas.filters;

public class MessageFilter extends Filter {

	@Override
	public boolean passFilter() {
		return filter.matches(this.log.getMessage());
	}

}
