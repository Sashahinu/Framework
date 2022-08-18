package com.learnautomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

//Screenshots , alerts , frames , windows , sync issue , javascript executor.
public class Helper {
	
	public static String captureScreenshot(WebDriver driver) 
	{ 
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Screenshotpath = System.getProperty("user.dir")+"/Screenshots/CRM_"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src,new File(Screenshotpath ));
			System.out.println("Screeshot ...captured ...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Screenshotpath;
		
	}
	
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);	
		
	}

}
