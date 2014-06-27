import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;

import com.fiuba.tecnicas.logging.LoggerFactoryAdapter;
import com.fiuba.tecnicas.logging.StaticLoggerBinder;



public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StaticLoggerBinder loggerBinder = StaticLoggerBinder.getSingleton();
		ILoggerFactory loggerFactory = loggerBinder.getLoggerFactory();
		
		
		org.slf4j.Logger logger1 = loggerFactory.getLogger("Logger1");
		org.slf4j.Logger logger2 = loggerFactory.getLogger("Logger2");
		org.slf4j.Logger logger3 = loggerFactory.getLogger("Logger3");
		
		logger1.info("Hello World");
		logger1.info("Hola Mundo");
		logger1.info("Hallo Welt");
		
		logger2.info("tp no deberia loguearse");
		logger2.debug("tp deberia loguearse");
		
		logger3.trace("no deberia loguearse..");
		logger3.warn("Esto deberia loguearse con excepcion", new NullPointerException());
		logger3.error("esto deberia deberia loguearse..");

	}

}
