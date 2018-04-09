package com.fusion.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HCMUtility {
	private static WebElement element;
	private static HSSFWorkbook workbook;
	private static HSSFSheet sheet;
	private static FileInputStream fis;
	private static int totanumberofcolumns;

	public static boolean retryingFindClick(By by, WebDriver driver) {
	    boolean result = false;
		if(waitForObject(by, driver).isDisplayed()){
		    int attempts = 0;
		    while(attempts < 3) {
		        try {
		            driver.findElement(by).click();
		            result = true;
		            break;
		        } catch(StaleElementReferenceException e) {
		        }
		        attempts++;
		    }
			
		}
	    return result;
	}

	public static boolean retryingFindInput(By by, String value, WebDriver driver) {
	    boolean result = false;
	    if(waitForObject(by, driver).isDisplayed()){
	    	driver.findElement(by).clear();
		    int attempts = 0;
		    while(attempts < 4) {
		        try {
		            driver.findElement(by).sendKeys(value);
		            result = true;
		            break;
		        } catch(StaleElementReferenceException e) {
		       }
		        attempts++;
		    }
	    }
	    return result;
	}
	
	public static void senseCursorState(WebDriver driver) throws InterruptedException {
			while(true) {
				if(driver.findElement(By.tagName("body")).getCssValue("cursor").equals("wait") || driver.findElement(By.tagName("body")).getCssValue("cursor").equals("progress")) {
					Thread.sleep(4000);
				}else {
					break;
				}
		}
	}
	
	public static void checkTypedInput(By by, String checkString, WebDriver driver){
		if(driver.findElement(by).getAttribute("value").equals(checkString)){
			//do nothing
			System.out.println("Entered correctly");
		}else{
			retryingFindInput(by, checkString, driver);
		}
		
	}
	
	public static void sendKeysToPage(By by, String direction, WebDriver driver){
		element = waitForObject(by, driver);
		if(direction.equalsIgnoreCase("page down")){
			element.sendKeys(Keys.PAGE_DOWN);
		}else if(direction.equalsIgnoreCase("page up")){
			element.sendKeys(Keys.PAGE_UP);
		}else if(direction.equalsIgnoreCase("alt Y")){
			element.sendKeys(Keys.chord(Keys.ALT, "y"));
		}
	}
	
	public static WebElement waitForObject(By by, WebDriver driver) {
		element = new WebDriverWait(driver,25).until(ExpectedConditions.visibilityOfAllElements(driver.findElement(by))).get(0);
		return element;
	}
	
	public static void inputUsingAction(By by, WebDriver driver, String value) {
		element = waitForObject(by, driver);
		new Actions(driver).moveToElement(element).click().sendKeys(element,value).build();
	}
	
	public int getRowCount(String filename, String sheetName) {
		try {
			fis = new FileInputStream(new File(filename));
			workbook = new HSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			Row rowkey = sheet.getRow(0);
			totanumberofcolumns = rowkey.getLastCellNum();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return sheet.getLastRowNum();
	}

	public static HashMap<String, ArrayList<String>> readTestDataFile (String filename) {
		FileInputStream fis = null;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		HashMap<String, ArrayList<String>> values = new HashMap<String, ArrayList<String>>();
		try {
			fis = new FileInputStream(new File(filename));
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheetAt(0);
			DataFormatter formatter = new DataFormatter();
			int totanumberofcolumns = 0;
			Row rowkey = sheet.getRow(0);
			totanumberofcolumns = rowkey.getLastCellNum();
			for (int rowindex = 1; rowindex <= sheet.getLastRowNum(); rowindex++) {
				Row rowvalue = sheet.getRow(rowindex);
				String key = null;
				for (int colindex = 0; colindex < totanumberofcolumns; colindex++) {
					Cell cellkey = rowkey.getCell(colindex);
					key = formatter.formatCellValue(cellkey);
					String value = null;
					Cell cellvalue = rowvalue.getCell(colindex);
					value = formatter.formatCellValue(cellvalue);
					if (!values.containsKey(key)) {
						ArrayList<String> valuearray = new ArrayList<String>();
						valuearray.add(value);
						values.put(key, valuearray);
						}
					else {
						values.get(key).add(value);
					}
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		return values;
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		String filename = fileWithPath+"_"+new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("Screens/"+filename+".png");
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
