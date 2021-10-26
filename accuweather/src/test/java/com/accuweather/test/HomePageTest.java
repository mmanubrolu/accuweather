package com.accuweather.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

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
	
	@Test(priority=3)
	public void validateHighestTemperatureTest() {
		
		try {
			 HashMap<Integer, String> map= homePage.getHighestTempList(prop.getProperty("city"));
			 System.out.println("high temperature map ::" + map);
			 
			 Iterator<Entry<Integer,String>> iterator = map.entrySet().iterator();
			 
			 Entry<Integer,String> firtstItem = iterator.next();
			 Integer key =firtstItem.getKey();
			 String val= firtstItem.getValue();
			 
			 while(iterator.hasNext()) {
				 Entry<Integer,String> item = iterator.next();
				 Integer tempKey= item.getKey();
				 String tempVal=item.getValue();
				 int i= tempVal.compareTo(val);
				 if(i==1) {
					 key=tempKey;
					 val= tempVal;
				 }
				
			 }
			 System.out.println("Highest temperature ::  " + val);
			 System.out.println("Highest temperature days::  " );
			 Iterator<Entry<Integer,String>> iterator1 = map.entrySet().iterator();
			 while(iterator1.hasNext()) {
				 Entry<Integer,String> item = iterator1.next();
				 if(val.trim()==item.getValue().trim()) {
					 System.out.println("    " + item.getKey());
				 }
				
			 }
			 
			 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=4)
	public void validateLowestTemperatureTest() {
		
		try {
			 HashMap<Integer, String> map= homePage.getLowestTempList(prop.getProperty("city"));
			 System.out.println("Lowest temperature map ::" + map);
			 
			 Iterator<Entry<Integer,String>> iterator = map.entrySet().iterator();
			 
			 Entry<Integer,String> firtstItem = iterator.next();
			 Integer key =firtstItem.getKey();
			 String val= firtstItem.getValue();
			 
			 while(iterator.hasNext()) {
				 Entry<Integer,String> item = iterator.next();
				 Integer tempKey= item.getKey();
				 String tempVal=item.getValue();
				 int i= tempVal.compareTo(val);
				 if(i== -1) {
					 key=tempKey;
					 val= tempVal;
				 }
				
			 }
			 System.out.println("Lowest temperature ::  " + val);
			 System.out.println("Lowest temperature days::  " );
			 Iterator<Entry<Integer,String>> iterator1 = map.entrySet().iterator();
			 while(iterator1.hasNext()) {
				 Entry<Integer,String> item = iterator1.next();
				 if(val.trim()==item.getValue().trim()) {
					 System.out.println("    " + item.getKey());
				 }
				
			 }
			 
			 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=5)
	public void validateScreenshotTest() {
		try {
			homePage.captureScreenshot(prop.getProperty("city"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
