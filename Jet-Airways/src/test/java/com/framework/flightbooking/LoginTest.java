package com.framework.flightbooking;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.framework.base.Base;

public class LoginTest extends Base{

	@Test(dataProvider="getData")
	public void doLoginTest(Hashtable<String,String> data) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	du.executeKeywords(xls, testName, data);
		
	}
	
	
	
	
	
	
}
