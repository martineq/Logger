package com.fiuba.tecnicas.logging.sourceSettings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Mart
 * 
 */
public class PropertiesSource implements SourceSettings {

	final static String SOURCE_FILE_EXTENSION = ".properties";
	Properties properties;
	private boolean available;

	public PropertiesSource() {
		available = true;
	}

	@Override
	public void load(String name) {
		properties = new Properties();

		try {
			properties.load(new FileInputStream(name + SOURCE_FILE_EXTENSION));
		} catch (IOException e) {
			available = false;
		}

	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public String getValue(String key, String defaultValue, String loggerName) {
		String value = properties.getProperty(loggerName+"."+key, defaultValue);
		if (value.isEmpty()) {
			return defaultValue;
		}
		return value;
	}

}
