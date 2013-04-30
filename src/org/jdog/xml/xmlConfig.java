/*
 * xmlConfig.java
 *
 * Written by: Ted Elwartowski
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.jdog.xml;

import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

/**
 * The xmlConfig class is used to read XML based configuration files.
 * 
 * @author Ted Elwartowski
 */
public class xmlConfig {
	private static String configFile = "config.xml";
	private static XMLConfiguration config = null;

	/**
	 * 
	 * Creates a new instance of xmlConfig
	 */
	public xmlConfig() {
		config = new XMLConfiguration();
		config.setFileName(configFile);
	}

	/**
	 * Set the Configuration file to be used by xmlConfig. By default xmlConfig
	 * will look for the file 'config.xml' in the local directory.
	 * 
	 * @param file
	 *            The location of the configuration file
	 */
	public void setFile(String file) {
		if (file != null && !file.equals("")) {
			configFile = file;
			config.setFileName(file);
		}
	}

	/**
	 * Load the configuration file into memory.
	 * 
	 * This method throws Exception on errors, it must be caught in a try catch
	 * block.
	 */
	public void loadXML() throws ConfigurationException {
		config.load();
	}

	/**
	 * Retrieve the configuration value for the parameter name.
	 * <p>
	 * The parameter name should be in the following format:<br>
	 * <ul>
	 * <li>param1.param2</li>
	 * <li>param1.param2[@param3]</li>
	 * </p>
	 * 
	 * @param name
	 *            The name of the configuration parameter.
	 * @return A String containing the configuration value for the xml parameter
	 *         name
	 */
	public String getString(String name) {
		if (name != null) {
			if (config.getString(name) != null) {
				return config.getString(name);
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * Retrieve the configuration value for the parameter name.
	 * <p>
	 * The parameter name should be in the following format:<br>
	 * <ul>
	 * <li>param1.param2</li>
	 * <li>param1.param2[@param3]</li>
	 * </p>
	 * 
	 * @param name
	 *            The name of the configuration parameter.
	 * @return A int containing the configuration value for the xml parameter
	 *         name
	 */
	public int getInt(String name) {
		if (name != null) {
			return config.getInt(name, 0);
		}
		return 0;
	}

	/**
	 * Retrieve the configuration value for the parameter name.
	 * <p>
	 * The parameter name should be in the following format:<br>
	 * <ul>
	 * <li>param1.param2</li>
	 * <li>param1.param2[@param3]</li>
	 * </p>
	 * 
	 * @param name
	 *            The name of the configuration parameter.
	 * @return A List containing the configuration values for the xml parameter
	 *         name
	 */
	public List<Object> getList(String name) {
		if (name != null) {
			if (config.getList(name) != null) {
				return config.getList(name);
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * Retrieve the configuration value for the parameter name.
	 * <p>
	 * The parameter name should be in the following format:<br>
	 * <ul>
	 * <li>param1.param2</li>
	 * <li>param1.param2[@param3]</li>
	 * </p>
	 * 
	 * @param name
	 *            The name of the configuration parameter.
	 * @return An Object containing the configuration values for the xml
	 *         parameter name
	 */
	public Object getProperty(String name) {
		if (name != null) {
			if (config.getProperty(name) != null) {
				return config.getProperty(name);
			} else {
				return null;
			}
		}
		return null;
	}
}
