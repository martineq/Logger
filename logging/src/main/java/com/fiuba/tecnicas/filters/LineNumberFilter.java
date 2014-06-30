package com.fiuba.tecnicas.filters;

public class LineNumberFilter extends Filter {

	@Override
	public boolean passFilter() {
		int level = Thread.currentThread().getStackTrace().length -1 ;
		String number = String.valueOf(Thread.currentThread().getStackTrace()[level].getLineNumber()); 
		return number.matches(this.filter);
	}

}
