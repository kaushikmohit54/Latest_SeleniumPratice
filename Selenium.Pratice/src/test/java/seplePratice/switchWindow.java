package seplePratice;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class switchWindow {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void openbrowser() {
		WebDriverManager.chromedriver().setup();  //launching chrome driver
	    driver=new ChromeDriver();	
	    driver.manage().window().maximize(); //for maximizing the window
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //implicit wait  
	    driver.manage().deleteAllCookies(); //deleting  all cookies
	    //baseUrl = "http://www.google.co.uk/";
	    driver.get("http://www.google.co.uk/");
	    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0)); //switches to new tab
	    driver.get("https://www.facebook.com");

	    driver.switchTo().window(tabs.get(1)); // switch back to main screen        
	    driver.get("https://www.news.google.com");
	}
	@Test()
	public void loginTest() {
		//driver.findElement(By.name("userName")).sendKeys(UserName);
		//driver.findElement(By.name("password")).sendKeys(Password);
		//driver.findElement(By.name("login")).click();
		/*WebElement ele=driver.findElement(By.name("userName"));
		ele.sendKeys("mohit");
		openNewTab();*/
		
		//Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours: ");
			
	}
	public void openNewTab()
	{
	    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	}
	
	@AfterMethod
	public void closebrowser() {
		//if(driver!=null)
			//driver.quit();
		   	
	}

}
