package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
 

public class sikuli {
	public WebDriver driver;
	
	
	@Test
	public void sit() throws FindFailed, InterruptedException {
		 Screen screen = new Screen();
		 Pattern username=new Pattern("F:\\GitRepo\\Selenium.Pratice\\iamges\\username.PNG");
		 Pattern password=new Pattern("F:\\GitRepo\\Selenium.Pratice\\iamges\\password.PNG");
		 Pattern loginbtn=new Pattern("F:\\GitRepo\\Selenium.Pratice\\iamges\\signBtn.PNG");
		 
		 WebDriverManager.chromedriver().setup();
			
		    driver=new ChromeDriver();	
		    driver.manage().window().maximize();
		    driver.get("http://newtours.demoaut.com/");
		    screen.type(username,"mksharma");
		    screen.type(password,"mohit123");
		    screen.click(loginbtn);
		    screen.wait(5);
		
	}

}
