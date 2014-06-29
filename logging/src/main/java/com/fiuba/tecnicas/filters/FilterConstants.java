package com.fiuba.tecnicas.filters;

import java.util.HashMap;
import java.util.Map;


import com.fiuba.tecnicas.logging.pattern.DatePattern;
import com.fiuba.tecnicas.logging.pattern.FilePattern;
import com.fiuba.tecnicas.logging.pattern.LevelPattern;
import com.fiuba.tecnicas.logging.pattern.LineNumberPattern;
import com.fiuba.tecnicas.logging.pattern.LoggerNamePattern;
import com.fiuba.tecnicas.logging.pattern.MessagePattern;
import com.fiuba.tecnicas.logging.pattern.MethodPattern;
import com.fiuba.tecnicas.logging.pattern.Pattern;
import com.fiuba.tecnicas.logging.pattern.SeparatorPattern;
import com.fiuba.tecnicas.logging.pattern.ThreadPattern;

public class FilterConstants {

	Map<String,Filter> functions = new HashMap<String, Filter>();
	
	public FilterConstants() {
		this.functions.put("d", new DateFilter());
		this.functions.put("p", new LevelFilter());
		this.functions.put("t", new ThreadFilter());
		this.functions.put("m", new MessageFilter());
		this.functions.put("L", new LineNumberFilter());
		this.functions.put("F", new FileFilter());
		this.functions.put("M", new MethodFilter());
		this.functions.put("g", new LoggerNameFilter());
	}
	
	public Filter getFunctionName(String pattern){
		
		return functions.get(pattern);
	}
}
