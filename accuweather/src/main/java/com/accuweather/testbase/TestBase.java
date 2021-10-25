package com.accuweather.testbase;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.accuweather.util.Util;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\malli\\workspace\\accuweather\\accuweather\\src\\test\\java\\com\\accuweather\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initilization() {
		String browser = prop.getProperty("browser");
		if (!browser.isEmpty()) {
			if (browser.equals("chrome")) {
				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\malli\\workspace\\accuweather\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\malli\\workspace\\accuweather\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		} else {

			Assert.assertTrue(false, "Not able to load the browser ");

		}

	}

}
