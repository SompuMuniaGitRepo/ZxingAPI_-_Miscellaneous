package com.qa.dd.barcode.automation.zxingapi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerJSExecutor {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(140, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(125, TimeUnit.SECONDS);

        driver.get("https://www.spicejet.com/");
        
        String depart_date = "09-12-2018";
        
        WebElement date_field = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_view_date1\"]"));

        setDateByJSExecutor(driver, date_field, depart_date );
        Thread.sleep(3000);
		
	}
	
	    public static void setDateByJSExecutor(WebDriver driver, WebElement date_field, String depart_date) {
	    	
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].setAttribute('value','"+depart_date+"');",date_field);
	    }

}
