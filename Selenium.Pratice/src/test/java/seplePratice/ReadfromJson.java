package seplePratice;

import java.io.FileReader;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadfromJson {
	

public static String pdfFilePath;
	
	@DataProvider(name="HappyFlow")
	public Object[][] apajitigoApplicationData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser()
		.parse(new FileReader(ReadfromJson.class.getResource(
				"/org/imagenecsi/login/loginDetails.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for (int i = 0; i < ja.size(); i++) {
			result[i][0] = ja.get(i);
		}
		return result;
	}

	
	@Test(dataProvider="HappyFlow")
	public void login(HashMap<String, String> data) throws Exception {
		System.out.println(data.get("IOleadUSername"));
          
  		
	}

}
