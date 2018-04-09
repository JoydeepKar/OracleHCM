package com.fusion;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.fusion.utility.HCMUtility;

public class test_script_xfer_employee1 {
	private WebDriver driver ;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium_assets\\chromedriver.exe");	
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	
	@Test
	public void test_case_2() throws Exception {
		test_case_3();
	}
	public void test_case_3() throws Exception {
		driver.get("https://efrx-test.login.ap4.oraclecloud.com/oam/server/obrareq.cgi?encquery%3DQn5RxkqBg9O0Yx%2Fjvi1vYueICFVYGJ8PlTl%2FqW51rzMaBg7%2BZV8CBY4Tsy8F%2BXL8UEZafoUq32FllBIjbfLMODAH9IcyNL%2BMRurAbzzJ2xFmQN7g4QkS7P9zRxq1zMxl1yoknxEsmvKwSZtwkPpEelgjvLQY8GA6nRfTh7PuQadV%2FZoFGGYlNIDPt5%2BLw46DdaxGCu958enCE1gBAFOhNM8VUMG65bB0jONqe38c%2Fg9stdGkAYdv2PmyJVjuDy%2BAo1E79R%2FfPBxXepNgQz9MNJN24glh%2Bi4oO%2FyhPsiBJGfHHTgulY8FuKWp0gRCE3WvQHHQB8LjVEiZhXwopOCUIfpndXb0oMUm9pfhHaCEySmKVIT1gktZmR23jlS%2BmdiEJ31Hb%2BR4Vx10ifL2AEB75%2B%2BGU1pdHS4ZeP4K%2BQn%2FbM41cHm47ELzBC%2B5lGs6LEKBrZNy%2FGOx4sI1cvX2Iq0RIqxgCPpNBJZyODyeJCxjl6XChOf5NFSgzcQG8Dfp5co23ZH0KQbHcvyqeCTV1vUgvA%3D%3D%20agentid%3DOraFusionApp_11AG%20ver%3D1%20crmethod%3D2&ECID-Context=1.005Pat7DqoX6mJSLmEH7iZ0003gP00008K%3BkXjE");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		HashMap<String, ArrayList<String>> hash = HCMUtility.readTestDataFile ("Data/data_TransferingEmployee.xls");
		HCMUtility.retryingFindInput(By.xpath("//input[@id='userid']"), hash.get("User ID").get(0), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='password']"), hash.get("Password").get(0), driver);
		HCMUtility.takeSnapShot(driver, "Login");
		driver.findElement(By.xpath("//button[@id='btnActive']")).click();
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//a[@id='pt1:_UISmmLink']"),driver);
		HCMUtility.retryingFindClick(By.xpath("//a[@id='pt1:nv_itemNode_workforce_management_person_management']"), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:q1:value00::content']"), hash.get("Name").get(0), driver );
		HCMUtility.retryingFindClick(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:q1::search']"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:table1:_ATp:table2:0:gl1']"), driver);
		HCMUtility.retryingFindClick(By.xpath("//td[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:edit::popArea']"), driver);
		HCMUtility.retryingFindClick(By.xpath("//tr[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:updBtn']/td[2]"), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:effectiveDate::content']"), hash.get("Effective Start Date").get(0), driver);
		new Select(driver.findElement(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:actionsName1::content']"))).selectByVisibleText(hash.get("Action").get(0));
		HCMUtility.senseCursorState(driver);
		new Select(driver.findElement(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:actionReason::content']"))).selectByVisibleText(hash.get("Action Reason").get(0));
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:cb10']"),driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:r:JobDe1:0:jobId::content']"), hash.get("Job").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:r:JobDe1:0:gradeId::content']"), hash.get("Grade").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:r:JobDe1:0:departmentId::content']"), hash.get("Department").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:r:JobDe1:0:locationId::content']"), hash.get("Location").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:r:tt1:review']/a/span"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:2:AP1:tt1:submit']/a/span"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:2:AP1:tt1:okWarningDialog']"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:2:AP1:tt1:okConfirmationDialog']"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.id("_FOpt1:_UIScmil1u"), driver);
		HCMUtility.sendKeysToPage(By.tagName("html"), "alt y", driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.id("_FOpt1:_UISlg1"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.id("_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAyes"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.id("Confirm"), driver);
		HCMUtility.senseCursorState(driver);

        
        



	
	
	}
}