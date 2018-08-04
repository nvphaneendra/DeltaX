package com.deltaX.qa.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deltaX.qa.base.BaseClass;

/**
 * @author : Phani
 * File Created on :  Jul 14, 2018
 * File Name : RegistrationPage.java 
 */
public class RegistrationPage extends BaseClass {
	
	private static final Logger logger = Logger.getLogger(RegistrationPage.class);
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="department")
	WebElement depName;
	
	@FindBy(name="user_name")
	WebElement userName;
	
	@FindBy(name="user_password")
	WebElement passWord;
	
	@FindBy(name="confirm_password")
	WebElement confirmPassword;
	
	@FindBy(name="email")
	WebElement mailID;
	
	@FindBy(name="contact_no")
	WebElement contactNumber;
	
	@FindBy(xpath="//*[contains(@type,'submit')]")
	WebElement clickSubmit;
	
	public RegistrationPage() throws IOException {
		
		PageFactory.initElements(driver, this);
			
		}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void registrationForm(String fName, String lName, String uName, String pWord, String cPword, String eMail, String cNo, String cNum) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		userName.sendKeys(uName);
		passWord.sendKeys(pWord);
		confirmPassword.sendKeys(cPword);
		mailID.sendKeys(eMail);
		contactNumber.sendKeys(cNo);
	}
	
	public void submit() {
		clickSubmit.submit();	
	}
}