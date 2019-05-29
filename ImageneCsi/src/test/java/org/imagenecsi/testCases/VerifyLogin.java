package org.imagenecsi.testCases;

import java.io.FileReader;


import org.imagenecsi.initiators.ImageneCsiInitiator;
import org.imagenecsi.pages.*;
import org.imagenecsi.util.UserroleCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class VerifyLogin extends ImageneCsiInitiator {
	public static String pdfFilePath;
	
	@DataProvider(name="PassportInfoFlow")
	public Object[][] csiApplicationData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser()
		.parse(new FileReader(VerifyLogin.class.getResource(
				"/org/apjitigo/idn/ApjitigoIDNHappyFlow.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for (int i = 0; i < ja.size(); i++) {
			result[i][0] = ja.get(i);
		}
		return result;
	}

	
	@Test
	public void login() throws Exception {
		 WebDriver driver = getDriver();
	      LoginPage login = new LoginPage(driver).initElements();
	      login.verifyForgotPasswordLinkVisible();
          new LoginPage(getDriver()).initElements().loginToImageneCSI(UserroleCredentialsProp.getAdminUserName().trim(),UserroleCredentialsProp.getAdminPassword().trim());
          
  
     		
	}

	
	
	

}


