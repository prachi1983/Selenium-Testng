package com.selenium.pageobject_test;

import org.testng.annotations.Test;

import com.selenium.pageobject.Blaze_PageObject;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Blaze_Test {
 Blaze_PageObject bz=new Blaze_PageObject();
 
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	  bz.openBrowser(bz.readPropertiesFileValue("browser"));
		bz.callPageFactory_Blaze_PageObj();
  }
  @Test
  public void blazeTest() throws Exception {
	  
	  bz.openApplication(bz.readPropertiesFileValue("blaze_url"));
	  bz.handleDropDown(bz.departureCityDropDown, "Boston");
	  bz.handleDropDown(bz.destinationCityDropDown, "London");
	  
	  bz.handleClickEvent(bz.findFlightsBtn);
	  String actualLabel= bz.verifyText(bz.flightLabel);
	  Assert.assertEquals(actualLabel, "Flights from Boston to London:");
	  bz.handleClickEvent(bz.firstFlight);
	  
	  String title=bz.verifyTitle();
	  
	  Assert.assertEquals(title, "BlazeDemo Purchase");
	  
	  String pageLabel=bz.verifyText(bz.pageLabel);
	  Assert.assertEquals(pageLabel, "Your flight from TLV to SFO has been reserved.");
	  
	  System.out.println(bz.verifyText(bz.airline));
	  
	  String airline=bz.verifyText(bz.airline);
	  String arr[]=airline.split(": ");
	  
	  String flightName=arr[1];
	  
	  Assert.assertEquals(flightName, "United");
	  
	  String flightNumber=bz.verifyText(bz.flightNumber);
	  String arr1[]=flightNumber.split(": ");
	  
	  String actualFlightNumber=arr1[1];
	  Assert.assertEquals(actualFlightNumber, "UA954");
	  
	  String price=bz.verifyText(bz.price);
	  String arr2[]=price.split(": ");
	  int actualPrice=Integer.parseInt(arr2[1]);
	   String taxes=bz.verifyText(bz.taxes);
	   
	   String arr3[]=taxes.split(": ");
		float actualTaxes=Float.parseFloat(arr3[1])	;
		
		String totalCost=bz.verifyText(bz.totalCost);
		
		String arr4[]=totalCost.split(": ");
		
		float actualtotalCost=Float.parseFloat(arr4[1]);
		
		Assert.assertEquals(actualtotalCost, actualPrice+actualTaxes);
	  
	  bz.handleTextBox(bz.name, "Jones Pence");
	  bz.handleTextBox(bz.address, "Observatory Circle, U.S");
	  bz.handleTextBox(bz.city, "Phoenix");
	  bz.handleTextBox(bz.state, "Arizona (AZ)");
	  bz.handleTextBox(bz.zipCode, "85001");
	  
	  bz.handleDropDown(bz.cardType, "American Express");
	  bz.handleTextBox(bz.creditCardNumber, "12345678");
	  bz.handleTextBox(bz.creditCardMonth, "12");
	  bz.handleTextBox(bz.creditCardYear, "2018");
	  bz.handleTextBox(bz.nameOnCard, "Jones Pence");
	  bz.handleCheckBox(bz.rememberMe);
	  bz.handleClickEvent(bz.purchaseFlightBtn);
	  
	  String pageTitle=bz.verifyTitle();
	  
	  Assert.assertEquals(pageTitle, "BlazeDemo Confirmation");
  }
  @AfterTest
  public void afterTest() {
	  
	  bz.closeBrowser();
  }

}
