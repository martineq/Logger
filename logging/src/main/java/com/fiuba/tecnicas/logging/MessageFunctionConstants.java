package com.fiuba.tecnicas.logging;

import java.util.HashMap;
import java.util.Map;

import com.fiuba.tecnicas.logging.pattern.DatePattern;
import com.fiuba.tecnicas.logging.pattern.FilePattern;
import com.fiuba.tecnicas.logging.pattern.LevelPattern;
import com.fiuba.tecnicas.logging.pattern.LineNumberPattern;
import com.fiuba.tecnicas.logging.pattern.MessagePattern;
import com.fiuba.tecnicas.logging.pattern.MethodPattern;
import com.fiuba.tecnicas.logging.pattern.Pattern;
import com.fiuba.tecnicas.logging.pattern.SeparatorPattern;
import com.fiuba.tecnicas.logging.pattern.ThreadPattern;

public class MessageFunctionConstants {

	Map<String,Pattern> functions = new HashMap<String, Pattern>();
	
	public MessageFunctionConstants() {
		this.functions.put("d", new DatePattern());
		this.functions.put("p", new LevelPattern());
		this.functions.put("t", new ThreadPattern());
		this.functions.put("m", new MessagePattern());
		this.functions.put("n", new SeparatorPattern());
		this.functions.put("L", new LineNumberPattern());
		this.functions.put("F", new FilePattern());
		this.functions.put("M", new MethodPattern());
	}
	
	public Pattern getFunctionName(String pattern){
		
		return functions.get(pattern);
	}
}
