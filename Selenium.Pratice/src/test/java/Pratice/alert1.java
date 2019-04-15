package Pratice;
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
import org.openqa.selenium.firefox.FirefoxDriver;


public class alert1 {
	public static void main(String[] args) {
		Logger logs=Logger.getLogger("devpinoyLogger");
		
		System.setProperty("webdriver.gecko.driver", "D:\\Mohit_DatadrivenFramwork\\Zoho_Project\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver;
		//driver=new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://money.rediff.com/gainers/bsc/daily/groupa");
		logs.debug(driver.getCurrentUrl());
		
		List<WebElement> cols=driver.findElements(By.xpath("//*@id ='leftcontainer'/table/tbody/tr[3]/td[2]"));
	    logs.debug(cols);
		System.out.println("cols"+cols.size());
		
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id = 'leftcontainer']/table/tbody/tr [3]/td [1]"));

		logs.debug(rows);
		System.out.println("rows"+rows.size());
		System.out.println("rows"+rows);
 		
		
		
			
			
		}
		
		
		
		
		
		
		
		
		
		
}
