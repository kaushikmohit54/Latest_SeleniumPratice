package Pratice;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class textreading {

	public static void main(String[] args) throws IOException   {
		FileReader f1=new FileReader("D:\\Mohit_DatadrivenFramwork\\Zoho_P\\src\\com\\zoho\\project\\Repository\\mohit.txt");
		BufferedReader bfr = new BufferedReader(f1);	
		String x ="";
		
		while((x = bfr.readLine()) != null){
			//System.out.println(x);
		String a[]=x.split(" ");
		System.out.println(a[0]+"======"+a[1]);
			
			
		}
	}

}
