package com.fiuba.tecnicas.logging;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class StaticLoggerBinder implements LoggerFactoryBinder {
	
	 /**
	   * The unique instance of this class.
	   * 
	   */
	  private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

	  /**
	   * Return the singleton of this class.
	   * 
	   * @return the StaticLoggerBinder singleton
	   */
	  public static final StaticLoggerBinder getSingleton() {
	    return SINGLETON;
	  }


	  private static final String loggerFactoryClassStr = LoggerFactoryAdapter.class.getName();

	  /**
	   * The ILoggerFactory instance returned by the {@link #getLoggerFactory}
	   * method should always be the same object
	   */
	  private final ILoggerFactory loggerFactory;

	  private StaticLoggerBinder() {
	    loggerFactory = new LoggerFactoryAdapter();
	  }

	  public ILoggerFactory getLoggerFactory() {
	    return loggerFactory;
	  }

	  public String getLoggerFactoryClassStr() {
	    return loggerFactoryClassStr;
	  }
}
