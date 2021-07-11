package com.selenium.pageobject_test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.pageobject.Hospital_PageObject;

public class Hospital_DataDriven {
	Hospital_PageObject hl=new Hospital_PageObject();
	
	FileInputStream fin1;
	XSSFWorkbook wb1;
	XSSFSheet sht1;
	XSSFRow row1;
	XSSFCell emailAddress, password, role;
	DataFormatter df1;
  @BeforeTest
  public void beforeTest() throws Exception {
	  

	  hl.openBrowser(hl.readPropertiesFileValue("browser"));
		hl.callPageFactory_Hospital_PageObj();
		
		df1 = new DataFormatter();
		fin1 = new FileInputStream(hl.readPropertiesFileValue("hospitalExcelFilePath"));
		wb1 = new XSSFWorkbook(fin1);
		sht1 = wb1.getSheetAt(0);

  }
  @Test
  public void login() throws Exception {
	  int rowCount = sht1.getLastRowNum();

		for (int i = 1; i <=rowCount; i++) {

			int j = 0;

			row1 = sht1.getRow(i);
			
			System.out.println(rowCount);
			
			emailAddress = row1.getCell(j);
			String emailAddressValue = df1.formatCellValue(emailAddress);
			password = row1.getCell(j+1);
			String passwordValue = df1.formatCellValue(password);
			
			role = row1.getCell(j+2);
			String roleValue = df1.formatCellValue(role);
			
			
			
	  hl.openApplication(hl.readPropertiesFileValue("hospitalUrl"));
	  hl.handleTextBox(hl.emailAdress, emailAddressValue);
	  
	  hl.handleTextBox(hl.password, passwordValue);
	  
	  hl.handleDropDown(hl.userRole, roleValue);
	  
	  hl.handleClickEvent(hl.loginBtn);
	  hl.waitSec(20);
	  hl.handleClickEvent(hl.profile);
	  
	  hl.waitSec(3);
	  
	  hl.handleClickEvent(hl.logout);
	  
	  
	  
		}  
  }
  @AfterTest
  public void afterTest() throws Exception {
	  
	 hl.closeBrowser();
	 
	 wb1.close();
	 fin1.close();
  }

}
