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
 
	@Test(description="Auto Suggest",enabled=false)
	public void selectValues()
	{
		initializationBrowser();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		/**
		 * Example for Visibility of Elements located by
		 */
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		System.out.println("Auto Suggest List ::" + list.size());
		
		for(int j = 0 ;j< list.size();j++)
			
		{
			System.out.println(list.get(j).getText());
			
		}
		
		
		
		for(int i = 0 ;i< list.size();i++)
		{
			
			//System.out.println(list.get(i).getText());
			
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
	
	
	@Test()
	public void printallvalues() {
		initializationBrowser();
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("selenium");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> allOptions = driver.findElements(By.xpath("//td/span[text()='selenium']"));
		
		for (int i = 0; i < allOptions.size(); i++) {
			String option = allOptions.get(i).getText();
			System.out.println(option);
		}
	}
	
}