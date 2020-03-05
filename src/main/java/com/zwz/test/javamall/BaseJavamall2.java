package com.zwz.test.javamall;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
*@author  zhangwenzhe
*@date  2020年2月25日---上午10:51:47
*/
public class BaseJavamall2 {
	WebDriver driver;
	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		//隐式等待
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/javamall/admin/backendUi!main.do");
		driver.manage().window().maximize();
		Cookie cookie=new Cookie("JSESSIONID","0B5471038031A62AD1D3077A20BAC251");
		driver.manage().deleteAllCookies();
		driver.manage().addCookie(cookie);
		driver.get("http://localhost:8080/javamall/admin/backendUi!main.do");
		Thread.sleep(3000);
		
	}
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
		
	}
}
