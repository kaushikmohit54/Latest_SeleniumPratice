package project;


import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.qa.base.TestBase;



 

public class sikuli extends TestBase {
	
	
	
	@Test
	public void sit() throws FindFailed, InterruptedException {
		 Screen screen = new Screen();
		 Pattern username=new Pattern("F:\\GitRepo\\Selenium.Pratice\\iamges\\username.PNG");
		 Pattern password=new Pattern("F:\\GitRepo\\Selenium.Pratice\\iamges\\password.PNG");
		 Pattern loginbtn=new Pattern("F:\\GitRepo\\Selenium.Pratice\\iamges\\signBtn.PNG");
		 
		
		    driver.get("http://newtours.demoaut.com/");
		    screen.type(username,"mksharma");
		    screen.type(password,"mohit123");
		    screen.click(loginbtn);
		    //screen.wait(5);
		
	}

}
