package step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdefi {
	WebDriver driver;
	
	
	@Given("^Open the Firefox and launch the application$")
	public void open_the_Firefox_and_launch_the_application() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury hTours");
		driver.close();
	
	    
	}

	@When("^Enter the Username and Password$")
	public void enter_the_Username_and_Password() throws Throwable {
	   
	}

	@Then("^Reset the credential$")
	public void reset_the_credential() throws Throwable {
	   
	}
	
	@Given("^Open the chrome  and launch the application$")
	public void open_the_chrome_and_launch_the_application() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		Assert.assertEquals(driver.getTitle(), "Google");
		driver.close();
	    
	}

	
	
	
	
	

}
