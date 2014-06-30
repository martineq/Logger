package com.fiuba.tecnicas.filters;

public class MethodFilter extends Filter {

	@Override
	public boolean passFilter() {
		int level = Thread.currentThread().getStackTrace().length -1 ;
		String message = Thread.currentThread().getStackTrace()[level].getMethodName(); 
		return message.matches(filter);
	}

}
