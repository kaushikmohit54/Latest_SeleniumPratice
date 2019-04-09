package seplePratice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class dataProvider {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void openbrowser() {
		WebDriverManager.chromedriver().setup();  //launching chrome driver
	    driver=new ChromeDriver();	
	    driver.manage().window().maximize(); //for maximizing the window
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //implicit wait  
	    driver.manage().deleteAllCookies(); //deleting  all cookies
	    driver.get("http://newtours.demoaut.com/");		
	}
	@Test(dataProvider="logindata")
	public void loginTest(String UserName,String Password) {
		driver.findElement(By.name("userName")).sendKeys(UserName);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("login")).click();
		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours: ");
			
	}
	
	@DataProvider(name = "logindata")
    public Object[][] data()
    {
        Object[][] data = new Object[1][2];
         
        data[0][0] = "mksharma";
        data[0][1] = "mohit123";  
       
        return data;
    }
	@AfterMethod
	public void closebrowser() {
		if(driver!=null)
			driver.quit();
		   	
	}

}
