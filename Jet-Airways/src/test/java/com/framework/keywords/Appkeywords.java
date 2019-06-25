package com.framework.keywords;

import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

public class Appkeywords extends Generickeywords{


	public void signUp() {
	//	Wait(10000);
		//Actions action=new Actions(driver);
		
		//action.moveToElement(getElement("signup_xpath"),0,0).build().perform();
		//Wait(10000);
		driver.manage().window().maximize();
		getElement("signuplink_xpath").click();
		
	}
	
	
	
}
