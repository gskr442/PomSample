package com.utest.testngListeners;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.utest.testBase.Base;

public class TestNGListeners extends Base implements ITestListener {

	public Method method;

	public void onTestStart(ITestResult result) {

		System.out.println("\nTestcase Started Execution and the details are : " +result.getName()+" \n");
	}

	public void onTestSuccess(ITestResult result) {
	
		System.out.println("\nTestcase execution is success and the details are : " +result.getName()+" \n");
		try{
		
			//getScreenShot(result.getName());
		}
		catch(Exception e) {
		//	System.out.println("Unable to take the screen shot : "+ e);
			System.out.println(e);
		}
		
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("TestCase Failed : "+ result.getName()+" \n");
		//getScreenShot(result.getName());
	
	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("\nTestcase has been Skipped and the details are : " +result.getName()+" \n");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		
	}

	public void onStart(ITestContext context) {

		System.out.println(
				"\n\n ========================================================== STARTING TESTCASE EXECUTION ========================================================== \n\n");
	}

	public void onFinish(ITestContext context) {

		System.out.println(
				"\n\n ========================================================== FINISHING TESTCASE EXECUTION ========================================================== \n\n");
	}

}
