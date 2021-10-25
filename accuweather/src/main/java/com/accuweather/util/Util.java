package com.accuweather.util;

import com.accuweather.testbase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Util extends TestBase {
	public static int PAGE_LOAD_TIMEOUT=40;
	public static int IMPLICIT_LOAD_TIMEOUT=40;
	
	
	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions actions= new Actions(driver);
		actions.moveToElement(element).build().perform();
		element.click();
	}

}
