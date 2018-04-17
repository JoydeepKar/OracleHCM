package com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerChecking {
	public static void main(String[] s) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium_assets\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/#icon-trigger");
		//driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		Thread.sleep(4000);
//		driver.findElement(By.id("datepicker")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a[text()='20']")).click();
		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a[text()='20']")).click();
		//driver.quit();
	}
}
