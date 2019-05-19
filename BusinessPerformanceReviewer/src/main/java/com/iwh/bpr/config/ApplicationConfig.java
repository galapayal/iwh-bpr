package com.iwh.bpr.config;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import com.iwh.bpr.utilities.AppConstants;

public class ApplicationConfig {
	
	private static final Properties dbPropMap = new Properties();
	
	private static void loadConfig() {
		/**
		 * Load configuration from file.
		 */
	
	
			try (InputStream confFileIs = ApplicationConfig.class.getResourceAsStream("/db-props/" + AppConstants.PROP+ AppConstants.PROPEXT)) {

				Properties confProp = new Properties();
				confProp.load(confFileIs);
				for (Map.Entry<Object, Object> entry : confProp.entrySet()) {
					dbPropMap.setProperty(String.valueOf(entry.getKey())
							, String.valueOf(entry.getValue()));
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	
	}
	static {
		loadConfig();
	}
	
	public String getDbProperty(String key) {
		return dbPropMap.getProperty(key);
	}

}
