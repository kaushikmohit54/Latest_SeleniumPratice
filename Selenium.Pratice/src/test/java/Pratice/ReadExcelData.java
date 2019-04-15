package Pratice;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelData
{
    public static void main(String args[]) throws Exception
    {
        FileInputStream fis = new FileInputStream("/Volumes/Krishna/Jar Files/poi-3.16-beta1/TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(0);
 
        int col_num = -1;
 
        for(int i=0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals("UserName"))
                col_num = i;
        }
 
        row = sheet.getRow(1);
        XSSFCell cell = row.getCell(col_num);
 
        String value = cell.getStringCellValue();
        System.out.println("Value of the Excel Cell is - "+ value);
    }
}