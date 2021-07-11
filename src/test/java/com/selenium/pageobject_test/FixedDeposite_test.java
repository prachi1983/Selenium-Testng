package com.selenium.pageobject_test;

import org.testng.annotations.Test;

import com.selenium.pageobject.PageObject_FixedDeposit;


import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FixedDeposite_test {
	
	PageObject_FixedDeposit fd=new PageObject_FixedDeposit();
	
	  @BeforeTest
	  public void beforeTest() throws Exception {
		  

		  fd.openBrowser(fd.readPropertiesFileValue("browser"));
			fd.callPageFactory_FixedDeposit_PageObj();
		}
  @Test(priority = 0, description = "Test case to verify fixed deposit for '100000'", groups = "Fixed Deposit")
  public void fd_100000() throws Exception {
	  
	  
	  fd.openApplication(fd.readPropertiesFileValue("fd_url"));
		
		fd.handleTextBox(fd.principalTextBox, "100000");
		
		fd.handleTextBox(fd.roiTextBox, "8");

		fd.handleTextBox(fd.tenureTextBox, "3");
		
		fd.handleDropDown(fd.tenurePeriodDropDown, "year(s)");
		
		fd.handleDropDown(fd.frequencyDropDown, "Simple Interest");
		
		fd.handleClickEvent(fd.calculateBtn);
		
		fd.waitSec(2);
		
		String maturityValue=fd.verifyText(fd.maturityValue);
		
		System.out.println("Maturity Value for 1lakh FD : "+maturityValue);
		
		Assert.assertEquals(maturityValue, "124000.00");

  }


  

  @AfterTest
  public void afterTest() {
	  
	  fd.closeBrowser();

  }

}
