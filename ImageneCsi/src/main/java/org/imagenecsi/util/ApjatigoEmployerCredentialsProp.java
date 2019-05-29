package org.imagenecsi.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ApjatigoEmployerCredentialsProp {

	
	private static final Logger logger = LogManager.getLogger(ApjatigoEmployerCredentialsProp.class.getName());
	
	private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading credentials.properties");
				prop.load(ApjatigoEmployerCredentialsProp.class.getResourceAsStream("/config/credentials/apjatigoemployercredentials.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	 
	
	public static String getEmployerUserName(){
		return prop.getProperty("apjatigoEmployerUsername");
	}
	
	public static String getEmployerPassword(){
		return prop.getProperty("apjatigoEmployerPassword");
	}
	
	
	
	
	
	
}
