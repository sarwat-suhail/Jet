package com.framework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.framework.driver.Driver;
import com.framework.reports.ExtentManager;
import com.framework.util.Datautil;
import com.framework.util.XLS_Reader;

public class Base {
	public Properties prop;
	public Properties envprop;
	public XLS_Reader xls=null;
	public ExtentReports rep;
	public ExtentTest test;
	public Driver du=null;
	public String testName;
	@BeforeTest
	public void init() throws IOException {
		String s=this.getClass().getPackage().getName();
	String[] suitenamearray=s.split("\\.");
	
	
	
	String suiteName=suitenamearray[suitenamearray.length-1];
		
		
	if(prop==null)	
		prop=new Properties();
	    envprop=new Properties();
		
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resource\\env.properties");
		
				prop.load(fis);
				
			String testenv=prop.getProperty("env");
			
			 fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resource\\"+testenv+".properties");
			
			envprop.load(fis);
		
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(envprop.getProperty(suiteName+"_xls"));
		xls=new XLS_Reader(envprop.getProperty(suiteName+"_xls"));
		du=new Driver();
		du.setEnvprop(envprop);
		
		
		
	}
	
	@BeforeMethod
	public void initTest() {
		
	rep=ExtentManager.getInstance(envprop.getProperty("reportpath"));
	test=rep.createTest(testName);
	du.setTest(test);
	}
	
	@AfterMethod
	public void Quit() {
		
		/*if(du!=null)
			du.quit();*/
		if(rep!=null)
			rep.flush();
	}
	
	
	@DataProvider
	public Object[][] getData(Method method){
		
		testName=method.getName();
		
		return Datautil.getTestData(xls,testName);
	}
	
	
}
