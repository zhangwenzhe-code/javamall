package com.zwz.test.javamall;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
*@author  zhangwenzhe
*@date  2020年3月5日---上午11:38:52
*/
public class AddUsers extends BaseJavamall2{
	@Test(dataProvider="dp")
	public void addUsers(String nickname,String pwd,String name,int sex,String date,String email,int level) throws InterruptedException, Exception {
		try {
			Thread.sleep(3000);
			//会员
			WebElement memu=driver.findElement(By.xpath("//*[@id=\"parent26\"]/a/div[2]/img"));
			Actions action=new Actions(driver);
			//悬浮
			action.moveToElement(memu).perform();
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
//			JavascriptExecutor executor=(JavascriptExecutor) driver;
//			//System.out.println("document.querySelector(\"#addForm > table > tbody > tr:nth-child(3) > td:nth-child(2) > span > input.combo-text.validatebox-text\").value="+"\""+date+"\"");
//			
//			executor.executeScript("document.querySelector(\"#addForm > table > tbody > tr:nth-child(3) > td:nth-child(2) > span > input.combo-text.validatebox-text\").value="+"\""+date+"\"");
//			Thread.sleep(3000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("document.getElementsByClassName('combo-text validatebox-text validatebox-invalid')[0].value='1984-10-23';document.getElementsByName('birthday')[0].value='1984-10-23';");
			Thread.sleep(3000);
			driver.findElement(By.name("member.email")).sendKeys(email);
			Thread.sleep(3000);
			WebElement levelEle = driver.findElement(By.xpath("//*[@id=\"addForm\"]/table/tbody/tr[5]/td/select"));
			Select secLevel = new Select(levelEle);
			secLevel.selectByIndex(level);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[text()='保存']")).click();
			Thread.sleep(2000);
			Boolean flag = new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {

				@Override
				public Boolean apply(WebDriver d) {
					return d.getPageSource().contains("保存会员成功");
				}
			});
			Assert.assertTrue(flag);
		} catch (Exception |Error e) {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("images/modifyInfoerror.png"));
			Assert.fail(e.getMessage());
		}
	}
	@DataProvider(name="dp")
	public Object[][] getData() {
		Object[][] data= {{"bob4","123456","bob4",1,"2020-03-05","1528094996@qq.com",1},
				{"merar2","123456","merar2",1,"2020-02-05","1528094996@qq.com",2},
				{"join2","123456","join2",0,"2020-01-05","1528094996@qq.com",3}
				};
		return data;
		
		
	}
}
