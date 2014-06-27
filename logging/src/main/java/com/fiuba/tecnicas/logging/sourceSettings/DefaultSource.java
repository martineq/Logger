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
	public String getValue(String key, String defaultValue) {
		return defaultValue;
	}

	@Override
	public String getValue(String key, String defaultValue, String loggerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
