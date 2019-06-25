
package com.framework.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLS_Reader {
public FileInputStream fis;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	public String path;
	private XSSFRow row;
	private XSSFCell cell;
	
	public XLS_Reader(String path) throws IOException {
		
		this.path=path;
		
		fis=new FileInputStream(path);
		
		workbook=new XSSFWorkbook(fis);
		
		fis.close();
	}
	
	public int getRowCount(String sheetName) {
		
		int index=workbook.getSheetIndex(sheetName);
		
		if(index<0) {
			
			return 0;
		}
			else {
				
				sheet=workbook.getSheetAt(index);
				
			int rowcount=	sheet.getLastRowNum();
			return rowcount+1;
				
			}
		}
	
	
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
		if(rowNum<0)
		return "";
		int index=workbook.getSheetIndex(sheetName);
		sheet=workbook.getSheetAt(index);
        if(index<0) 
		return "";
        
        
       row=sheet.getRow(rowNum-1);
       if(row==null)
    	   return "";
      cell= row.getCell(colNum);
      if(cell==null)
    	  return "";
      
      //System.out.println(cell.getCellType());
      
      if(cell.getCellType()==CellType.STRING) 
    	  
    	  return cell.getStringCellValue();
      else if(cell.getCellType()==CellType.NUMERIC) {
    	  
    	  return String.valueOf(cell.getNumericCellValue());}
      else if(cell.getCellType()==CellType.BOOLEAN) 
    	  return String.valueOf(cell.getBooleanCellValue());
    	  
      else 
    	  
    return String.valueOf(cell.getBooleanCellValue());
	
	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		
		}
		
		return "";
      }
	
		
	public String getCellData(String sheetName,String colName,int rowNum) {
		
		if(rowNum<0)
			return "";
		
		int index=workbook.getSheetIndex(sheetName);
		if(index<0)
			return "";
		
		sheet=workbook.getSheetAt(index);
		
		row=sheet.getRow(0);
		if(row==null)
			return "";
		
		int cellcount=row.getLastCellNum();
		int colNum = 0;
		for(int i=0;i<=cellcount;i++) {
			
			if(row.getCell(i).toString().trim().equals(colName.trim())) {
				
				colNum=i;
				break;
			}
				
		}
		
		if(colNum==-1)
			return "";
		
		
		row=sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		
		
		cell=row.getCell(colNum);
		if(cell==null)
			return "";
		
		if(cell.getCellType()==CellType.STRING)
			return cell.getStringCellValue();
		if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA)
			return String.valueOf(cell.getNumericCellValue());
		if(cell.getCellType()==CellType.BOOLEAN)
			return String.valueOf(cell.getBooleanCellValue());
		
		if(cell.getCellType()==CellType.BLANK)
			return "";
		
		return "";
		
		
		
		
		
		
	}
	
	
	
	
	
	
		
	}
	
	
	
	
	
	
	
	
	
