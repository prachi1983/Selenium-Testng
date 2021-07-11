package com.selenium.testng;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class MutualLogin {
	WebDriver w;
  @BeforeTest
  public void preCondition() {
	  
	  
	  String projectPath=System.getProperty("user.dir");
		
		String chromeDriverFilePath=projectPath+"\\ChomeDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverFilePath);
		 w=new ChromeDriver();
		
  }
  @Test(priority=0,description="Verify login functionality by admin user",groups="Login Module",invocationCount=1,enabled=true)
  public void loginAdmin() {
	  
	  w.get("https://demo.testfire.net/login.jsp");
		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.name("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		Assert.assertTrue(false);

  }
  @Test(priority=1,description="Verify login functionality by Jsmith user",dependsOnMethods="loginAdmin",groups="Login Module")
  public void loginJsmith() {
	  
	  w.get("https://demo.testfire.net/login.jsp");
		
		w.findElement(By.id("uid")).sendKeys("jsmith");
		w.findElement(By.name("passw")).sendKeys("Demo1234");
		w.findElement(By.name("btnSubmit")).click();
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
  }
  @Test(priority=2,description="Verify login functionality by tuser user",groups="Login Module",enabled=false,dependsOnMethods="loginAdmin")
  public void loginTestUser() {
	  
	  w.get("https://demo.testfire.net/login.jsp");
		
		w.findElement(By.id("uid")).sendKeys("tuser");
		w.findElement(By.name("passw")).sendKeys("tuser");
		w.findElement(By.name("btnSubmit")).click();
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
  }
  @Test(priority=3,description="Verify login functionality by sspeed user",groups="Login Module",enabled=true,dependsOnMethods="loginAdmin")
  public void loginSpeedUser() {
	  
	  w.get("https://demo.testfire.net/login.jsp");
		
		w.findElement(By.id("uid")).sendKeys("sspeed");
		w.findElement(By.name("passw")).sendKeys("Demo1234");
		w.findElement(By.name("btnSubmit")).click();
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
  }
  
  @AfterTest
  public void postCondition() {
	  
	  w.quit();
  }

}
