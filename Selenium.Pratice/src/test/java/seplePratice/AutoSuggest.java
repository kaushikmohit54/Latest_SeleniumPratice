package seplePratice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
 
public class AutoSuggest extends TestBase {
 
	@Test(description="Auto Suggest")
	public void selectValues()
	{
		initializationBrowser();
		driver.get("https://in.yahoo.com/?p=us");
		driver.findElement(By.id("uh-search-box")).sendKeys("Selenium");
		
		/**
		 * Example for Visibility of Elements located by
		 */
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		System.out.println("Auto Suggest List ::" + list.size());
		
		for(int i = 0 ;i< list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().equals("selenium interview questions"))
			{
				list.get(i).click();
				break;
			}
		}
		
		/**
		 * Verify the Search Results
		 */
		
		
	}
	
}