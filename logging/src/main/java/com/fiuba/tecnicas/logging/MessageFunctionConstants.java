package com.fiuba.tecnicas.logging;

import java.util.HashMap;
import java.util.Map;

import com.fiuba.tecnicas.logging.Pattern.DatePattern;
import com.fiuba.tecnicas.logging.Pattern.FilePattern;
import com.fiuba.tecnicas.logging.Pattern.LevelPattern;
import com.fiuba.tecnicas.logging.Pattern.LineNumberPattern;
import com.fiuba.tecnicas.logging.Pattern.MessagePattern;
import com.fiuba.tecnicas.logging.Pattern.MethodPattern;
import com.fiuba.tecnicas.logging.Pattern.Pattern;
import com.fiuba.tecnicas.logging.Pattern.SeparatorPattern;
import com.fiuba.tecnicas.logging.Pattern.ThreadPattern;

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
