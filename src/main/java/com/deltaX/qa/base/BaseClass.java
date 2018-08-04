package com.deltaX.qa.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import com.deltaX.qa.base.BaseClass;
import com.deltaX.qa.util.Constants;
import com.deltaX.qa.util.PropertyUtil;
import com.deltaX.qa.util.TestUtil;

/**
 * @author : Phani
 * File Created on :  Jul 14, 2018
 * File Name : BaseClass.java 
 */
public class BaseClass {
	
private static final Logger logger = Logger.getLogger(BaseClass.class.getName());
	
	public static WebDriver driver;
	public static String screen;
	
	public ITestResult result;	
		
	public static void initialization() {
		
		try {
		String osName = System.getProperty("os.name");
		logger.info("Current OS name ::: =====>" +osName);
		String browserName = PropertyUtil.getProperty("browser");
		
		if(osName.startsWith("Windows")) {
			
			if(PropertyUtil.getProperty("browser").equals("chrome")) {
			
			System.setProperty(Constants.WEBDRIVER_CHROME_DRIVER, System.getProperty("user.dir")+"/resources/win/chromedriver.exe");	
			driver = new ChromeDriver();
			
			} 
			else if(browserName.equals("firefox")){
			
			System.setProperty(Constants.WEBDRIVER_GECKO_DRIVER, System.getProperty("user.dir")+"/resources/win/geckodriver.exe");	
			driver = new FirefoxDriver();
			
		    }
			else if(browserName.equals("IE")){
				
			System.setProperty(Constants.WEBDRIVER_IE_DRIVER, System.getProperty("user.dir")+"/resources/win/IEDriverServer.exe");	
			driver = new InternetExplorerDriver();
		
	        } else {
	        	logger.info("No proper browser driver was not found... Please add required driver properly.. !!!");
	        }						
		} else if (osName.startsWith("Linux")) {
			
			if(PropertyUtil.getProperty("browser").equals("chrome")) {				
				System.setProperty(Constants.WEBDRIVER_CHROME_DRIVER, System.getProperty("user.dir")+"/resources/linux/chromedriver");	
				driver = new ChromeDriver();			
			
		}
	} else {
		logger.info("Current OS requirement was not configured corretly... Please contact Admin or Automation Test Engineer to setup environment properly...");
	}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(TestUtil.SCRIPT_TIMEOUT, TimeUnit.SECONDS);
		
		logger.info("Launching the browser " +PropertyUtil.getProperty("browser")+ " and enter required URL " +PropertyUtil.getProperty("URL"));
		driver.get(PropertyUtil.getProperty("URL"));
		Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void failed() {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("/src/main/java/com/deltaX/qa/TestReport/Screenshorts/testFailed.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void log4J() {
		String log4jConfPath = "log4j.proprties";
		PropertyConfigurator.configure(log4jConfPath);
	}
}