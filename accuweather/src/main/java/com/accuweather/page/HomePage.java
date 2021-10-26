package com.accuweather.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.accuweather.testbase.TestBase;

public class HomePage extends TestBase {
	
	// page repositories
	@FindBy(xpath="//img[@class='accuweather-logo ']")
	WebElement logo;
	
	@FindBy(xpath="//input[@class='search-input']")
	WebElement searchBox;
	
	@FindBy(xpath="//span[text()='Monthly']")
	WebElement monthly;
	
	// constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// operation interfaces or methods to access the functionality
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getTemperature(String city) throws InterruptedException {
		String temperature = null;
		searchBox.sendKeys(city);
		Thread.sleep(4000);
		Actions actions= new Actions(driver);
		actions.moveToElement(searchBox);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(20000);
		temperature = driver.findElement(By.xpath("(//div[@class='temp'])[1]")).getText();
		return temperature;
	}
	
	public HashMap<Integer, String> getHighestTempList(String city) throws InterruptedException{
		HashMap<Integer, String > tempMap = new HashMap<Integer, String>();
		
		searchBox.sendKeys(city);
		Thread.sleep(4000);
		Actions actions= new Actions(driver);
		actions.moveToElement(searchBox);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(20000);
		
		monthly.click();
		Thread.sleep(20000);
		
		driver.findElement(By.xpath("//h2[text()='October']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='September']")).click();
		Thread.sleep(10000);
		
		tempMap.put(1, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'1')])[2]/../..//div[@class='high  ']")).getText());
		tempMap.put(2, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'2')])[2]/../..//div[@class='high  ']")).getText());
		tempMap.put(3, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'3')])[3]/../..//div[@class='high  ']")).getText());
		tempMap.put(4, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'4')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(5, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'5')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(6, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'6')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(7, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'7')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(8, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'8')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(9, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'9')])[2]/../..//div[@class='high  ']")).getText());
		tempMap.put(10, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'10')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(11, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'11')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(12, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'12')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(13, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'13')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(14, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'14')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(15, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'15')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(16, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'16')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(17, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'17')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(18, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'18')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(19, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'19')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(20, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'20')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(21, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'21')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(22, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'22')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(23, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'23')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(24, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'24')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(25, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'25')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(26, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'26')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(27, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'27')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(28, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'28')])[1]/../..//div[@class='high  ']")).getText());
		tempMap.put(29, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'29')])[2]/../..//div[@class='high  ']")).getText());
		tempMap.put(30, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'30')])[2]/../..//div[@class='high  ']")).getText());
		
		System.out.println("high temperature map ::" + tempMap);
		return tempMap;
		
		
	}
	
	
	public HashMap<Integer, String> getLowestTempList(String city) throws InterruptedException{
		HashMap<Integer, String > tempMap = new HashMap<Integer, String>();
		
		searchBox.sendKeys(city);
		Thread.sleep(4000);
		Actions actions= new Actions(driver);
		actions.moveToElement(searchBox);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(20000);
		
		monthly.click();
		Thread.sleep(20000);
		
		driver.findElement(By.xpath("//h2[text()='October']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='September']")).click();
		Thread.sleep(10000);
		
		tempMap.put(1, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'1')])[2]/../..//div[@class='low']")).getText());
		tempMap.put(2, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'2')])[2]/../..//div[@class='low']")).getText());
		tempMap.put(3, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'3')])[3]/../..//div[@class='low']")).getText());
		tempMap.put(4, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'4')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(5, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'5')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(6, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'6')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(7, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'7')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(8, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'8')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(9, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'9')])[2]/../..//div[@class='low']")).getText());
		tempMap.put(10, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'10')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(11, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'11')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(12, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'12')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(13, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'13')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(14, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'14')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(15, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'15')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(16, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'16')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(17, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'17')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(18, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'18')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(19, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'19')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(20, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'20')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(21, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'21')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(22, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'22')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(23, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'23')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(24, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'24')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(25, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'25')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(26, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'26')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(27, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'27')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(28, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'28')])[1]/../..//div[@class='low']")).getText());
		tempMap.put(29, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'29')])[2]/../..//div[@class='low']")).getText());
		tempMap.put(30, driver.findElement(By.xpath("(//div[@class='date' and contains(text(),'30')])[2]/../..//div[@class='low']")).getText());
		
		System.out.println("Lowest temperature map ::" + tempMap);
		return tempMap;
		
		
	}
	public void captureScreenshot(String city) throws InterruptedException, IOException {
		searchBox.sendKeys(city);
		Thread.sleep(4000);
		Actions actions= new Actions(driver);
		actions.moveToElement(searchBox);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(10000);
		
		monthly.click();
		Thread.sleep(10000);
		
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File tagetFile = new File("C:\\Users\\malli\\workspace\\accuweather\\logs\\accuweathersnap.jpg");
		FileUtils.copyFile(sourceFile, tagetFile);
		
		Thread.sleep(10000);
		
	}
}
