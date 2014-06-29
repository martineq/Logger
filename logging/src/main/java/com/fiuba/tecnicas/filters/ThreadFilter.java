package com.fiuba.tecnicas.filters;

public class ThreadFilter extends Filter {

	@Override
	public boolean passFilter() {
		String message = Thread.currentThread().getName();
		return filter.matches(message);
	}

}
