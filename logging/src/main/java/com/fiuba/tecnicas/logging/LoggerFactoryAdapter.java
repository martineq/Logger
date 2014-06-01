package com.fiuba.tecnicas.logging;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import com.fiuba.tecnicas.logging.*;


public class LoggerFactoryAdapter implements org.slf4j.ILoggerFactory {
	
	
	 ConcurrentMap<String, org.slf4j.Logger> loggerMap;
	 
	 public LoggerFactoryAdapter() {
		 loggerMap = new ConcurrentHashMap<String, org.slf4j.Logger>();
	 }
	  
	 public org.slf4j.Logger getLogger(String name){
		 org.slf4j.Logger aLoggerSlf4j = loggerMap.get(name);
		    if (aLoggerSlf4j == null) {
		      com.fiuba.tecnicas.logging.Logger aLogger = LoggerFactory.getInstance().getLogger(name);
		      aLoggerSlf4j = new LoggerAdapter(aLogger);
		      loggerMap.put(name, aLoggerSlf4j);
		    }
		    return aLoggerSlf4j;		 
	 }


}
