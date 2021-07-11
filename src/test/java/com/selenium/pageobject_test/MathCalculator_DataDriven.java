package com.selenium.pageobject_test;

import org.testng.annotations.Test;

import com.selenium.pageobject.MathCalculator_PageObject;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class MathCalculator_DataDriven {
	
	MathCalculator_PageObject mcal=new MathCalculator_PageObject();
  
 

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "10", "5","15" },
      new Object[] { "20", "20","40" },
      new Object[] { "5", "5","10" },
      new Object[] { "1", "1","2" },
    };
    
    
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	  mcal.openBrowser(mcal.readPropertiesFileValue("mathcalBrowser"));
	 mcal.callPageFactory_MathCalculator_PageObj();
  }

  @Test(dataProvider = "dp")
  public void f(String number1, String number2,String output) throws Exception {
	  mcal.openApplication(mcal.readPropertiesFileValue("mathCalUrl"));
	  
	  
	  mcal.upendTextBox(mcal.InputTextBox, number1);
	  
	  mcal.handleClickEvent(mcal.plusBtn);
	  mcal.upendTextBox(mcal.InputTextBox, number2);
	  mcal.handleClickEvent(mcal.equalBtn);
	
  
	  
	  String addNum=mcal.VarifyTextBoxText(mcal.InputTextBox);
	  
	  int actualOutput=Integer.parseInt(addNum);
	  int outputValue=Integer.parseInt(output);
	  
	  Assert.assertEquals(outputValue, actualOutput);
	  
	
	 // System.out.println(addNum);
	  
	  
  }
  @AfterTest
  public void afterTest() throws Exception {
	  
	  mcal.closeBrowser();
	  

  }

}
