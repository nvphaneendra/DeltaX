/**
 * 
 */
package com.deltaX.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author : Phani
 * File Created on :  Jul 30, 2018
 * File Name : ReadData.java 
 */
public class ReadData {

	static Workbook book;
	static Sheet sheet;
	
	public static String TESTDATA_PATH = System.getProperty("user.dir")+"\\data\\DeltaXtestData.xls";
	
	public static Object[][] getTestData(String sheetName) {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(TESTDATA_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "-----------" + sheet.getRow(0).getLastCellNum());
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadData.getTestData("Register");
		System.out.println("Execution ended");
	}
}
