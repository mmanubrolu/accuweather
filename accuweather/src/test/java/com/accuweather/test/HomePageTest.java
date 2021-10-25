package com.accuweather.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accuweather.page.HomePage;
import com.accuweather.testbase.TestBase;
import com.accuweather.util.Util;

public class HomePageTest extends TestBase {
	public HomePage homePage;
	public Util util;
	
	HomePageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		homePage = new HomePage();
		util = new Util();
	}
	
	@Test(priority=1)
	public void validateTitleTest() {
		String title = homePage.getTitle();
		System.out.println("Accuwether home page title :" + title);
	}
	
	@Test(priority=2)
	public void getTemperatureTest( ) {
		String temperature =null;
		try {
			temperature = homePage.getTemperature(prop.getProperty("city"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("City :: " + prop.getProperty("city") + "and its temperature ::" + temperature);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
