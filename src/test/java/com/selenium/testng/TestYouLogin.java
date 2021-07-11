package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestYouLogin {
	WebDriver w;
  @BeforeTest
  public void preCondition() {
	  
	  
	  String projectPath=System.getProperty("user.dir");
		
		String chromeDriverFilePath=projectPath+"\\ChomeDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverFilePath);
		 w=new ChromeDriver();
		
  }
  @Test(priority=0,description="Test case to verify login to You Test with Selenium99")
  public void loginYou() {
	  
	  w.get("http://www.testyou.in/Login.aspx");
	  w.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("Selenium99");
	  w.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys("Selenium99");
	  w.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();
	  w.findElement(By.id("ctl00_headerTopStudent_lnkbtnSignout")).click();
  }
  @AfterTest
  public void postcondition() {
	  
	  w.quit();
  }

}
