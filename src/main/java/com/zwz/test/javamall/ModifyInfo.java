package com.zwz.test.javamall;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
*@author  zhangwenzhe
*@date  2020年3月5日---下午5:52:08
*/
public class ModifyInfo {
	WebDriver driver;
	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		//隐式等待
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/javamall/login.html");
		Thread.sleep(3000);
		
	}
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
		
	}
	@Test(dataProvider="dp")
	public void modifyInfo(String username,String pwd,String phone) throws Exception {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@class='blue_btn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"menu_wrapper\"]/div[3]/div[4]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("nickname")).clear();
		driver.findElement(By.name("nickname")).sendKeys(username);
		Thread.sleep(1000);
		List<WebElement> sexElement = driver.findElements(By.name("sex"));
		for (WebElement webElement : sexElement) {
			if (!webElement.isSelected()) {
				webElement.click();
				break;
			}
		}
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('mybirthday')[0].value='1985-12-23';");
		Thread.sleep(2000);
		WebElement province = driver.findElement(By.name("province_id"));
		Select proSel=new Select(province);
		proSel.selectByIndex(1);
		Thread.sleep(2000);
		WebElement city=driver.findElement(By.name("city_id"));
		Select citySel=new Select(city);
		citySel.selectByIndex(1);
		Thread.sleep(2000);
		WebElement region=driver.findElement(By.name("region_id"));
		Select regionSel=new Select(region);
		regionSel.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(phone);
		Thread.sleep(4000);
		driver.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
	}
	@DataProvider(name="dp")
	public Object[][] getData() {
		Object[][] data= {{"bob1","123456","18730226516"},
				{"merar","123456","18730226517"},
				{"join","123456","18730226518"}
				};
		return data;
	}
}
