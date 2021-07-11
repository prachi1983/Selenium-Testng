package com.selenium.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Blaze_PageObject extends TestBase {
	
	

	@FindBy(name = "fromPort")
	public WebElement departureCityDropDown;
	

	@FindBy(name = "toPort")
	public WebElement destinationCityDropDown;
	
	@FindBy(css="input[type='submit'")
	public WebElement findFlightsBtn;
	
	@FindBy(xpath="/html/body/div[2]/h3")
	public WebElement flightLabel;
	
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr[1]/td[1]/input")
	public WebElement firstFlight;
	
	@FindBy(xpath="/html/body/div[2]/h2")
	public WebElement pageLabel;
	
	@FindBy(xpath="/html/body/div[2]/p[1]")
	public WebElement airline;
	
	@FindBy(xpath= "/html/body/div[2]/p[2]")
	public WebElement flightNumber;
	@FindBy(xpath=  "/html/body/div[2]/p[3]")
	public WebElement price;
	@FindBy(xpath=  "/html/body/div[2]/p[4]")
	public WebElement taxes;
	@FindBy(xpath=  "/html/body/div[2]/p[5]")
	public WebElement totalCost;
	

	
	@FindBy(id="inputName")
	public WebElement name;
	
	@FindBy(id="address")
	public WebElement address;
	@FindBy(id="city")
	public WebElement city;
	
	@FindBy(id="state")
	public WebElement state;
	
	@FindBy(id="zipCode")
	public WebElement zipCode;
	@FindBy(id="cardType")
	public WebElement cardType;
	@FindBy(id="creditCardNumber")
	public WebElement creditCardNumber;
	@FindBy(id="creditCardMonth")
	public WebElement creditCardMonth;
	@FindBy(id="creditCardYear")
	public WebElement creditCardYear;
	
	@FindBy(id="nameOnCard")
	public WebElement nameOnCard;
	
	@FindBy(id="rememberMe")
	public WebElement rememberMe;
	
	@FindBy(xpath= "/html/body/div[2]/form/div[11]/div/input")
	public WebElement purchaseFlightBtn;
    public void callPageFactory_Blaze_PageObj() {
    	
    	PageFactory.initElements(w, this);
    }
	

}
