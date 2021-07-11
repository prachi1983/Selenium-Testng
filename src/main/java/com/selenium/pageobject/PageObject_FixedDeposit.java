package com.selenium.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_FixedDeposit extends TestBase{

	//public String appURL = "https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html";

	@FindBy(id = "principal")
	public WebElement principalTextBox;

	@FindBy(name = "interest")
	public WebElement roiTextBox;

	@FindBy(id = "tenure")
	public WebElement tenureTextBox;

	@FindBy(name = "tenurePeriod")
	public WebElement tenurePeriodDropDown;

	@FindBy(css = "select#frequency")
	public WebElement frequencyDropDown;

	@FindBy(xpath = "//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")
	public WebElement calculateBtn;

	@FindBy(xpath = "//*[@id=\"resp_matval\"]/strong")
	public WebElement maturityValue;



		
	    public void callPageFactory_FixedDeposit_PageObj() {
	    	
	    	PageFactory.initElements(w, this);
	    }
		
		



	}

