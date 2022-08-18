package com.learnautomation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {
	
	public  WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setUpSuite() {
		
	   excel = new ExcelDataProvider();
	  
	   config = new ConfigDataProvider();
	   
	   ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/CRM"+Helper.getCurrentDateTime()+".html"));
	   report = new ExtentReports();
	   report.attachReporter(extent);
	   	
	   
	}
	
	@Parameters({"browser" , "urlToBeTested"})
	@BeforeClass
	public void setup(String browser, String url) {
		//System.out.println(config.getBrowser()+"url  "+config.getURL() );
		//driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		//driver = BrowserFactory.startApplication(driver,"Chrome","https://ui.cogmento.com");
		
		driver = BrowserFactory.startApplication(driver,browser,url);
	}
	
	@AfterMethod
	public void tearDownMethod( ITestResult result ) 
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
			try {
				logger.fail("TEST FAILED", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			try {
				logger.pass("TEST PASSED", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			try {
				logger.pass("TEST SKIPPED", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		report.flush();
		
	}
	
	/*
	@AfterMethod
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	} */
	
	
	
	
	
}
