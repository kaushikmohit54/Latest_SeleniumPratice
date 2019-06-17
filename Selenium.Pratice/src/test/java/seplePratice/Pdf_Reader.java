package seplePratice;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pdf_Reader {

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mohit.k\\git\\iMAGENEcsi-Automation\\drivers\\win\\chromedriver.exe");	
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.pdf995.com/samples/pdf.pdf");
		driver.manage().window().maximize();
		String Currentlink=driver.getCurrentUrl();
		URL url=new URL(Currentlink);
		InputStream is=url.openStream();
		BufferedInputStream fp=new BufferedInputStream(is);
		PDDocument document=null;
		document=PDDocument.load(fp);
		String pdfContent= new PDFTextStripper().getText(document);
		System.out.println(pdfContent);
		driver.quit();
	}
}