package com.deltaX.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author : Phani
 * File Created on :  Jul 29, 2018
 * File Name : ReadExcelData.java 
 */
public class ReadExcelData {
	
	FileInputStream inputStream = null;
	public Object readData(String filePath, String fileName, String sheetName) throws InvalidFormatException, IOException {
		File src = new File(filePath+"\\"+fileName);
		inputStream = new FileInputStream(src);
		Workbook getWorkBook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));		
		if(fileExtensionName.equals(".xlsx")) {
			getWorkBook = new XSSFWorkbook(inputStream);
		}		
		else if(fileExtensionName.equals(".xls")) {
			getWorkBook = new HSSFWorkbook(inputStream);
		}		
		Sheet getSheet = getWorkBook.getSheet(sheetName);
		int rowCount = getSheet.getLastRowNum() - getSheet.getFirstRowNum();		
		for(int i=0; i<rowCount+1; i++) {
			Row row = getSheet.getRow(i);			
			for(int j=0; j<row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getStringCellValue()+"||");
			}
			System.out.println();			
		}
		return rowCount;

	}
	
	public static void main(String[] args) throws InvalidFormatException, IOException {	
		ReadExcelData excelData = new ReadExcelData();
		String filePath = System.getProperty("user.dir")+"\\data";
		excelData.readData(filePath, "DeltaXtestData.xls", "Register");
	}
}