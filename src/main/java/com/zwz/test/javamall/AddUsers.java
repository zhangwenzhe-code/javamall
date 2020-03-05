package com.zwz.test.javamall;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
*@author  zhangwenzhe
*@date  2020年3月5日---上午11:38:52
*/
public class AddUsers extends BaseJavamall2{
	@Test(dataProvider="dp")
	public void addUsers(String nickname,String pwd,String name,int sex,String date,String email,int level) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"parent26\"]/a/div[2]/img")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("会员列表")).click();
		Thread.sleep(3000);
		WebElement frame=driver.findElement(By.xpath("//*[@id=\"28\"]/iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		//添加button
		driver.findElement(By.xpath("//*[@id=\"tb\"]/a[1]/span/span")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement addframe=driver.findElement(By.xpath("//*[@id=\"tabs\"]/div[2]/div[3]/div/iframe"));
		driver.switchTo().frame(addframe);
		Thread.sleep(2000);
		driver.findElement(By.name("member.uname")).sendKeys(nickname);
		driver.findElement(By.name("member.password")).sendKeys(pwd);
		driver.findElement(By.name("member.name")).sendKeys(name);
		WebElement sexEle=driver.findElement(By.name("member.sex"));
		Select sexOptions=new Select(sexEle);
		sexOptions.selectByIndex(sex);
		Thread.sleep(2000);
//		JavascriptExecutor executor=(JavascriptExecutor) driver;
//		//System.out.println("document.querySelector(\"#addForm > table > tbody > tr:nth-child(3) > td:nth-child(2) > span > input.combo-text.validatebox-text\").value="+"\""+date+"\"");
//		
//		executor.executeScript("document.querySelector(\"#addForm > table > tbody > tr:nth-child(3) > td:nth-child(2) > span > input.combo-text.validatebox-text\").value="+"\""+date+"\"");
//		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//document.getElementsByClassName('combo-text validatebox-text validatebox-invalid')[0].value='1984-10-23'
		js.executeScript("document.getElementsByClassName('combo-text validatebox-text validatebox-invalid')[0].value='1984-10-23';document.getElementsByName('birthday')[0].value='1984-10-23';");
		Thread.sleep(3000);
		driver.findElement(By.name("member.email")).sendKeys(email);
		Thread.sleep(3000);
		WebElement levelEle = driver.findElement(By.xpath("//*[@id=\"addForm\"]/table/tbody/tr[5]/td/select"));
		Select secLevel = new Select(levelEle);
		secLevel.selectByIndex(level);
		Thread.sleep(5000);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		driver.findElement(By.xpath("//*[text()='保存']")).click();
		Thread.sleep(2000);

	}
	@DataProvider(name="dp")
	public Object[][] getData() {
		Object[][] data= {{"bob1","123456","bob1",1,"2020-03-05","1528094996@qq.com",1},
				{"merar","123456","merar",1,"2020-02-05","1528094996@qq.com",2},
				{"join","123456","join",0,"2020-01-05","1528094996@qq.com",3}
				};
		return data;
		
		
	}
}
