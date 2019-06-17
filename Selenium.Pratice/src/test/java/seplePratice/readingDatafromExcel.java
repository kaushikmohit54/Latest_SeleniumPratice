package seplePratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.qa.util.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class readingDatafromExcel {

	public WebDriver driver;
	Xls_Reader xls = new Xls_Reader("F:\\GitRepo\\Selenium.Pratice\\src\\test\\resources\\TestData\\TestData1.xlsx");

	@BeforeMethod
	public void openbrowser() {
		WebDriverManager.chromedriver().setup(); // launching chrome driver
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // for maximizing the window
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit wait
		driver.manage().deleteAllCookies(); // deleting all cookies
		driver.get("http://practice.automationtesting.in/my-account/");
	}

	@Test()
	public void loginTest() {
		int rcount = xls.getRowCount("sheet1");
		for (int i = 2; i <= rcount; i++) {

			driver.findElement(By.name("username")).sendKeys(xls.getCellData("sheet1", "username", i));//reading data from excel coulmn wise
			driver.findElement(By.name("password")).sendKeys(xls.getCellData("sheet1", "Password", i));
		}
		driver.findElement(By.name("login")).click();
		Assert.assertEquals(driver.getTitle(), "My Account – Automation Practice Site");
		driver.findElement(By.linkText("Sign out")).click();

	}

	@AfterMethod
	public void closebrowser() {
		driver.quit();

	}

}
