package Pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.qa.util.Xls_Reader;



public class readxls2 {
	public static Xls_Reader xls;

	public static void main(String[] args) {
	

		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); // create an instance of the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://newtours.demoaut.com/");
			
			
			
		Xls_Reader xls=new Xls_Reader("C:\\my desktop\\Zoho_P\\src\\da.xlsx");
		int rowcount=xls.getRowCount("sheet1");
		for(int i=2;i<rowcount;i++) {
			try {
			
			driver.findElement(By.name("userName")).sendKeys(xls.getCellData("Sheet1", "username", i));
			driver.findElement(By.name("password")).sendKeys(xls.getCellData("Sheet1", "password", i));
			driver.findElement(By.name("login")).click();
			
			WebElement ele=driver.findElement(By.xpath("//font[contains(test(),'Flight Details')]"));
			String val=ele.getText();
			
			
             
			
			Assert.assertEquals(val,"Flight Details" );
			xls.setCellData("Sheet1", "Status", i, "Pass");
			driver.navigate().back();
			}
			
			
			
			
			
		
		
			 catch (Exception e) {
				 xls.setCellData("Sheet1", "Status", i, "Fail");
				//Xls_Reader xls=new Xls_Reader("C:\\my desktop\\Zoho_P\\src\\da.xlsx");
			}
				
				
				
				
				
				
				
				// TODO: handle exception
			}
		
			
			
			
			
		}

	}


