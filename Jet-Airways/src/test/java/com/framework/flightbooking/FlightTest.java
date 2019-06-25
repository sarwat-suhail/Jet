package com.framework.flightbooking;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.framework.base.Base;

public class FlightTest extends Base{

	
	@Test(dataProvider="getData")
	public void bookFlightTest(Hashtable<String,String> data) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	du.executeKeywords(xls, testName, data);
		
	}
	
	
	
	
}
