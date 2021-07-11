package com.selenium.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowserUsingWebdriverManager {
	WebDriver w;
  @BeforeTest
  public void beforeTest() {
  }

  @Test(priority=0,description="Test to verify chrome driver")
  public void chromeDriver() {
	  
	 WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", chromeDriverFilePath);
		 w=new ChromeDriver();
		 
		 w.get("http://www.google.com");
		  w.quit();
  }
  
  @Test(priority=1,description="Test to verify Edge driver")
  public void EdgeDriver() {
	  WebDriverManager.edgedriver().setup();
	  
		//System.setProperty("webdriver.edge.driver", EdgeDriverFilePath);
		 w=new EdgeDriver();
		 
		 w.get("http://www.google.com");
		  w.quit();
		
  }
  
  @Test(priority=2,description="Validate application on firfox browser")
	public void firefoxBrowser() throws Exception {
	  WebDriverManager.firefoxdriver().setup();
		
		//System.setProperty("webdriver.gecko.driver", firefoxExePath);
		w=new FirefoxDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.quit();
	
	}

  
  
  @AfterTest
  public void afterTest() {
  }

}
