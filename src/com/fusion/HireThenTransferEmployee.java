package com.fusion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.fusion.utility.HCMUtility;

import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HireThenTransferEmployee {
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
	public void testHireEmployee() throws Exception {
		driver.get("https://efrx-test.login.ap4.oraclecloud.com/oam/server/obrareq.cgi?encquery%3DQn5RxkqBg9O0Yx%2Fjvi1vYueICFVYGJ8PlTl%2FqW51rzMaBg7%2BZV8CBY4Tsy8F%2BXL8UEZafoUq32FllBIjbfLMODAH9IcyNL%2BMRurAbzzJ2xFmQN7g4QkS7P9zRxq1zMxl1yoknxEsmvKwSZtwkPpEelgjvLQY8GA6nRfTh7PuQadV%2FZoFGGYlNIDPt5%2BLw46DdaxGCu958enCE1gBAFOhNM8VUMG65bB0jONqe38c%2Fg9stdGkAYdv2PmyJVjuDy%2BAo1E79R%2FfPBxXepNgQz9MNJN24glh%2Bi4oO%2FyhPsiBJGfHHTgulY8FuKWp0gRCE3WvQHHQB8LjVEiZhXwopOCUIfpndXb0oMUm9pfhHaCEySmKVIT1gktZmR23jlS%2BmdiEJ31Hb%2BR4Vx10ifL2AEB75%2B%2BGU1pdHS4ZeP4K%2BQn%2FbM41cHm47ELzBC%2B5lGs6LEKBrZNy%2FGOx4sI1cvX2Iq0RIqxgCPpNBJZyODyeJCxjl6XChOf5NFSgzcQG8Dfp5co23ZH0KQbHcvyqeCTV1vUgvA%3D%3D%20agentid%3DOraFusionApp_11AG%20ver%3D1%20crmethod%3D2&ECID-Context=1.005Pat7DqoX6mJSLmEH7iZ0003gP00008K%3BkXjE");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		HashMap<String, ArrayList<String>> hash = HCMUtility.readTestDataFile ("Data/data_HireEmployee.xls");
		HCMUtility.retryingFindInput(By.xpath("//input[@id='userid']"), hash.get("User ID").get(0), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='password']"), hash.get("Password").get(0), driver);
		HCMUtility.takeSnapShot(driver, "Login");
		driver.findElement(By.xpath("//button[@id='btnActive']")).click();
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//div[@id='pt1:_UISpgl53u']/div/a[@id='pt1:_UISmmLink']"), driver);
		HCMUtility.retryingFindClick(By.xpath("//a[@id='pt1:nv_itemNode_workforce_management_new_person']"), driver);
		HCMUtility.retryingFindClick(By.xpath("//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:_FOTsdiAddCwkDefaultRegional::icon']"), driver);
		HCMUtility.retryingFindClick(By.xpath("//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:_FOTRaT:0:RAtl1']"), driver);
		HCMUtility.retryingFindClick(By.xpath("//button[@id='_FOd1::msgDlg::cancel']"), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:inputDate1::content']"), hash.get("Hire Date").get(0), driver);
		new Select(driver.findElement(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice1::content']"))).selectByVisibleText(hash.get("Hire Action").get(0));
		HCMUtility.senseCursorState(driver);
		new Select(driver.findElement(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice2::content']"))).selectByVisibleText(hash.get("Hire Reason").get(0));
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice3::content']"), hash.get("Legal Employer").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:r1:0:it1::content']"), hash.get("Person Number").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.checkTypedInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:r1:0:it1::content']"), hash.get("Person Number").get(0), driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:r1:0:i1:4:selectOneChoice4::content']"), driver)).selectByVisibleText(hash.get("Title").get(0));
		HCMUtility.checkTypedInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:r1:0:it1::content']"), hash.get("Person Number").get(0), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:r1:0:i1:7:it20::content']"), hash.get("Last Name").get(0), driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:soc3::content']"), driver)).selectByVisibleText(hash.get("Gender").get(0));
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:id3::content']"), hash.get("Date of Birth").get(0), driver);
		HCMUtility.sendKeysToPage(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:id3::content']"), "Page DOWN", driver);
		HCMUtility.sendKeysToPage(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:id3::content']"), "Page DOWN", driver);
		HCMUtility.retryingFindClick(By.xpath("//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r2:0:AT2:_ATp:create::icon']"), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r2:0:AT2:_ATp:table2:0:iclov1::content']"), hash.get("Country").get(0), driver);
		HCMUtility.senseCursorState(driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r2:0:AT2:_ATp:table2:0:soc2::content']"), driver)).selectByVisibleText(hash.get("NationalIDType").get(0));
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r2:0:AT2:_ATp:table2:0:it1::content']"), hash.get("National ID").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:tt1:next']/a/span"), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:countrylov::content']"), hash.get("Country").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:i1:0:inputText17::content']"), hash.get("Address Line 1").get(0), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:i1:1:inputText18::content']"), hash.get("Address Line 2").get(0), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:i1:3:inputText21::content']"), hash.get("City").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:i1:4:inputText27::content']"), hash.get("Postal Code").get(0), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:i1:5:inputText22::content']"), hash.get("State").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.sendKeysToPage(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:i1:5:inputText22::content']"), "page down", driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:pt_r1:0:AT1:_ATp:create::icon']"), driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:pt_r1:0:AT1:_ATp:table1:0:soc1::content']"), driver)).selectByVisibleText(hash.get("Type").get(0));
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:pt_r1:0:AT1:_ATp:table1:0:iclov1::content']"), hash.get("Country").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:pt_r1:0:AT1:_ATp:table1:0:it2::content']"), hash.get("Area Code").get(0), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:pt_r1:0:AT1:_ATp:table1:0:it3::content']"), hash.get("Number").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:pt_r2:0:AT1:_ATp:create::icon']"), driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:pt_r2:0:AT1:_ATp:table1:0:soc1::content']"), driver)).selectByVisibleText("Work E-Mail");
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:pt_r2:0:AT1:_ATp:table1:0:it1::content']"), hash.get("E-Mail").get(0), driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:pt_r3:0:soc2::content']"), driver)).selectByVisibleText(hash.get("Marital Status").get(0));
		HCMUtility.senseCursorState(driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:pt_r3:0:soc4::content']"), driver)).selectByVisibleText(hash.get("Religion").get(0));
		HCMUtility.senseCursorState(driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:pt_r3:0:hoc2::content']"), driver)).selectByVisibleText(hash.get("Highest Education Level").get(0));
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:tt1:next']"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:NewPe1:0:businessUnitId::content']"), hash.get("Business unit").get(0), driver);
		HCMUtility.senseCursorState(driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:NewPe1:0:selectOneChoice1::content']"), driver)).selectByVisibleText(hash.get("Person Type").get(0));
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:jobId::content']"), hash.get("Job").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.checkTypedInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:jobId::content']"), hash.get("Job").get(0), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:gradeId::content']"), hash.get("Grade").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:departmentId::content']"), hash.get("Department").get(0), driver);
		HCMUtility.checkTypedInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:gradeId::content']"), hash.get("Grade").get(0), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:locationId::content']"), hash.get("Location").get(0), driver);
		HCMUtility.senseCursorState(driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:selectOneRadio1::content']"), driver)).selectByVisibleText(hash.get("Working at Home").get(0));
		HCMUtility.senseCursorState(driver);
		HCMUtility.checkTypedInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:locationId::content']"), hash.get("Location").get(0), driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:selectOneChoice1::content']"), driver)).selectByVisibleText(hash.get("Worker Category").get(0));
		HCMUtility.senseCursorState(driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:selectOneChoice3::content']"), driver)).selectByVisibleText(hash.get("Assignment Category").get(0));
		HCMUtility.senseCursorState(driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:selectOneChoice2::content']"), driver)).selectByVisibleText(hash.get("Hourly Paid or Salaried").get(0));
		HCMUtility.senseCursorState(driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:soc1::content']"), driver)).selectByVisibleText(hash.get("Full Time or part Time").get(0));
		HCMUtility.senseCursorState(driver);
		new Select(HCMUtility.waitForObject(By.xpath("//select[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:JobDe1:0:selectOneRadio2::content']"), driver)).selectByVisibleText(hash.get("Working as Manager").get(0));
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:r3:0:i1:0:ManagerNameId::content']"), hash.get("Name").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//img[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:r1:0:AT1:_ATp:cil113::icon']"), driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:r1:0:AT1:_ATp:table1:0:selectOneChoice1::content']"), hash.get("Payroll").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.checkTypedInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:r1:0:AT1:_ATp:table1:0:selectOneChoice1::content']"), hash.get("Payroll").get(0), driver);
		HCMUtility.retryingFindClick(By.xpath("//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:tt1:next']"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:3:pt1:SP1:r1:0:r5:0:idSalaryBasis::content']"), hash.get("Salary Basis").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:3:pt1:SP1:r1:0:r5:0:idSalaryAmount::content']"), hash.get("Salary Amount").get(0), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:3:pt1:SP1:r6:0:ph2::_afrDscl']"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:3:pt1:SP1:tt1:next']"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:4:pt1:AP1:tt1:submit']/a"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.sendKeysToPage(By.tagName("html"), "alt Y", driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.xpath("//button[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:4:pt1:AP1:tt1:okConfirmationDialog']"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.id("_FOpt1:_UIScmil1u"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.id("_FOpt1:_UISlg1"), driver);
		HCMUtility.senseCursorState(driver);
		HCMUtility.retryingFindClick(By.id("Confirm"), driver);
		HCMUtility.senseCursorState(driver);

	}
	
	@Test
	public void testTransaferEmployee() throws Exception {
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
