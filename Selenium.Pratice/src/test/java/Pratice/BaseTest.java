package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaseTest {
	public WebDriver driver;
	@DataProvider
	public Object[][] getLogindata(){
		Object[][] loginData=new Object[3][2];
		
		loginData[0][0]="mksharma";
		loginData[0][1]="mohit123";
		loginData[1][0]="mksharma";
		loginData[1][1]="mohit123";
		loginData[2][0]="mksharma";
		loginData[2][1]="mohit123";
		
		return loginData;
		
	}
	
	@Test(dataProvider="getLogindata")
	public void getlogindata(String uname,String pwd) {
		 System.setProperty("webdriver.gecko.driver", "D:\\Mohit_DatadrivenFramwork\\Zoho_Project\\Drivers\\geckodriver.exe");
		 //System.setProperty("webdriver.gecko.driver", ("user.dir")+"\\Drivers\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("login")).click();
		
		
	}

}
