package com.selenium.pageobject_test;

import org.testng.annotations.Test;

import com.selenium.pageobject.PageObject_FixedDeposit;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class FixedDeposit_DataDriven {

	PageObject_FixedDeposit fd = new PageObject_FixedDeposit();

	FileInputStream fin;
	XSSFWorkbook wb;
	XSSFSheet sht;
	XSSFRow row;
	XSSFCell principle, roi, tenure, frequency, maturityValue;
	DataFormatter df;

	@BeforeTest
	public void preCondition() throws Exception {

		fd.openBrowser(fd.readPropertiesFileValue("browser"));
		fd.callPageFactory_FixedDeposit_PageObj();

		/*************** Excel code ****************/
		df = new DataFormatter();
		fin = new FileInputStream(fd.readPropertiesFileValue("excelFilePath"));
		wb = new XSSFWorkbook(fin);
		sht = wb.getSheetAt(0);

	}

	@Test
	public void fd_DataDriven() throws Exception {

		int rowCount = sht.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {

			int j = 0;

			// i -> rows
			// j -> cells / columns

			row = sht.getRow(i);

			principle = row.getCell(j);
			String principleValue = df.formatCellValue(principle);

			roi = row.getCell(j + 1);
			String roiValue = df.formatCellValue(roi);

			tenure = row.getCell(j + 2);
			String tenureValue = df.formatCellValue(tenure);

			frequency = row.getCell(j + 3);
			String frequencyValue = df.formatCellValue(frequency);
			;

			fd.openApplication(fd.readPropertiesFileValue("fd_url"));

			fd.handleTextBox(fd.principalTextBox, principleValue);

			fd.handleTextBox(fd.roiTextBox, roiValue);

			fd.handleTextBox(fd.tenureTextBox, tenureValue);

			fd.handleDropDown(fd.tenurePeriodDropDown, "year(s)");

			fd.handleDropDown(fd.frequencyDropDown, frequencyValue);

			fd.handleClickEvent(fd.calculateBtn);

			fd.waitSec(2);

			String maturityValue = fd.verifyText(fd.maturityValue);

			System.out.println("Maturity Value for "+principleValue+"  : " + maturityValue);

		}
	}

	@AfterTest
	public void postCondition() throws Exception {

		fd.closeBrowser();
		wb.close();
		fin.close();

	}

}
