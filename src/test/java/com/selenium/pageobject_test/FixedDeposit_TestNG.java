package com.selenium.pageobject_test;

import org.testng.annotations.Test;

import com.selenium.pageobject.PageObject_FixedDeposit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FixedDeposit_TestNG {

	PageObject_FixedDeposit fd = new PageObject_FixedDeposit();
	
	@DataProvider
	public Object[][] dp() {
		
		return new Object[][] {
			
			    new Object[] { "100000", "8", "5", "Simple Interest" },
				new Object[] { "200000", "8.5", "4", "Simple Interest" },
				new Object[] { "700000", "7.5", "2", "Simple Interest" }, };
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		
		fd.openBrowser(fd.readPropertiesFileValue("browser"));
		fd.callPageFactory_FixedDeposit_PageObj();

	}

	@Test(dataProvider = "dp")
	public void fd(String principle, String roi,String tenure,String frequency) throws Exception {

		fd.openApplication(fd.readPropertiesFileValue("fd_url"));
		
		fd.handleTextBox(fd.principalTextBox, principle);

		fd.handleTextBox(fd.roiTextBox, roi);

		fd.handleTextBox(fd.tenureTextBox, tenure);

		fd.handleDropDown(fd.tenurePeriodDropDown, "year(s)");

		fd.handleDropDown(fd.frequencyDropDown, frequency);

		fd.handleClickEvent(fd.calculateBtn);

		fd.waitSec(2);

		String maturityValue = fd.verifyText(fd.maturityValue);

		System.out.println("Maturity Value for "+principle+" : " + maturityValue);

	}

	@AfterTest
	public void afterTest() {
	
		fd.closeBrowser();
	}

}