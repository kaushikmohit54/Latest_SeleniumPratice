package seplePratice;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loggerlog  {
	private static final Logger logger = LogManager.getLogger(Loggerlog.class.getName());
	public WebDriver driver;
	
	@Test
	public void loggerlog() {
		ChromeDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		logger.info("Chrome Browser lunched");
		driver.get("https://www.google.com");
		logger.info(driver.getCurrentUrl());
		logger.info(driver.getTitle());
		
		
	}

}
