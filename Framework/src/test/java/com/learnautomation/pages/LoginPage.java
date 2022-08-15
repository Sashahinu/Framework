package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	//New comment added  to check git functionalities
	
	@FindBy(name="email1") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//div[text()='Login']") WebElement loginButton;
	
	public void loginToCRM(String usname , String pwd) throws InterruptedException {
		uname.sendKeys(usname);
		Thread.sleep(5000);
		pass.sendKeys(pwd);
		Thread.sleep(5000);		
		loginButton.click();
	
	}
	
	
	

}
