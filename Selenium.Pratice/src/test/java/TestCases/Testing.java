package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {
	public static String timesec=""+ System.currentTimeMillis();
	String username="username"+timesec.substring(5, 10);
	String fullname="fullname"+timesec.substring(5, 9);	
	String email="email"+timesec.substring(5, 9)+"@mailinator.com";
	
	
	WebDriver driver;
	
	@Test
	public void Login() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://admin-deepfaceauth-staging.signzy.app/login");
		driver.findElement(By.name("login")).sendKeys("signzy");
		
		driver.findElement(By.name("password")).sendKeys("1234");
		
		driver.findElement(By.xpath("//div[text()='Login']")).click();	
		driver.findElement(By.xpath("//input[contains(@aria-label,'Username')]")).sendKeys(username);
		TextFileReaderAndWriter txtreader=new TextFileReaderAndWriter();
		txtreader.writeDataToTextFile(username);
		System.out.println(txtreader.readApplicationIdFromTextFile());
		driver.findElement(By.xpath("//input[contains(@aria-label,'Full name')]")).sendKeys(fullname);
		
		driver.findElement(By.xpath("//input[contains(@aria-label,'Email ID')]")).sendKeys(email);
		
		driver.findElement(By.xpath("//input[contains(@aria-label,'Phone number')]")).sendKeys("1234567896");
		
		driver.findElement(By.xpath("//div[@class='v-btn__content'][contains(.,'Generate URL')]")).click();	
		
		driver.findElement(By.xpath("//div[@class='v-list__tile__title'][contains(.,'Delete User')]")).click();	
		
		WebElement uname=driver.findElement(By.xpath("//input[contains(@aria-label,'Username')]"));
		uname.sendKeys(txtreader.readApplicationIdFromTextFile());
		
		driver.findElement(By.xpath("(//div[contains(@class,'v-list__tile__title')])[21]")).click();
		driver.findElement(By.xpath("//div[@class='v-btn__content'][contains(.,'Find User')]")).click();		
		driver.findElement(By.xpath("//div[@class='v-btn__content'][contains(.,'Delete User')]")).click();	
	
		driver.findElement(By.xpath("(//div[@class='v-btn__content'][contains(.,'Yes')])[3]")).click();
		
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
   
	

}

