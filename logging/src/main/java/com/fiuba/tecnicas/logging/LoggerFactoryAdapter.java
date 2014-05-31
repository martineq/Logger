package com.fiuba.tecnicas.logging;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import com.fiuba.tecnicas.logging.*;


public class LoggerFactoryAdapter implements org.slf4j.ILoggerFactory {
	
	 public org.slf4j.Logger getLogger(String name){
		 com.fiuba.tecnicas.logging.Logger logger = LoggerFactory.getInstance().getLogger(name);
		 return new LoggerAdapter(logger);
		 
	 }


}
