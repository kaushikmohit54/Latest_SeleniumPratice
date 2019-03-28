package project;

import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON {

    WebDriver driver;
    String url,searchWord,linkText;
    JSONParser parser=new JSONParser();
    
    @BeforeTest
    public void setup() throws FileNotFoundException, IOException, ParseException 
    {
        System.setProperty("webdriver.chrome.driver", "F:\\GitRepo\\Selenium.Pratice\\drivers\\chrome\\chromedriver.exe");
        Object obj = parser.parse(new FileReader("F:\\GitRepo\\Selenium.Pratice\\src\\test\\resources\\TestData\\data.json"));
        JSONObject jsonObject = (JSONObject) obj;
        url = (String) jsonObject.get("URL");
        searchWord = (String) jsonObject.get("SearchWord");
        linkText = (String) jsonObject.get("linkSearch");
            
        driver = new ChromeDriver();
        driver.get(url);
        
    }
    
    @Test
    public void testSearch() throws FileNotFoundException, IOException, ParseException {
    
        driver.findElement(By.id("lst-ib")).sendKeys(searchWord);
        driver.findElement(By.name("btnK")).click();
        driver.findElement(By.linkText(linkText)).click();
        String webTitle = driver.getTitle();
        
        Assert.assertEquals(webTitle, linkText);
    }
    
    @AfterTest
    public void tearDown()
    {
        driver.close();
        driver.quit();

    }
}
