package com.accuweather.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
		Actions actions= new Actions(driver);
		actions.moveToElement(searchBox);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(20000);
		temperature = driver.findElement(By.xpath("(//div[@class='temp'])[1]")).getText();
		return temperature;
	}
}
