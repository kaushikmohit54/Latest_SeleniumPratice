package org.imagenecsi.prop.emp;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.imagenecsi.prop.emp.*;

public class CsiApplicationProp {
	
	private static final Logger logger = LogManager.getLogger(CsiApplicationProp.class.getName());
	
	private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading EmpApplicationPage.properties");
				String lang = "en";
				if(configProp.containsKey("language")){
					lang = configProp.getProperty("language");
				}
				prop.load(CsiApplicationProp.class.getResourceAsStream("/language/"+lang+"/EmpApplicationPage.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
		
	public static String getPassportEmptyExpectedErrorMessage(){
		return prop.getProperty("passportNumberEmptyMessage");
		
	}
	
	public static String getNationalityEmptyExpetectedErrorMessage(){
		return prop.getProperty("NationalityInvalidMessage");
	}
	
	public static String getworkernotfoundExpetectedErrorMessage(){
		return prop.getProperty("workerNotFoundMessage");
	}
	
	public static String getpolicereportnoExpetectedErrorMessage(){
		return prop.getProperty("policereportNoEmptyMessage");
	}
	
	public static String getpolicecasereportExpetectedErrorMessage(){
		return prop.getProperty("policereportdateEmptyMessage");
	}
	
	public static String getpolicecasereportlocationExpetectedErrorMessage(){
		return prop.getProperty("policereportlocationEmptyMessage");
	}
	public static String getdaterunwayExpetectedErrorMessage(){
		return prop.getProperty("daterunwayEmptyMessage");
	}
	
	public static String getstateExpetectedErrorMessage(){
		return prop.getProperty("stateEmptyMessage");
	}
	public static String getpolicebranchExpetectedErrorMessage(){
		return prop.getProperty("policebranchEmptyMessage");
	}
	public static String getreporterNameExpetectedErrorMessage(){
		return prop.getProperty("reporterNameEmptyMessage");
	}
	public static String getpdfsizeExpetectedErrorMessage(){
		return prop.getProperty("pdfFileNotUploadedMessage");
	}
	
	public static String getotherthanPDFExpetectedErrorMessage(){
		return prop.getProperty("otherthanPDFUploadedMessage");
	}
	
	public static String getdelcarationExpetectedErrorMessage(){
		return prop.getProperty("declarationError");
	}
	
	public static String getOTPExpetectedErrorMessage(){
		return prop.getProperty("otpInvalidMessage");
	}
	public static String getPLKSExpetectedErrorMessage(){
		return prop.getProperty("PLKSInvalidMessage");
	}
	public static String getemployerblacklistExpetectedErrorMessage(){
		return prop.getProperty("employerblacklistInvalidMessage");
	}
}
