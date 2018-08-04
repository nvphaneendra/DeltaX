package com.deltaX.qa.Analyzer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.deltaX.qa.base.BaseClass;

/**
 * @author : Phani
 * File Created on :  Jul 14, 2018
 * File Name : CustomListener.java 
 */
public class CustomListener extends BaseClass implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("Failed TestCase");
		failed();
	}

	
	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
