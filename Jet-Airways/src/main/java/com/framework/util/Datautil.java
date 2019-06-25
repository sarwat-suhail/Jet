package com.framework.util;
import java.util.Hashtable;

public class Datautil {

 public static Object[][] getTestData(XLS_Reader xls , String testName) {
		
		String sheetName="Data";
		int teststartrowno=0;
		while(!xls.getCellData(sheetName, 0, teststartrowno).equals(testName)) {
			
			teststartrowno++;
		}
		
	int colstartrowno=teststartrowno+1;
	int datastartrowno=teststartrowno+2;
	int rows=0;
	while(!xls.getCellData(sheetName, 0, datastartrowno+rows).equals("")) {
		rows++;
	}
		
	int cols=0;
	while(!xls.getCellData(sheetName, cols, colstartrowno).equals("")) {
		
		cols++;
	}
	
	System.out.println("Test start from rowno "+teststartrowno);
	System.out.println("Total no of rows "+rows);
	System.out.println("Total no of cols "+cols);
	
	int dataRow=0;
	Object[][] data=new Object[rows][1];
	Hashtable<String,String> table=null;
	
	for(int rnum=datastartrowno;rnum<datastartrowno+rows;rnum++) {
		
		
		table=new Hashtable<String,String>();
		
		for(int cnum=0;cnum<cols;cnum++) {
			
			String key=xls.getCellData(sheetName, cnum, colstartrowno);
			String value=xls.getCellData(sheetName, cnum, rnum);
			table.put(key, value);
			
			
		}
		data[dataRow][0]=table;
		
		dataRow++;
		
		
	}
	
	return data;
	
	
	
		
	}
	
	
	
	
	
	
	
	
	
}
