package com.deltaX.qa.atcs;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.deltaX.qa.base.BaseClass;
import com.deltaX.qa.pages.RegistrationPage;
import com.deltaX.qa.util.ReadData;
import com.deltaX.qa.util.ReadExcelData;

/**
 * @author : Phani
 * File Created on :  Jul 15, 2018
 * File Name : RegistrationPageTest.java 
 */
public class RegistrationPageTest extends BaseClass {
	
	private static final Logger logger = Logger.getLogger(RegistrationPageTest.class);
	
	@DataProvider(name="deltaXRegistation")	
	public Object[][] getRegisterData() {
		Object data[][] = ReadData.getTestData("Register");
		return data;
	}
	
	RegistrationPage registrationPage = null;
	
	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
		logger.info("===== SetUp method initialization is going on =====");
		initialization();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void pageTitle() {
		//String title = registrationPage.validateLoginPageTitle();
		System.out.println(driver.getTitle());
		
	}
	
	@Test(dataProvider = "deltaXRegistation")
	public void registerUser(String firstName, String lastName, String depName, String userName, String	passWord, String confirmPassword, String mailID, String	cNum) {
		logger.info("Enter the details to register in deltaX portal");	 
		registrationPage.registrationForm(firstName, lastName, depName, userName, passWord, confirmPassword, mailID, cNum);
		clickOnRegistrationSubmit();
	}
	
	@Test
	public void clickOnRegistrationSubmit() {
		logger.info("Clicking on submit button.");
	}

}
