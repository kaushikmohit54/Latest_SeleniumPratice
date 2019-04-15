package Pratice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dropdownmultiselect {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); // create an instance of the browser
		WebDriverWait wdw = new WebDriverWait(driver, 30); // create something which can wait for the suggestions
		driver.manage().window().maximize(); // maximize the browser window
		driver.get("http://demo.automationtesting.in/Register.html");
		Select sel=new Select(driver.findElement(By.id("Skills")));
		sel.selectByVisibleText("C");
		Thread.sleep(2000);
		
		//String str=sel.getFirstSelectedOption().getText();
		List<WebElement> str1=sel.getOptions();
		for(int i=0;i<=str1.size();i++)
		System.out.println(str1.get(i).getText());
		Thread.sleep(3000);
		driver.close();
		
		
		
		

	}

	

}
