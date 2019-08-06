//package seplePratice;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class dataprovideer {
//	
//	@Test(dataProvider="driverTest")
//	public void testCaseData(String wish,String communi,String id) {
//		System.out.println(wish+communi+id);
//		
//	}
//	
//	@DataProvider(name="driverTest")
//	public Object[][] getData() throws IOException {
//		//Object[][] data= {{"hello","text","1"},{"sdf","tesdfxt","2"},{"hellsdfo","texsdft","3"}};
//		
//		FileInputStream fis=new FileInputStream("F:\\GitRepo\\Selenium.Pratice\\Book1.xlsx");
//	    XSSFWorkbook wb=new XSSFWorkbook(fis);
//	    XSSFSheet sh=wb.getSheetAt(0);
//	    int rowcount=sh.getPhysicalNumberOfRows();
//	    XSSFRow row=sh.getRow(0);
//	    int colcount=row.getLastCellNum();
//	    		Object Data[][]=new Object[rowcount-1][colcount];
//	    		Data[0][0]=
//	    		Data[0][1]=
//	    		Data[0][]=
//		//return data;
//		//return data;
//		
//	}
//
//}
