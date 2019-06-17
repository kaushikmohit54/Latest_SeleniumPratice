package Pratice;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Naukri  {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Item Automation\\costCucumberAutomation\\chromedriver\\chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
        
        // Set the notification setting it will override the default setting
prefs.put("profile.default_content_setting_values.notifications", 2);

        // Create object of ChromeOption class
ChromeOptions options = new ChromeOptions();

        // Set the experimental option
options.setExperimentalOption("prefs", prefs);

        // pass the options object in Chrome driver

WebDriver driver = new ChromeDriver(options);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	
	//@Test
	
	public void login() throws InterruptedException {
		
		driver.get("http://www.naukri.com");
					
			
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Login']")));
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		//driver.findElement(By.xpath("//*[contains(text(),'Login']")).click();
		
		driver.findElement(By.name("email")).sendKeys("mohit.test@hotmail.com");
		driver.findElement(By.name("PASSWORD")).sendKeys("Faltunaukri@123");
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nameDisplaySpan")));
		/*WebElement val=driver.findElement(By.id("nameDisplaySpan"));
		String my=val.getText();
	
		Assert.assertEquals(my, "Mohit Sharma");*/
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[text()='View and Update Profile']")));
		
		driver.findElement(By.xpath("//b[text()='View and Update Profile']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadLink")));
		
		driver.findElement(By.id("uploadLink")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("attachCV")));
		WebElement ele=driver.findElement(By.id("attachCV"));
		ele.sendKeys("C:\\Users\\mohit.sharma\\Documents\\Resume\\Mohit_sharma_AutomationTesting.docx");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("attachCVMsg")));
		
		WebElement val=driver.findElement(By.id("attachCVMsg"));
		String sucessmsg=val.getText();
		
		Assert.assertEquals(sucessmsg, "File uploaded successfully.");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[text()='Save']")));
		
		driver.findElement(By.xpath("//b[text()='Save']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmMessage")));
		String conmsg=driver.findElement(By.id("confirmMessage")).getText();
		
		Assert.assertEquals(conmsg, "Your naukri profile has been updated with your uploaded resume");
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
	}
	@Test
	public void verifytooltip() {
		browser();
		driver.get("http://www.globalsqa.com/demo-site/tooltip/");
		String tooltip=driver.findElement(By.linkText("Vienna, Austria")).getAttribute("title");
		Assert.assertEquals(tooltip, "Vienna, Austria");
		
	}
	

}

