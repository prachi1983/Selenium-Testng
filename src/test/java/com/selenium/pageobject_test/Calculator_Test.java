package com.selenium.pageobject_test;

import org.testng.annotations.Test;

import com.selenium.pageobject.Calculator_PageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Calculator_Test {
	Calculator_PageObject c=new Calculator_PageObject();

	@BeforeTest
	public void preCondition() throws Exception {
		
		c.openBrowser(c.readPropertiesFileValue("browser"));
		c.callPageFactory_Calculator_PageObj();
	}

	@Test(priority = 0, description = "verify addition operation")
	public void addOperation() throws Exception {
		
		c.openApplication(c.readPropertiesFileValue("calculator_url"));
		
		c.handleTextBox(c.firstInputNumber_TextBox, "5");
		c.handleDropDown(c.operator_DropDown, "+");
		c.handleTextBox(c.secondInputNumber_TextBox, "5");
		
		c.handleClickEvent(c.goBtn);
		
		c.waitSec(3);
		
	    String outputValue=c.verifyText(c.getOutputValue);
	    
	    System.out.println("Add : "+outputValue);
	    
	    
		
		
	}

	@Test(priority = 1, description = "verify subtraction operation")
	public void subOperation() throws Exception {
		
		c.handleTextBox(c.firstInputNumber_TextBox, "8");
		c.handleDropDown(c.operator_DropDown, "-");
		c.handleTextBox(c.secondInputNumber_TextBox, "5");
		
		c.handleClickEvent(c.goBtn);
		
		c.waitSec(3);
		
	    String outputValue=c.verifyText(c.getOutputValue);
	    
	    System.out.println("Sub : "+outputValue);
	
	}

	@Test(priority = 2, description = "verify division operation")
	public void divOperation() throws Exception {
		
		c.handleTextBox(c.firstInputNumber_TextBox, "10");
		c.handleDropDown(c.operator_DropDown, "/");
		c.handleTextBox(c.secondInputNumber_TextBox, "2");
		
		c.handleClickEvent(c.goBtn);
		
		c.waitSec(3);
		
	    String outputValue=c.verifyText(c.getOutputValue);
	    
	    System.out.println("Div : "+outputValue);
	
	}

	@Test(priority = 3, description = "verify multiplication operation")
	public void mulOperation() throws Exception {
		
		c.handleTextBox(c.firstInputNumber_TextBox, "3");
		c.handleDropDown(c.operator_DropDown, "*");
		c.handleTextBox(c.secondInputNumber_TextBox, "3");
		
		c.handleClickEvent(c.goBtn);
		
		c.waitSec(3);
		
	    String outputValue=c.verifyText(c.getOutputValue);
	    
	    System.out.println("Multiply : "+outputValue);
	
	}



  @AfterTest
  public void afterTest() {
	  c.closeBrowser();
  }
  

}
