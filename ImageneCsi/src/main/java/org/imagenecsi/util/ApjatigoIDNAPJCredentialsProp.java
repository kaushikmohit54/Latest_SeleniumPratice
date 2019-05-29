package org.imagenecsi.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ApjatigoIDNAPJCredentialsProp {

private static final Logger logger = LogManager.getLogger(ApjatigoIDNAPJCredentialsProp.class.getName());
	
	private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading credentials.properties");
				prop.load(ApjatigoIDNAPJCredentialsProp.class.getResourceAsStream("/config/credentials/idnapjatigoapjcredentials.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	
	public static String getIDNAPJUserName(){
		return prop.getProperty("apjatigoIDNAPJUsername");
	}
	
	public static String getIDNAPJPassword(){
		return prop.getProperty("apjatigoIDNAPJPassword");
	}
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
