package Pratice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class frame {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", "D:\\Mohit_DatadrivenFramwork\\Zoho_Project\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		 String Parent_Window = driver.getWindowHandle(); 
		 // Switching from parent window to child window   
		 for (String Child_Window : driver.getWindowHandles())   
		 {        driver.switchTo().window(Child_Window);   
		 // Performing actions on child window     
		 }
		
		driver.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		Thread.sleep(5000);
		driver.switchTo().frame("classFrame");
		Thread.sleep(5000);
		driver.findElement(By.linkText("com.thoughtworks.selenium.webdriven.commands")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageListFrame");
		Thread.sleep(5000);
		driver.findElement(By.linkText("org.openqa.selenium.interactions.touch")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("DoubleTapAction")).click();
		Thread.sleep(5000);
	
		
		
		driver.close();
		}
	}