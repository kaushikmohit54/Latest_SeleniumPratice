package seplePratice;

import java.io.IOException;

import org.testng.annotations.Test;

public class ReadAutoIt {
	@Test
	public void test() throws IOException {
		Runtime.getRuntime().exec("C:\\Users\\mohit.k\\git\\iMAGENEcsi-Automation\\src\\test\\resources\\TestData\\Files\\FisheUpload.exe");
		
	}
	

}
