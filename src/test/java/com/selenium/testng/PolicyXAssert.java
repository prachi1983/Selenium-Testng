package com.selenium.testng;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class PolicyXAssert {
 WebDriver w;
  @BeforeTest
  public void preCondition() {
	  
	  String projectPath=System.getProperty("user.dir");
		
			String chromeDriverFilePath=projectPath+"\\ChomeDriver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverFilePath);
			 w=new ChromeDriver();
			
  }

  
  @Test
  public void policyXAssert() {
	  
	  w.get("https://www.policyx.com/");
	  String portalLabel=w.findElement(By.xpath("//*[@id=\"page1\"]/section[1]/div/div/div[2]/h1")).getText();
	  Assert.assertEquals("India's Most Trusted Insurance Portal", portalLabel);
	  
	  
	  String pageTitle=w.getTitle();
	  
	  Assert.assertTrue((pageTitle.contains("Insurance")),"Title doesnt contain insurance");
	  
	  w.findElement(By.xpath("//*[@id=\"page1\"]/header/div/div[4]/div[4]/a")).click();
	  
	 String claimLabel= w.findElement(By.xpath("//*[@id=\"page1\"]/div[2]/div/div/div[1]/h1")).getText();
	 
     Assert.assertEquals("CLAIM ASSISTANCE",claimLabel);
	 	String title=w.getTitle();
	 	Assert.assertTrue(title.contains("Claim Process"),"Title does not contain claim processes");
  }
  @AfterTest
  public void postCondition() {
	  
	  w.quit();
  }

}
