package com.fiuba.tecnicas.logging.sourceSettings;


/**
 * Interface for the sources of settings
 * 
 * @author Mart
 *
 */
public interface SourceSettings {

	/**
	 * Loads the source
	 *
	 * @param name The name of the source
	 */
	public void load(String name);

	/**
	 * Informs if the source is available
	 *
	 * @return if is available
	 */
	public boolean isAvailable();
	
	/**
	 * Loads the value of a property
	 *
	 * @param key The name of the key wanted
	 * @param defaultValue The default value returned in case of key not found
	 * @return The value of the corresponding key
	 */
	public String getValue(String key, String defaultValue);

}
