package org.imagenecsi.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class UserroleCredentialsProp {
	
	private static final Logger logger = LogManager.getLogger(UserroleCredentialsProp.class.getName());
	
	private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading credentials.properties");
				prop.load(UserroleCredentialsProp.class.getResourceAsStream("/config/credentials/admincredentials.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	 
	
	public static String getAdminUserName(){
		return prop.getProperty("adminUsername");
	}
	
	public static String getAdminPassword(){
		return prop.getProperty("adminPassword");
	}
	
	
	
	
}
