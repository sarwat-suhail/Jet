package com.framework.driver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import com.aventstack.extentreports.ExtentTest;
import com.framework.keywords.Appkeywords;
import com.framework.util.Constants;
import com.framework.util.XLS_Reader;

public class Driver {

	public Properties prop;
	public Properties envprop;
	public ExtentTest test;
	public Appkeywords app=new Appkeywords();
	public void setTest(ExtentTest test) {
		this.test = test;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	public Properties getEnvprop() {
		return envprop;
	}
	public void setEnvprop(Properties envprop) {
		this.envprop = envprop;
	}
	
	
	
	public void executeKeywords(XLS_Reader xls,String testName,Hashtable<String,String> data) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
		
		
		
		
		int rowcount=xls.getRowCount(Constants.KEYWORD_SHEET);
		
		for(int rnum=2;rnum<=rowcount;rnum++) {
			
			app.setData(data);
			app.setTest(test);
			app.setEnvProp(envprop);
			
			String TCID=xls.getCellData(Constants.KEYWORD_SHEET, Constants.TCID_COL, rnum);
			
			if(TCID.equalsIgnoreCase(testName)) {
				
				String KeywordKey=xls.getCellData(Constants.KEYWORD_SHEET, Constants.KEYWORD_COL, rnum);
				String ObjectKey=xls.getCellData(Constants.KEYWORD_SHEET, Constants.OBJECT_COL, rnum);
				String ProceedOnFailKey=xls.getCellData(Constants.KEYWORD_SHEET, Constants.PROCEEDONFAIL_COL,rnum);
				String DataKey=xls.getCellData(Constants.KEYWORD_SHEET, Constants.DATA_COL, rnum);
				
			
				app.setKeywordKey(KeywordKey);
				app.setObjectKey(ObjectKey);
				app.setProceedOnFailKey(ProceedOnFailKey);
				app.setDataKey(DataKey);
				
			try {	
				Method method;
				
				method=app.getClass().getMethod(KeywordKey);


				
				method.invoke(app);
				
				
			}catch(Exception ex) {
				String c=ex.getMessage();
			System.out.println(c);
			}
			}
			
			
			
		}
		
		
		
		
		
	}
	
	public void quit() {
		if(app!=null)
			app.quit();
		
	}
}
