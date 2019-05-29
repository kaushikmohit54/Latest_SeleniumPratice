package seplePratice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileDownloadVerify {
 
 private WebDriver driver;
 
 private static String downloadPath = "C:\\DownloadFile";
 private String URL="http://all-free-download.com/free-photos/download/in_love_cosmos_flower_garden_220378.html";
 
 @BeforeClass
 public void testSetup() throws Exception{
	 System.setProperty("webdriver.gecko.driver", "F:\\GitRepo\\Selenium.Pratice\\drivers\\chrome\\geckodriver.exe");
	 FirefoxOptions option=new FirefoxOptions();
	 option.setProfile(firefoxProfile());
	 driver =new FirefoxDriver(option);
  driver.manage().window().maximize();
 }
 
  @Test
 public void example_VerifyExpectedFileName() throws Exception {
  driver.get(URL);
     driver.findElement(By.xpath("//text()[contains(.,'Free download this file now (664.01KB)')]/ancestor::a[1]")).click();
    
     Thread.sleep(10000);
     File getLatestFile = getLatestFilefromDir(downloadPath);
     String fileName = getLatestFile.getName();
     Assert.assertTrue(fileName.equals("in_love_cosmos_flower_garden_220378.zip"), "Downloaded file name is not matching with expected file name");
 }
 

 @AfterClass
 public void tearDown() {
  driver.quit();
 }
public static FirefoxProfile firefoxProfile() throws Exception {
  
  FirefoxProfile firefoxProfile = new FirefoxProfile();
  firefoxProfile.setPreference("browser.download.folderList",2);
  firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
  firefoxProfile.setPreference("browser.download.dir",downloadPath);
  firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/zip");
  
  return firefoxProfile;
 }
public boolean isFileDownloaded(String downloadPath, String fileName) {
 boolean flag = false;
    File dir = new File(downloadPath);
    File[] dir_contents = dir.listFiles();
      
    for (int i = 0; i < dir_contents.length; i++) {
        if (dir_contents[i].getName().equals(fileName))
            return flag=true;
            }

    return flag;
}

private boolean isFileDownloaded_Ext(String dirPath, String ext){
 boolean flag=false;
    File dir = new File(dirPath);
    File[] files = dir.listFiles();
    if (files == null || files.length == 0) {
        flag = false;
    }
   
    for (int i = 1; i < files.length; i++) {
     if(files[i].getName().contains(ext)) {
      flag=true;
     }
    }
    return flag;
}

private File getLatestFilefromDir(String dirPath){
    File dir = new File(dirPath);
    File[] files = dir.listFiles();
    if (files == null || files.length == 0) {
        return null;
    }

    File lastModifiedFile = files[0];
    for (int i = 1; i < files.length; i++) {
       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
           lastModifiedFile = files[i];
       }
    }
    return lastModifiedFile;
}
}
