package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
public class BrowserStack {
	

	public static class JavaSample {
		public static final String USERNAME = "pavankumars1";
		  public static final String AUTOMATE_KEY = "yYzXtMpwZvrEVT7ykGME";
		  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

		  public static void main(String[] args) throws Exception {

		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browserName", "android");
		    caps.setCapability("device", "Samsung Galaxy S9 Plus");
		    caps.setCapability("realMobile", "true");
		    caps.setCapability("os_version", "9.0");
		    caps.setCapability("name", "Bstack-[Java] Sample Test");

		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		    driver.get("http://www.google.com");
		    WebElement element = driver.findElement(By.name("q"));

		    element.sendKeys("BrowserStack");
		    element.submit();

		    System.out.println(driver.getTitle());
		    driver.quit();

		  
		  

	  }
	}

}
