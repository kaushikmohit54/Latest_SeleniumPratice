package project;

import java.io.IOException;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.base.TestBase;



import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON extends TestBase {

   
    String url,searchWord,linkText;
    JSONParser parser=new JSONParser();
    
    @BeforeMethod
    public void setup() throws FileNotFoundException, IOException, ParseException 
    {
    	initializationBrowser();
        Object obj = parser.parse(new FileReader("F:\\GitRepo\\Selenium.Pratice\\src\\test\\resources\\TestData\\data.json"));
        JSONObject jsonObject = (JSONObject) obj;
        
        url = (String) jsonObject.get("URL");
        searchWord = (String) jsonObject.get("SearchWord");
        linkText = (String) jsonObject.get("linkSearch");
            
       // driver = new ChromeDriver();
        driver.get(url);
        
    }
    
    @Test
    public void testSearch() throws FileNotFoundException, IOException, ParseException {
    
        driver.findElement(By.name("q")).sendKeys(searchWord);
        driver.findElement(By.name("btnK")).click();
        driver.findElement(By.linkText(linkText)).click();
        String webTitle = driver.getTitle();
        Assert.assertEquals(webTitle, linkText);
    }
    
    
}
