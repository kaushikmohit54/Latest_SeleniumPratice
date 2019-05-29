package org.imagenecsi.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.imagenecsi.bot.Browserbot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.olo.bot.BrowserBot;

public class CommonElements {
	
	private static final Logger logger = LogManager.getLogger(CommonElements.class.getName());
	
	private Browserbot browser;
	private WebDriver driver;
	
	public CommonElements(WebDriver driver){
		this.driver = driver;
		browser = new Browserbot(driver);
	}
	
	public CommonElements initElements()
	{
		return PageFactory.initElements(driver, CommonElements.class);
	}
	
	// updated by sreeramya for SPPA sector info 
	
	@FindBy(id="selSector")
	private WebElement sector;  //  Locator for Sector in sector info
	
		
	@FindBy(id="overlay")
	private WebElement overlay;
	
	@FindBy(css="div[class^='statusBar']")
	private WebElement statusBar;
	
	@FindBy(css="div[class='header-container']>div>span:nth-child(3)>a")
	private WebElement signOutLink;
	
	@FindBy(className="error-msg")
	private WebElement logoutMessage;
	
	@FindBy(linkText="Back to login")
	private WebElement backToLoginLink;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li[2]/a[@href='/emp/logout-process']/i")
	private WebElement logoutButton;
	
	@FindBy(xpath="//button[@name='reset']")
	private WebElement resetButton;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement searchButton;
	
	public void waitForOverlayToHide() throws Exception{
		logger.info("waiting for loading message to disappear");
		browser.waitForNotVisible(overlay);
	}
	
	public void waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(String expectedText) throws Exception{
		waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBar(expectedText);
		waitForOverlayToHide();
	}
	
	public void waitForStatusBarToBeVisibleAndVerifyContainsTextCloseStatusBarAndWaitForOverlayToHide(String expectedText) throws Exception{
		waitForStatusBarToBeVisibleAndVerifyContainsText(expectedText);
		logger.info("closing status bar");
		browser.click(statusBar);
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
		waitForOverlayToHide();
	}
	
	public void waitForStatusBarToBeVisibleAndVerifyContainsText(String expectedText) throws Exception{
		logger.info("waiting for status bar to be visible");
		browser.waitForVisible(statusBar);
		logger.info("verifying expected text :'"+expectedText+"' in status bar");
		if(statusBar.getText().contains(expectedText))
		{
			logger.info(expectedText+" present");
			browser.assertTrue(true);
		}
		else{
			logger.info(expectedText+" not present");
			browser.assertTrue(false);
		}
	}
	
	public void waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBar(String expectedText) throws Exception{
		waitForStatusBarToBeVisibleAndVerifyText(expectedText);
		logger.info("closing status bar");
		browser.click(statusBar);
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
	}
	
	public void waitForStatusBarToBeVisibleAndVerifyText(String expectedText) throws Exception{
		logger.info("waiting for status bar to be visible");
		browser.waitForVisible(statusBar);
		logger.info("verifying expected text :'"+expectedText+"' in status bar");
		browser.verifyText(statusBar, expectedText);
	}
	
	
	public void logout() throws Exception
	{
		logger.info("Logout from the application");
		browser.waitForVisible(logoutButton);
		browser.click(logoutButton);
		browser.waitForVisible(logoutMessage);
		browser.click(backToLoginLink);
	}
	
	public void clickSignOutLink() throws Exception{
		logger.info("clicking signout link");
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
		browser.waitForEditable(signOutLink);
		browser.click(signOutLink);
	}
	
    public void clickResetButton() throws Exception{
    	logger.info("clicking reset button");
    	browser.waitForEditable(resetButton);
    	browser.click(resetButton);
    }
    
    public void clickSearchButton() throws Exception{
     	logger.info("clicking search button");
    	browser.waitForEditable(searchButton);
    	browser.click(searchButton);
    }
	
	/*public void represenetativeLogin() throws Exception
	{
		logger.info("Logout from the application");
		new LoginPage(driver).initElements().loginToTC(MCRepresentativeCredentialsProp.getMcRepresentativeUserName(), MCRepresentativeCredentialsProp.getMcRepresentativePassword());
	}*/
}
