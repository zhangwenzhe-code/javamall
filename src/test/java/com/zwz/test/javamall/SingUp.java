package com.zwz.test.javamall;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
*@author  zhangwenzhe
*@date  2020年2月25日---上午10:51:29
*/
public class SingUp extends BaseJavamall{
	@Test
	public void signUp() throws Exception {
		driver.findElement(By.linkText("登录")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("tom123456");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(By.id("validcode")).sendKeys("1234");
		Thread.sleep(1000);
		driver.findElement(By.className("blue_btn")).click();
		Thread.sleep(6000);
	}
}
