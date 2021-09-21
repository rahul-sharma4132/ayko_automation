package com.ayko.driverSetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static WebDriver driver;

	public static WebDriver setupDriver(String browserName) {
		
		driver = null;
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.verboseLogging", "true");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
		if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
		return driver;

	}
	
	public static void tearDownDriver() {
		driver.quit();
	}

}
