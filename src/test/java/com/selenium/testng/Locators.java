package com.selenium.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Locators {
  WebDriver w;
  
  
  @BeforeTest
  public void beforeTest() {
  }
  @Test
  public void locatorCssSelectorLinktext() throws Exception {
	  
	  
	  WebDriverManager.chromedriver().setup();
	  
	  w=new ChromeDriver();
		 
		 w.get("https://opensource-demo.orangehrmlive.com/");
		 
		 w.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		 
		 w.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		 w.findElement(By.cssSelector("input.button")).click();
		 Thread.sleep(3000);
		 
		 w.findElement(By.linkText("Welcome Paul")).click();
		 Thread.sleep(3000);
		 w.findElement(By.linkText("Logout")).click();
  }
  @AfterTest
  public void afterTest() {
  }

}
