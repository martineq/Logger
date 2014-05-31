package com.fiuba.tecnicas.logging;


import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.helpers.NOPLogger;
import org.slf4j.spi.LocationAwareLogger;
import com.fiuba.tecnicas.logging.*;


public class LoggerAdapter implements org.slf4j.Logger {
	
	private com.fiuba.tecnicas.logging.Logger logger;

	  // Does the log4j version in use recognize the TRACE level?
	  // The trace level was introduced in log4j 1.2.12.
	  private boolean traceCapable;

	  // WARN: Log4jLoggerAdapter constructor should have only package access so
	  // that
	  // only Log4jLoggerFactory be able to create one.
	  public LoggerAdapter (com.fiuba.tecnicas.logging.Logger logger) {
	    this.logger = logger;
	  }

	  
	  public String getName(){
		  return logger.getName();
	  }

	
	  
	  
	  public void debug(String msg){
		  this.logger.debug(msg);
		  
	  }
	  
	  public void debug(String format,Object... arguments){
		  FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
		  this.logger.debug(ft.getMessage(),ft.getThrowable());
		  
	  }
	  
	  
	  /**
	   * Log a message at level DEBUG according to the specified format and
	   * argument.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for level DEBUG.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg
	   *          the argument
	   */
	 public void debug(String format,Object arg){
		  FormattingTuple ft = MessageFormatter.format(format, arg);
		  this.logger.debug(ft.getMessage(),ft.getThrowable());
	  }
	  
	  
	  /**
	   * Log a message at level DEBUG according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the DEBUG level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg1
	   *          the first argument
	   * @param arg2
	   *          the second argument
	   */
	 public void debug(String format,Object arg1,Object arg2){
		  FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
	      logger.debug(ft.getMessage(), ft.getThrowable());
	  }
	  
	  /**
	   * Log an exception (throwable) at level DEBUG with an accompanying message.
	   * 
	   * @param msg
	   *          the message accompanying the exception
	   * @param t
	   *          the exception (throwable) to log
	   */
	  public void debug(String msg, Throwable t) {
	    logger.debug(msg,t);
	  }
	  
	  /**
	   * Is this logger instance enabled for the DEBUG level?
	   * 
	   * @return True if this Logger is enabled for level DEBUG, false otherwise.
	   */
	  public boolean isDebugEnabled() {
	    return logger.getSettings().belongsToLevelFilter("DEBUG");
	  }
	  
	  
	  /**
	   * Is this logger instance enabled for the TRACE level?
	   * 
	   * @return True if this Logger is enabled for level TRACE, false otherwise.
	   */
	  public boolean isTraceEnabled() {
	    return this.logger.getSettings().belongsToLevelFilter("TRACE");
	  }

	  /**
	   * Log a message object at level TRACE.
	   * 
	   * @param msg
	   *          - the message object to be logged
	   */
	  public void trace(String msg) {
	    logger.trace(msg);
	  }

	  /**
	   * Log a message at level TRACE according to the specified format and
	   * argument.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for level TRACE.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg
	   *          the argument
	   */
	  public void trace(String format, Object arg) {
	      FormattingTuple ft = MessageFormatter.format(format, arg);
	      logger.trace(ft.getMessage(), ft.getThrowable());
	   }

	  /**
	   * Log a message at level TRACE according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the TRACE level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg1
	   *          the first argument
	   * @param arg2
	   *          the second argument
	   */
	  public void trace(String format, Object arg1, Object arg2) {
	      FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
	      logger.trace(ft.getMessage(), ft.getThrowable());
	   }

	  /**
	   * Log a message at level TRACE according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the TRACE level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arguments
	   *          an array of arguments
	   */
	  public void trace(String format, Object... arguments) {
	      FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
	      logger.trace(ft.getMessage(), ft.getThrowable());
	   }

	  /**
	   * Log an exception (throwable) at level TRACE with an accompanying message.
	   * 
	   * @param msg
	   *          the message accompanying the exception
	   * @param t
	   *          the exception (throwable) to log
	   */
	  public void trace(String msg, Throwable t) {
	    logger.trace(msg, t);
	  }



	  /**
	   * Is this logger instance enabled for the INFO level?
	   * 
	   * @return True if this Logger is enabled for the INFO level, false otherwise.
	   */
	  public boolean isInfoEnabled() {
	    return logger.getSettings().belongsToLevelFilter("INFO");
	  }

	  /**
	   * Log a message object at the INFO level.
	   * 
	   * @param msg
	   *          - the message object to be logged
	   */
	  public void info(String msg) {
	    logger.info(msg);
	  }

	  /**
	   * Log a message at level INFO according to the specified format and argument.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the INFO level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg
	   *          the argument
	   */
	  public void info(String format, Object arg) {
	      FormattingTuple ft = MessageFormatter.format(format, arg);
	      logger.info(ft.getMessage(), ft.getThrowable());
	    }

	  /**
	   * Log a message at the INFO level according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the INFO level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg1
	   *          the first argument
	   * @param arg2
	   *          the second argument
	   */
	  public void info(String format, Object arg1, Object arg2) {
	      FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
	      logger.info(ft.getMessage(), ft.getThrowable());
	    }

	  /**
	   * Log a message at level INFO according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the INFO level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param argArray
	   *          an array of arguments
	   */
	  public void info(String format, Object... argArray) {
	      FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
	      logger.info(ft.getMessage(), ft.getThrowable());
	  }

	  /**
	   * Log an exception (throwable) at the INFO level with an accompanying
	   * message.
	   * 
	   * @param msg
	   *          the message accompanying the exception
	   * @param t
	   *          the exception (throwable) to log
	   */
	  public void info(String msg, Throwable t) {
	    logger.info( msg, t);
	  }

	  /**
	   * Is this logger instance enabled for the WARN level?
	   * 
	   * @return True if this Logger is enabled for the WARN level, false otherwise.
	   */
	  public boolean isWarnEnabled() {
	    return logger.getSettings().belongsToLevelFilter("WARN");
	  }

	  /**
	   * Log a message object at the WARN level.
	   * 
	   * @param msg
	   *          - the message object to be logged
	   */
	  public void warn(String msg) {
	    logger.warn(msg);
	  }

	  /**
	   * Log a message at the WARN level according to the specified format and
	   * argument.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the WARN level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg
	   *          the argument
	   */
	  public void warn(String format, Object arg) {
	      FormattingTuple ft = MessageFormatter.format(format, arg);
	      logger.warn(ft.getMessage(), ft.getThrowable());
	  }

	  /**
	   * Log a message at the WARN level according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the WARN level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg1
	   *          the first argument
	   * @param arg2
	   *          the second argument
	   */
	  public void warn(String format, Object arg1, Object arg2) {
	      FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
	      logger.warn(ft.getMessage(), ft.getThrowable());
	  }

	  /**
	   * Log a message at level WARN according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the WARN level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param argArray
	   *          an array of arguments
	   */
	  public void warn(String format, Object... argArray) {
	      FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
	      logger.warn(ft.getMessage(), ft.getThrowable());
	  }

	  /**
	   * Log an exception (throwable) at the WARN level with an accompanying
	   * message.
	   * 
	   * @param msg
	   *          the message accompanying the exception
	   * @param t
	   *          the exception (throwable) to log
	   */
	  public void warn(String msg, Throwable t) {
	    logger.warn(msg, t);
	  }

	  /**
	   * Is this logger instance enabled for level ERROR?
	   * 
	   * @return True if this Logger is enabled for level ERROR, false otherwise.
	   */
	  public boolean isErrorEnabled() {
	    return logger.getSettings().belongsToLevelFilter("ERROR");
	  }

	  /**
	   * Log a message object at the ERROR level.
	   * 
	   * @param msg
	   *          - the message object to be logged
	   */
	  public void error(String msg) {
	    logger.error(msg);
	  }

	  /**
	   * Log a message at the ERROR level according to the specified format and
	   * argument.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the ERROR level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg
	   *          the argument
	   */
	  public void error(String format, Object arg) {
	      FormattingTuple ft = MessageFormatter.format(format, arg);
	      logger.error(ft.getMessage(), ft.getThrowable());
	  }

	  /**
	   * Log a message at the ERROR level according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the ERROR level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg1
	   *          the first argument
	   * @param arg2
	   *          the second argument
	   */
	  public void error(String format, Object arg1, Object arg2) {
	      FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
	      logger.error(ft.getMessage(), ft.getThrowable());
	  }

	  /**
	   * Log a message at level ERROR according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the ERROR level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param argArray
	   *          an array of arguments
	   */
	  public void error(String format, Object... argArray) {
	      FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
	      logger.error(ft.getMessage(), ft.getThrowable());
	  }

	  /**
	   * Log an exception (throwable) at the ERROR level with an accompanying
	   * message.
	   * 
	   * @param msg
	   *          the message accompanying the exception
	   * @param t
	   *          the exception (throwable) to log
	   */
	  public void error(String msg, Throwable t) {
	    logger.error(msg, t);
	  }


	@Override
	public void debug(Marker arg0, String arg1) {
		NOPLogger.NOP_LOGGER.debug(arg0, arg1);
		
	}


	@Override
	public void debug(Marker arg0, String arg1, Object arg2) {
		NOPLogger.NOP_LOGGER.debug(arg0,arg1,arg2);
		
	}


	@Override
	public void debug(Marker arg0, String arg1, Object... arg2) {
		NOPLogger.NOP_LOGGER.debug(arg0,arg1,arg2);
		
	}


	@Override
	public void debug(Marker arg0, String arg1, Throwable arg2) {
		NOPLogger.NOP_LOGGER.debug(arg0,arg1,arg2);
		
	}


	@Override
	public void debug(Marker arg0, String arg1, Object arg2, Object arg3) {
		NOPLogger.NOP_LOGGER.debug(arg0,arg1,arg2,arg3);
		
	}


	@Override
	public void error(Marker arg0, String arg1) {
		NOPLogger.NOP_LOGGER.error(arg0,arg1);
		
	}


	@Override
	public void error(Marker arg0, String arg1, Object arg2) {
		NOPLogger.NOP_LOGGER.error(arg0,arg1,arg2);
		
	}


	@Override
	public void error(Marker arg0, String arg1, Object... arg2) {
		NOPLogger.NOP_LOGGER.error(arg0,arg1,arg2);
		
	}


	@Override
	public void error(Marker arg0, String arg1, Throwable arg2) {
		NOPLogger.NOP_LOGGER.error(arg0,arg1,arg2);
		
	}


	@Override
	public void error(Marker arg0, String arg1, Object arg2, Object arg3) {
		NOPLogger.NOP_LOGGER.error(arg0,arg1,arg2,arg3);
		
	}


	@Override
	public void info(Marker arg0, String arg1) {
		NOPLogger.NOP_LOGGER.info(arg0,arg1);
		
	}


	@Override
	public void info(Marker arg0, String arg1, Object arg2) {
		NOPLogger.NOP_LOGGER.info(arg0,arg1,arg2);
	}


	@Override
	public void info(Marker arg0, String arg1, Object... arg2) {
		NOPLogger.NOP_LOGGER.info(arg0,arg1,arg2);
	}


	@Override
	public void info(Marker arg0, String arg1, Throwable arg2) {
		NOPLogger.NOP_LOGGER.info(arg0,arg1,arg2);
		
	}


	@Override
	public void info(Marker arg0, String arg1, Object arg2, Object arg3) {
		NOPLogger.NOP_LOGGER.info(arg0,arg1,arg2,arg3);
		
	}


	@Override
	public boolean isDebugEnabled(Marker arg0) {
		
		return false;
	}


	@Override
	public boolean isErrorEnabled(Marker arg0) {
		
		return false;
	}


	@Override
	public boolean isInfoEnabled(Marker arg0) {
		
		return false;
	}


	@Override
	public boolean isTraceEnabled(Marker arg0) {
	
		return false;
	}


	@Override
	public boolean isWarnEnabled(Marker arg0) {
		
		return false;
	}


	@Override
	public void trace(Marker arg0, String arg1) {
		NOPLogger.NOP_LOGGER.trace(arg0,arg1);
		
	}


	@Override
	public void trace(Marker arg0, String arg1, Object arg2) {
		NOPLogger.NOP_LOGGER.trace(arg0,arg1,arg2);
		
	}


	@Override
	public void trace(Marker arg0, String arg1, Object... arg2) {
		NOPLogger.NOP_LOGGER.trace(arg0,arg1,arg2);
		
	}


	@Override
	public void trace(Marker arg0, String arg1, Throwable arg2) {
		NOPLogger.NOP_LOGGER.trace(arg0,arg1,arg2);
		
	}


	@Override
	public void trace(Marker arg0, String arg1, Object arg2, Object arg3) {
		NOPLogger.NOP_LOGGER.trace(arg0,arg1,arg2,arg3);
		
	}


	@Override
	public void warn(Marker arg0, String arg1) {
		NOPLogger.NOP_LOGGER.warn(arg0,arg1);
		
	}


	@Override
	public void warn(Marker arg0, String arg1, Object arg2) {
		NOPLogger.NOP_LOGGER.warn(arg0,arg1,arg2);
		
	}


	@Override
	public void warn(Marker arg0, String arg1, Object... arg2) {
		NOPLogger.NOP_LOGGER.warn(arg0,arg1,arg2);
		
	}


	@Override
	public void warn(Marker arg0, String arg1, Throwable arg2) {
		NOPLogger.NOP_LOGGER.warn(arg0,arg1,arg2);
		
	}


	@Override
	public void warn(Marker arg0, String arg1, Object arg2, Object arg3) {
		NOPLogger.NOP_LOGGER.warn(arg0,arg1,arg2,arg3);
		
	}

}
