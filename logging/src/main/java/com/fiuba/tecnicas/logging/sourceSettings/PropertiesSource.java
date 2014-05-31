/**
 * 
 */
package com.fiuba.tecnicas.logging.sourceSettings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Mart
 *
 */
public class PropertiesSource implements SourceSettings {

	Properties properties;
	private boolean available;

	public PropertiesSource() {
		available = true;
	}
	
	@Override
	public void load(String name) {
		properties = new Properties();

	    try {
	      properties.load(new FileInputStream(name+".properties"));
	    } catch (IOException e) {
	    	available = false;
	    }

	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public String getProperty(String key, String defaultValue) {
		return properties.getProperty(key,defaultValue);
	}

}
