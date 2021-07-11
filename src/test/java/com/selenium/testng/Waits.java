package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Function;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
public class Waits {
  @Test
  public void SynchronisationCode() throws Exception {
	  
	  
	  

	
	  	//public static void main(String args[]) throws Exception {

	  	//	SoftAssert st = new SoftAssert();

	  		String projectPath = System.getProperty("user.dir");
	  		System.setProperty("webdriver.chrome.driver", projectPath + "\\ChomeDriver\\chromedriver.exe");

	  		WebDriver w = new ChromeDriver(); 
	  		
		//w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  		
	  		
	  		w.manage().window().maximize(); 
	  		
	  		w.get("https://in.via.com/flight-tickets");

	  		w.findElement(By.id("wzrk-cancel")).click();

	  		// Select source location
	  		w.findElement(By.id("source")).clear();
	  		w.findElement(By.id("source")).sendKeys("Mumbai");
	  		Thread.sleep(3000);
	  	
	  		w.findElement(By.id("ui-id-1")).click();

	  		// Select target location

	  		w.findElement(By.id("destination")).clear();
	  		w.findElement(By.id("destination")).sendKeys("Pune");
	  		Thread.sleep(3000);

	  		w.findElement(By.id("ui-id-2")).click();
	  		
	  	Thread.sleep(4000);

	  	
	  		w.findElement(By.xpath("//*[@id=\"depart-cal\"]/div[4]/div[2]/div[6]/div[7]/div")).click();
	  		Thread.sleep(4000);

	  		
	  		w.findElement(By.id("search-flight-btn")).click();
	  		
	  		//Thread.sleep(10000);	
	  		
	  		//Use Explicit wait
	  		
	  		WebDriverWait wt=new WebDriverWait(w,30);
	  	wt.until(ExpectedConditions.visibilityOfElementLocated(
	  	By.xpath("//*[@id='cheap_flight_container']/div[2]/div/div[1]/div[3]/span[2]")));
	  		
	  		//Fluent wait 
	  		
	  		/*Wait<WebDriver> fluentwt = new FluentWait<WebDriver>(w)
	  				.withTimeout(Duration.ofSeconds(30))
	  				.pollingEvery(Duration.ofSeconds(5))
	  				.ignoring(NoSuchElementException.class); // this defines the exception to ignore

	  		
	  		fluentwt.until(ExpectedConditions.visibilityOfElementLocated(
	  				(By.xpath("//*[@id='cheap_flight_container']/div[2]/div/div[1]/div[3]/span[2]"))));

	  		*/
	  		
	  		String price = w.findElement(By.xpath("//*[@id='cheap_flight_container']/div[2]/div/div[1]/div[3]/span[2]"))
	  				.getText();

	  		

	  		System.out.println("Cheapest Flights is : " + price);


	  		w.quit();

	  		//st.assertAll();
	  	}



  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
