package com.qa.dd.barcode.automation.zxingapi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpclClassLocatorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(140, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(125, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
//		driver.findElement(new ByAll(By.name("firstname123"), By.id("u_0_n_123"), By.xpath("//*[@id=\"u_0_n\"]"))).sendKeys("BNP Paribas");
		
//		driver.findElement(new ByIdOrName("firstname")); 
		
        driver.findElement(new ByChained(By.id("u_0_m")
        		, By.className("uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput"), By.name("firstname"))).sendKeys("Proximus");
        
        System.out.println("Element located successfully");
		driver.quit();
		
	}

}
