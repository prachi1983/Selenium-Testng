 package com.selenium.webobject;

import org.testng.annotations.Test;

import com.selenium.pageobject.WebDriverListener;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;

public class Code_For_navigate_4 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\ChomeDriver\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();
		
	}

	@Test
	public void Code_For_navigate() throws Exception {
		
	//	w.get("https://www.selenium.dev/");
		  
		 //OR
		
		EventFiringWebDriver efw=new EventFiringWebDriver(w);		
		
		WebDriverListener wd_listener=new WebDriverListener();		
		efw.register(wd_listener);
		
		//efw.get("");

		
		//efw.findElement(By.xpath(""));
		
		efw.navigate().to("https://www.selenium.dev/");

		Thread.sleep(3000);
		
		efw.findElement(By.xpath("//a[text()='Downloads']")).click();
		
		Thread.sleep(3000);

		efw.navigate().back();
		
		Thread.sleep(3000);

		efw.navigate().forward();
		
		Thread.sleep(3000);		
		
		efw.navigate().back();


		Thread.sleep(3000);		
		
		efw.findElement(By.xpath("//a[text()='Projects']")).click();
		
		Thread.sleep(3000);

		efw.navigate().refresh();
		
		Thread.sleep(3000);

        
       
	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
