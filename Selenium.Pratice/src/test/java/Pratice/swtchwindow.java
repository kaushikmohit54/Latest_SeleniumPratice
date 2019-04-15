package Pratice;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class swtchwindow {
	public static void main(String[] args) throws InterruptedException {
		Logger logs=Logger.getLogger("devpinoyLogger");
		 System.setProperty("webdriver.gecko.driver", "D:\\Mohit_DatadrivenFramwork\\Zoho_Project\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		logs.debug(driver.getCurrentUrl());
		driver.findElement(By.xpath(".//*[@id='content']/p[3]/button")).click();
		String parent_window=driver.getWindowHandle();
		
		for(String handle1:driver.getWindowHandles()) {
			logs.debug(handle1);
			driver.switchTo().window(handle1);
			Thread.sleep(5000);
			driver.close();
			
			
		}
		
		for(String handle1:driver.getWindowHandles()) {
			logs.debug(handle1);
			driver.switchTo().window(handle1);
		}
		
		
		
		
		
		
		
		
		
		
}
}