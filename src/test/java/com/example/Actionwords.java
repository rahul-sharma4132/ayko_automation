package com.example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ayko.driverSetup.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Actionwords {
	public static WebDriver driver;
	public Actionwords(String browserName) {

		
		driver = null;
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = DriverManager.setupDriver("chrome");
		}
		
		if (browserName.equalsIgnoreCase("Firefox")) {
			driver = DriverManager.setupDriver("firefox");
		}
		
	}

    public void uRLForRibbleBikesWorks() throws Exception {
		driver.get("https://www.ribblecycles.co.uk/");
		Thread.sleep(500);
    }

    public void userHoverOverAccessoriesInNavSection()  throws Exception {
    	Thread.sleep(500);
		WebElement road_nav = driver.findElement(By.xpath("//ul[@id='nav']//a[@title='Accessories']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(road_nav);
		actions.build().perform();
		Thread.sleep(500);
    }

    public void userClicksOnFrameset()  throws Exception {
    	Thread.sleep(500);
		driver.findElement(By.xpath("(//*[contains(text(),'Framesets ')])")).click();
		Thread.sleep(500);
    }

    public void userSelectsPriceLowToHigh()  throws Exception {
    	Thread.sleep(500);
		WebElement sort_select = driver.findElement(By.xpath("//div[@class='category-products']//div[@class='toolbar-top clearfix']//div[@class=\"sorter\"]//div[@class='sort-by']//div[@class='input-box']//select"));
		sort_select.click();
		Select select = new Select(sort_select);
		select.selectByVisibleText("Price: Low to High");
		Thread.sleep(500);
    }

    public void thePriceShouldBeInAcscendingOrder()  throws Exception {
    	boolean result = false;
    	driver.findElement(By.xpath("//a[@href='https://www.ribblecycles.co.uk/components/frames-forks/frames/?dir=asc&order=price_asc&price=250-500']")).click();
		List<WebElement> price_list = driver.findElements(By.xpath("//div[@class='price-box']//span[@class='price notranslate']"));
		for(int i = 0; i < 3; i++) {
			String price1 = price_list.get(i).getText();
			double x = string_to_num(price1);
			String price2 = price_list.get(i+1).getText();
			double y = string_to_num(price2);
			Assert.assertTrue(y>=x);
		}
    }
    
    public static double string_to_num(String number) {
		double num = 0;
		number = number.substring(1);
		if(number.contains(",")) {
			number.replace(",", "");
		}
		num = Float.parseFloat(number);
		return num;
	}
    
    public void userShutsDownTheBrowser()  throws Exception {
    	driver.quit();
    }
}