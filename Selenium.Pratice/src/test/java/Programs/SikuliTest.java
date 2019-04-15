package Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class SikuliTest {

	public static void main(String[] args) throws FindFailed, InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Asutosh\\Desktop\\Chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://172.25.10.98/#/login");
		
		Screen s = new Screen();
		
		s.type("C:\\Users\\Asutosh\\Desktop\\Email.PNG","srinirepolead@mailinator.com");
		
		s.type("C:\\Users\\Asutosh\\Desktop\\password.PNG","Test@123");
		
		s.click("C:\\Users\\Asutosh\\Desktop\\Loginbutton.PNG");
		
		Thread.sleep(3000);
		
		s.click("C:\\Users\\Asutosh\\Desktop\\viewDetails.PNG");
		
	}

}
