package com.framework.keywords;

import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

public class Generickeywords {

	WebDriver driver;
	public Hashtable<String,String> data;
	public Properties envprop;
	public ExtentTest test;
	public String KeywordKey;
	public String ObjectKey;
	public String ProceedOnFailKey;
	public String DataKey;
	
	/*********************GETTER SETTER FUNCTION **************************************/
	
	public String getKeywordKey() {
		return KeywordKey;
	}
	public Hashtable<String, String> getData() {
		return data;
	}
	public void setData(Hashtable<String, String> data) {
		this.data = data;
	}
	public Properties getEnvProp() {
		return envprop;
	}
	public void setEnvProp(Properties envprop) {
		this.envprop = envprop;
	}
	public ExtentTest getTest() {
		return test;
	}
	public void setTest(ExtentTest test) {
		this.test = test;
	}
	public void setKeywordKey(String KeywordKey) {
		this.KeywordKey = KeywordKey;
	}
	public String getObjectKey() {
		return ObjectKey;
	}
	public void setObjectKey(String ObjectKey) {
		this.ObjectKey = ObjectKey;
	}
	public String getProceedOnFailKey() {
		return ProceedOnFailKey;
	}
	public void setProceedOnFailKey(String ProceedOnFailKey) {
		this.ProceedOnFailKey = ProceedOnFailKey;
	}
	public String getDataKey() {
		return DataKey;
	}
	public void setDataKey(String DataKey) {
		this.DataKey = DataKey;
	}
	
	/*********************GETTER SETTER FUNCTION ENDS**************************************/
	
	
	
	public void openBrowser() {
		
		System.getProperty("webdriver.chrome.driver","E:\\software\\chromedriver_win32 (4)\\chromedriver.exe");
		System.getProperty("webdriver.gecko.driver","E:\\software\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		if(data.get(DataKey).equals("Mozilla")) {
			
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}else {
			
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		
	}
	
	public void navigate() {
		String objectkey;
		//System.out.println("inside navigate function");
		driver.get(envprop.getProperty(ObjectKey));
	}
	
	public void quit() {
		 if(driver!=null)
			 driver.quit();
		
	}
	
	
	
	public void click(String ObjectKey) {
		
		setObjectKey(ObjectKey);
		click();
	}
	
	public void type() {
		
		getElement(ObjectKey).sendKeys(data.get(DataKey));
		
	}
	
	public void type(String ObjectKey,String DataKey) {
		
		setObjectKey(ObjectKey);
		setDataKey(DataKey);
		type();
	}
	
	public void Wait(int time) {
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void click() {
		
		getElement(ObjectKey).click();
	}
	public WebElement getElement(String ObjectKey) {
		
		WebElement e=null;
		if(ObjectKey.endsWith("xpath")) {
		e=driver.findElement(By.xpath(envprop.getProperty(ObjectKey)));
		}else if(ObjectKey.endsWith("css")){
			
			e=driver.findElement(By.cssSelector(envprop.getProperty(ObjectKey)));
		}else if(ObjectKey.endsWith("id")) {
			
			e=driver.findElement(By.id(envprop.getProperty(ObjectKey)));
		}else if(ObjectKey.endsWith("linktext")) {
			
			e=driver.findElement(By.linkText(envprop.getProperty(ObjectKey)));
		}
		return e;	
		}
		
		
		public void selectway() {
			String way=data.get(DataKey);
			driver.findElement(By.xpath("//div[@id='travelOptions']/div/label[contains(text(),'"+way+"')]")).click();
		}
		
		public void select() {
			Wait(5000);
			getElement(ObjectKey).sendKeys(data.get(DataKey));
			
		}
		
	}
	
	

