package com.selenium.pageobject;

import org.testng.*;

import com.selenium.pageobject.TestBase;

public class ListenerCode implements ITestListener {
	
	
	public void onTestStart(ITestResult result) {

		//Reporter.log("Test Started : " + result.getName(),true);

	}

	public void onTestSuccess(ITestResult result) {

		Reporter.log("Test Case Passed : " + result.getName(),true);
		
		try {
			TestBase.takeScreenshotCode("Pass", result.getMethod().getMethodName()+".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {

		System.out.println("Test Case Failed : " + result.getName());
		
		try {
			TestBase.takeScreenshotCode("Fail", result.getMethod().getMethodName()+".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Test Case Skipped : " + result.getName());

	}

	public void onStart(ITestContext context) {

	//	System.out.println("Test Started : " + context.getName());

	}

	public void onFinish(ITestContext context) {

		System.out.println("On Finish: ");
		System.out.println(context.getPassedTests());
		System.out.println(context.getFailedTests());

	}



}
