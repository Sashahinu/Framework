package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	//public ExcelDataProvider excel = new ExcelDataProvider();
	
	public XSSFWorkbook wb;
	
	public ExcelDataProvider() {
	
	File f = new File("/Users/safashabeer/eclipse-workspace/Framework/TestData/Login.xlsx");
	
	try 
	{
	FileInputStream fis = new FileInputStream(f);
	 wb  = new XSSFWorkbook(fis);
	}
	catch(Exception e) 
	{
		System.out.println(e.getMessage());
	}
	
	}
	
	
	//Method overloading concept
	
	public String getStringData(int Sheetindex, int row , int column) {
		
		return wb.getSheetAt(Sheetindex).getRow(row).getCell(column).getStringCellValue();
		
	}
	
    public String getStringData(String SheetName, int row , int column) {
		
		return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		
	}
    
    public double getNumericData(String SheetName, int row , int column) {
		
		return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
		
	}


}

