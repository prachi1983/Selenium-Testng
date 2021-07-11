package com.selenium.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hospital_PageObject extends TestBase {
	
	

	@FindBy(id = "email")
	public WebElement emailAdress;
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "user_role")
	public WebElement userRole;
	
	@FindBy(css="button[type='submit'")
	public WebElement loginBtn;
	
	@FindBy(xpath="/html/body/div[3]/header/nav/div/ul/li/a/i")
	public WebElement profile;
	
	
	
	@FindBy(xpath="/html/body/div[3]/header/nav/div/ul/li/ul/li[3]/a")
	public WebElement logout;
	

    public void callPageFactory_Hospital_PageObj() {
    	
    	PageFactory.initElements(w, this);
    }
  
}
