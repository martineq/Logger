package com.fiuba.tecnicas.logging;

import java.util.HashMap;
import java.util.Map;

public class MessageFunctionConstants {

	Map<String,String> functions = new HashMap<String, String>();
	
	public MessageFunctionConstants() {
		this.functions.put("d", "DatePattern");
		this.functions.put("p", "LevelPattern");
		this.functions.put("t", "ThreadPattern");
		this.functions.put("m", "MessagePattern");
		this.functions.put("n", "SeparatorPattern");
		this.functions.put("L", "LineNumberPattern");
		this.functions.put("F", "FilePattern");
		this.functions.put("M", "MethodPattern");
	}
	
	public String getFunctionName(String pattern){
		
		return functions.get(pattern);
	}
}
