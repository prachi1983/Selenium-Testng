package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AssignmentAssert {
 WebDriver w;
 SoftAssert sa;
  @BeforeTest
  public void beforeTest() {
  }
  @Test
  public void assignmentAssert() {
	  sa =new SoftAssert();
	  

	  WebDriverManager.chromedriver().setup();
	  
	  w=new ChromeDriver();
		 
		 w.get("https://compendiumdev.co.uk/");
	String pageLable=	 w.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/div/h1")).getText();
		sa.assertEquals(pageLable,"Do you want to test and develop software better?"); 
	 String pageTitle=w.getTitle();
	 sa.assertTrue(pageTitle.contains("Software Testing"), "pagrTitle doesnt contain software testing");
	
	 w.findElement(By.linkText("hire me")).click();
	 
	 String pageTitleHireMe=w.getTitle();
	 sa.assertTrue(pageTitleHireMe.contains("Consultancy"), "pagrTitle doesnt contain Consultancy");
		
	 String pageLabelHireMe=w.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/h1")).getText();
	 
	 sa.assertTrue(pageLabelHireMe.contains("Consultancy"), "pagrLabel doesnt contain Consultancy");
	 
	 w.findElement(By.linkText("e-training")).click();
	 
	 String pageTitleEtraining=w.getTitle();
	 sa.assertTrue(pageTitleEtraining.contains("Online Training"), "pagrTitle doesnt contain Online Training");
		
	 String pageLabelEtraining=w.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/h1")).getText();
	 
	 sa.assertTrue(pageLabelEtraining.contains("Online Training"), "pagrLabel doesnt contain Online Training");
	 
	 
	 w.findElement(By.linkText("books")).click();
	 
	 String pageTitleBooks=w.getTitle();
	 sa.assertEquals(pageTitleBooks, "Our Books");
	
		
	 String pageLabelBooks=w.findElement(By.cssSelector("h1.pageTitle")).getText();
	 
	 sa.assertTrue(pageLabelBooks.contains("Books"), "pagrLabel doesnt contain Books");
	 
	 w.findElement(By.linkText("face to face")).click();
	
	 String pageTitleFaceToFace=w.getTitle();
	 sa.assertEquals(pageTitleFaceToFace, "Training");
		
	 String pageLabelFaceToFace=w.findElement(By.cssSelector("h1.pageTitle")).getText();
	 sa.assertEquals(pageLabelFaceToFace, "Training");
	 sa.assertAll();
	  
	  
  }
  @AfterTest
  public void afterTest() {
	  
	  w.quit();
  }
  
  
  

}
