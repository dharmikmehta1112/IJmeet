package com.ijmeet.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Utility {
	
	private static final Logger LOG = Logger.getLogger(Utility.class);
	
	/**
	 * Read data from configuration (properties) file and return value.
	 * 
	 * @param key as {@code String}.
	 * @return values as {@code String}.
	 */
	
	public static String getLocatorValue(String key) {
		String value = null;
		String path = Constants.basePath + "/src/main/resources/ConfigurationMain/application.properties";
		
		try {
			Constants.fis = new FileInputStream(path);
			Constants.prop = new Properties();
			Constants.prop.load(Constants.fis);
			value = Constants.prop.getProperty(key);
		} catch (FileNotFoundException e) {
			LOG.error("Object repository file not found in path: " +path);
			e.printStackTrace();
		} catch (IOException e) {
			LOG.error("Unable to load object repository file in path: " +path);
			e.printStackTrace();
		} finally {
			try {
				Constants.fis.close();
			} catch (IOException e) {
				LOG.error("Java Machine Shutdown.");
				e.printStackTrace();
			}
		}
		return value;
	}

}