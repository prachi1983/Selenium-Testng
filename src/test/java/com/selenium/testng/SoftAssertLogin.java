package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SoftAssertLogin {
	WebDriver w;
	SoftAssert sa;
  @BeforeTest
  public void preCondition() {
	  
	  String projectPath=System.getProperty("user.dir");
		
		String chromeDriverFilePath=projectPath+"\\ChomeDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverFilePath);
		 w=new ChromeDriver();
		
  }
  @Test(priority=0,description="Test case to verify login functionality")
  public void adminLogin() {
	  sa= new SoftAssert();
      w.get("https://demo.testfire.net/login.jsp");
	  
	  String loginPageTitle=w.getTitle();
	  
	  sa.assertEquals("Altoro Mutual", loginPageTitle);
		String loginPageUrl=w.getCurrentUrl();
		
		//Assert.assertTrue(loginPageUrl.contains("Login"));
		
		//sa.assertTrue("Url Doesnt contain login keyword", loginPageUrl.contains("login"));
		sa.assertTrue(loginPageUrl.contains("login"), "Url Doesnt contain login keyword");
	      String labelName=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1")).getText();
		
		sa.assertTrue(labelName.contains("Login"),"Label doesnt contain keyword login");
		
			w.findElement(By.id("uid")).sendKeys("admin");
			
			
			w.findElement(By.name("passw")).sendKeys("admin");
			w.findElement(By.name("btnSubmit")).click();
			
	  sa.assertAll();
	  
	  
  }
  
  
  @Test(priority=1,description="Test case to verify login functionality")
  public void adminLogout() {
	  
	  
	  String homePageTitle = w.getTitle();
		sa.assertEquals(homePageTitle, "Altoro Mutual");

		String homePageLabel = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1")).getText();
		sa.assertTrue(homePageLabel.contains("Admin"),"Home page label doesnt contain admin");

		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();


	  w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	  
	  sa.assertAll();
  }
  @AfterTest
  public void postCondition() {
	  w.quit();
  }
  
 

}
