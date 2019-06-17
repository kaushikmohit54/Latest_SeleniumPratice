package Pratice;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webtable {
	public static void main(String[] args) {
		Logger logs=Logger.getLogger("devpinoyLogger");
		 System.setProperty("webdriver.gecko.driver", "D:\\Mohit_DatadrivenFramwork\\Zoho_Project\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/selenium/delete_customer.php");
		logs.debug(driver.getCurrentUrl());
		driver.findElement(By.name("cusid")).sendKeys("12345");
		driver.findElement(By.name("submit")).click();
		Alert altmsg1=driver.switchTo().alert();
		String altmsg=driver.switchTo().alert().getText();
		logs.debug(altmsg);
		altmsg1.dismiss();
		
		
			
			
		}
		
		
		
		
		
		
		
		
		
		
}
