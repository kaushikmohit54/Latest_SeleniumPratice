package Pratice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoSuggestions {
	public static void main(String[] args) throws InterruptedException {
		Logger logs=Logger.getLogger("devpinoyLogger");
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		logs.debug(driver.getCurrentUrl());
		driver.findElement(By.xpath(".//*[@id='button1']")).click();
		
		/*ArrayList<String> tab=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));*/
		driver.manage().window().maximize();
		
		
		Set<String> windowids=driver.getWindowHandles();
		
		Iterator<String> iter=windowids.iterator();
		
		String mainwindow=iter.next();
		String childwindow=iter.next();
		logs.debug(childwindow);
		logs.debug(mainwindow);
		driver.switchTo().window(childwindow);
	
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='primary-menu']/li[2]/ul/li[1]/a/span[2]")).click();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath(".//*[@id='primary-menu']/li[2]/ul/li[2]/a/span[1]/span/span"));
		act.moveToElement(ele).build().perform();
		driver.findElement(By.xpath(".//*[@id='primary-menu']/li[2]/ul/li[2]/ul/li[1]/a/span[1]/span/span")).click();
		driver.quit();
		
		
		
	
		
		
		
		
		
		
		
		
		
}
}