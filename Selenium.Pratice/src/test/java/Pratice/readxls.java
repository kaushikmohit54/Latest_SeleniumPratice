package Pratice;

import com.qa.util.Xls_Reader;

public class readxls {

	public static void main(String[] args) {
		
		
		Xls_Reader xls=new Xls_Reader("C:\\my desktop\\Zoho_P\\src\\da.xlsx");
		int rcount=xls.getRowCount("Sheet1");
		for(int i=2;i<=rcount;i++){
			System.out.println(xls.getCellData("Sheet1", "username", i));
			System.out.println(xls.getCellData("Sheet1", "password", i));
			
			xls.setCellData("Sheet1", "Status", 5, "Pass");
			
			
			
			
			
		}

	}

}
