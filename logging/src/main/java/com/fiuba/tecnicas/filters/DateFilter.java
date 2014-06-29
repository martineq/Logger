package com.fiuba.tecnicas.filters;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DateFilter extends Filter {

	@Override
	public boolean passFilter() {
		return filter.matches(parseAttribute());
	}
	
	private String parseAttribute() {
		Date date = this.log.getDate();
		Format formatter = new SimpleDateFormat("EEE, MMM d, HH:mm:ss");
		String dateformated = formatter.format(date);
		return dateformated;
	}
}
