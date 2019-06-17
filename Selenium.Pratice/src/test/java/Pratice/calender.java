package Pratice;



import java.awt.AWTException;
import java.awt.Robot;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class calender {
	
	@Test
	public void lsdf() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\Item Automation\\costCucumberAutomation\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		//http://jqueryui.com/datepicker/
		List<WebElement> ele= driver.findElements(By.xpath("//*[@type='checkbox']"));
		
		for(WebElement ele1:ele) {
			ele1.click();
			Thread.sleep(2000);
			
		}
		
					
				
		
		
		
		
		
		

		 
	}
			
		
		
		
	

	

}
