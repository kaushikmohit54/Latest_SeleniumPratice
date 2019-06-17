package Pratice;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class googlesuggestions {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		

		//WebDriver driver;
		//Logger logs=Logger.getLogger("devpinoyLogger");
		
		
		   
			System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
			
			WebDriver driver = new ChromeDriver(); // create an instance of the browser
			WebDriverWait wdw = new WebDriverWait(driver, 30); // create something which can wait for the suggestions
			driver.manage().window().maximize(); // maximize the browser window
			driver.get("https://www.google.co.in/"); // go to Google Search
			
			driver.findElement(By.cssSelector("#lst-ib")).sendKeys("Webdriver");
			// send the string "" to the input
			wdw.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".sbsb_b .sbqs_c")));
			
			// wait for the suggestions  
			List<WebElement> suggestions = driver.findElements(By.cssSelector(".sbsb_b .sbqs_c")); // find all the suggestions
			
				
			
			
			for(int i=0; i<=suggestions.size()-1; i++) {
				String op=suggestions.get(i).getText();
				System.out.println(op);
				//System.out.println(suggestions);
				if(op.contains("api")) 
					suggestions.get(i).click();
				break;
					
					
				
	}
driver.quit();
				
			/*
			for(WebElement suggestion : suggestions) { // iterate over all the suggestions
				
					
				
			System.out.println(suggestion.getText()); // print the suggestions
			*/
			
			
		
		
}}