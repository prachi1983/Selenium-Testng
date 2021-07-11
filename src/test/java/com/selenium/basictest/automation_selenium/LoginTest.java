package com.selenium.basictest.automation_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		
		String projectPath=System.getProperty("user.dir");
		
		String chromeDriverFilePath=projectPath+"\\ChomeDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverFilePath);
		WebDriver w=new ChromeDriver();
		
		w.get("https://demo.testfire.net/login.jsp");
		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.name("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
		w.quit();
		
		System.out.println("Login test case executed successfully");
		
		
		
		
		

	}

}
