package com.peoplesoft;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fusion.utility.HCMUtility;

public class LoginPS {
	private WebDriver driver ;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium_assets\\chromedriver.exe");	
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://10.1.131.163:8085/psp/HCM92DMO/?cmd=login&languageCd=ENG");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//HashMap<String, ArrayList<String>> hash = HCMUtility.readTestDataFile ("Data/data_TransferingEmployee.xls");
		HCMUtility.retryingFindInput(By.xpath("//input[@id='userid']"), "PS", driver);
		HCMUtility.retryingFindInput(By.xpath("//input[@id='pwd']"), "PS", driver);
		HCMUtility.retryingFindClick(By.xpath("//input[@class='ps-button']"), driver);
		Thread.sleep(3000);
		HCMUtility.retryingFindClick(By.xpath("//a[@id='pthdr2logout']"), driver);
	}

}
