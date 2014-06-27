package com.fiuba.tecnicas.logging.formatter;

import com.fiuba.tecnicas.logging.Log;

public interface Formatter {

	void setLog(Log log);

	String getMessage();
	
	void setCustomFilters(String customFilters);


}
