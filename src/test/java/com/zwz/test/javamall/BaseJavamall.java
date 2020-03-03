package com.zwz.test.javamall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
*@author  zhangwenzhe
*@date  2020年2月25日---上午10:51:47
*/
public class BaseJavamall {
	WebDriver driver;
	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("http://localhost:8080/javamall/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void close() throws InterruptedException {
		driver.close();
		Thread.sleep(1000);
	}
}
