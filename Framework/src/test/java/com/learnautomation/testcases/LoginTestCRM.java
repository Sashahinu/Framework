package com.learnautomation.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.LoginPage;
import com.learnautomation.utilities.ExcelDataProvider;


public class LoginTestCRM extends BaseClass {
	
	   
	
	    @Test(priority=1)
		public void loginApp() throws InterruptedException
	    {
	    	
	    	
	    logger = report.createTest("Login to CRM");
	    
	    String uname = excel.getStringData("Sheet1", 0, 0);
	    String pwd = excel.getStringData("Sheet1",0,1);
	    
	    System.out.println(uname+"....."+pwd);
	    	
		LoginPage lp = PageFactory.initElements(driver,LoginPage.class);
		
		logger.info("Starting Application");
		lp.loginToCRM(uname, pwd); 
		
		logger.pass("LOGIN SUCCESSFUL");
		
	    }
	    
	    @Test(priority=2)
	    public void loginApp1() {
	    	
	    	logger = report.createTest("LOGOUT");
	    	logger.fail("LOGOUT FAILED");	
	    }

}
