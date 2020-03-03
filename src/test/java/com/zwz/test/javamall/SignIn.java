package com.zwz.test.javamall;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
*@author  zhangwenzhe
*@date  2020年2月25日---上午10:23:54
*/
public class SignIn extends BaseJavamall{
	
	@Test
	public void signIn() throws InterruptedException {
		driver.findElement(By.linkText("注册")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("tom123456");
		Thread.sleep(1000);
		driver.findElement(By.id("reg_email")).sendKeys("1528094996@qq.com");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(By.id("reg_passwd_r")).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(By.id("iptlogin")).sendKeys("1234");
		Thread.sleep(1000);
		driver.findElement(By.className("blue_btn")).click();
	}
}
