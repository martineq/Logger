package com.fiuba.tecnicas.logging.sourceSettings;


/**
 * @author Mart
 *
 */
public class DefaultSource implements SourceSettings {

	@Override
	public void load(String name) {
		return;
	}

	@Override
	public boolean isAvailable() {
		return true;
	}

	@Override
	public String getProperty(String key, String defaultValue) {
		return defaultValue;
	}

}
