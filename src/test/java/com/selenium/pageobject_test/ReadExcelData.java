package com.selenium.pageobject_test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws Exception {

		String projectPath = System.getProperty("user.dir");
		String excelFile = projectPath + "\\TestData\\FDCal.xlsx";
		
		DataFormatter df=new DataFormatter();

		FileInputStream fin = new FileInputStream(excelFile);
		XSSFWorkbook wb = new XSSFWorkbook(fin);

		XSSFSheet sht = wb.getSheet("Sheet1");
		
		XSSFRow row=sht.getRow(1);
		
		XSSFCell value=row.getCell(0);
		
		String cellValue=df.formatCellValue(value);
		
		System.out.println(cellValue);
		
		int rowCount=sht.getLastRowNum();
		
		System.out.println("Row Count is : "+rowCount);
		
		
		wb.close();
		fin.close();
		

	}

}
