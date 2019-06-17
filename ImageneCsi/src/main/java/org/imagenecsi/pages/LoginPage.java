package org.imagenecsi.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.imagenecsi.bot.Browserbot;
import org.imagenecsi.prop.LoginPageProp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.olo.util.PropertyReader.configProp;

public class LoginPage {
	
	private static final Logger logger = LogManager.getLogger(LoginPage.class.getName());
	
	private Browserbot browser;
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		browser = new Browserbot(driver);
	}
	
	public LoginPage initElements()
	{
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	@FindBy(id="email")
	private WebElement UserNameText;

	@FindBy(id="textPassword")
	private WebElement passwordText;
	
    @FindBy(xpath="//button[text()='Login']")
	private WebElement logginButton;	
	
	@FindBy(xpath="//img[@title='Forgot password']")
	private WebElement forgotPasswordLink;
	
	@FindBy(id="error")
	private WebElement errorMessage;
	
	//Method to login to CSI
	public void loginToImageneCSI(String username,String password) throws Exception{
			logger.info("typing username '"+username+"'");
			browser.type(UserNameText, username);
			logger.info("typing password '"+password+"'");
			browser.type(passwordText, password);
			logger.info("cliking login button");
			browser.click(logginButton); 
	}
	//method to verify forgot password link
	public void verifyForgotPasswordLinkVisible() throws Exception{
		logger.info("verifying forgot password link");
		browser.verifyEditable(forgotPasswordLink);
	}
	//method to click forgot password link
	public void clickForgotPassword() throws Exception{
		logger.info("clicking forgot password link");
		browser.click(forgotPasswordLink);
	}
	//verify page title method
	public void verifyPageTitle() throws Exception{
		logger.info("verifying page title");
		browser.Wait(1);
		String title = browser.getTitle();
		String expectedTitle = LoginPageProp.getexpectedTitle();
		if(!title.contains(expectedTitle)){
			browser.verifyFail("Page Title Not Matching Expected : "+expectedTitle+" but found Actual : "+title);
		}
	}
	//verify invalid login access
	public void verifyInvaliedLoginAccess() throws Exception{
		logger.info("verifying invalied login");
		logger.info("waiting for error message to visible");
		browser.waitForVisible(errorMessage);
		logger.info("verifying text in error message");
		browser.verifyText(errorMessage, LoginPageProp.getaccessDenied());
	}
	
}
