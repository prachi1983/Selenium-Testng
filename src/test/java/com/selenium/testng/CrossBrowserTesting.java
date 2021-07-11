package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class CrossBrowserTesting {
String projectPath;
WebDriver w;
String chromeDriverFilePath;
String EdgeDriverFilePath;
String firefoxExePath;
  @BeforeClass
  public void PreCondition() {
	  
	  projectPath=System.getProperty("user.dir");
	 chromeDriverFilePath=projectPath+"\\ChomeDriver\\chromedriver.exe";
     EdgeDriverFilePath=projectPath+"\\EdgeDriver\\msedgedriver.exe";
     firefoxExePath=projectPath+"\\FirefoxDriver\\geckodriver.exe";
  }
  @Test(priority=0,description="Test to verify chrome driver")
  public void chromeDriver() {
	  
	 
		System.setProperty("webdriver.chrome.driver", chromeDriverFilePath);
		 w=new ChromeDriver();
		 
		 w.get("http://www.google.com");
		  w.quit();
  }
  
  @Test(priority=1,description="Test to verify Edge driver")
  public void EdgeDriver() {
	  
	  
		System.setProperty("webdriver.edge.driver", EdgeDriverFilePath);
		 w=new EdgeDriver();
		 
		 w.get("http://www.google.com");
		  w.quit();
		
  }
  
  @Test(priority=2,description="Validate application on firfox browser")
	public void firefoxBrowser() throws Exception {
		
		
		System.setProperty("webdriver.gecko.driver", firefoxExePath);
		w=new FirefoxDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.quit();
	
	}

  
  @AfterClass
  public void PostCondition() {
	  
	
  }

}
