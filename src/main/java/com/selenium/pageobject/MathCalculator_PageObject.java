package com.selenium.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MathCalculator_PageObject extends TestBase {
	
	@FindBy(name = "Input")
	public WebElement InputTextBox;
	
	@FindBy(name = "plus")
	public WebElement plusBtn;

	@FindBy(name = "DoIt")
	public WebElement equalBtn;
	

    public void callPageFactory_MathCalculator_PageObj() {
    	
    	PageFactory.initElements(w, this);
    }
}
