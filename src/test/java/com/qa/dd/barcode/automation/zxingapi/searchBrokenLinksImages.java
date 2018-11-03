package com.qa.dd.barcode.automation.zxingapi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class searchBrokenLinksImages {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(140, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(125, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[1]")).sendKeys("naveenk");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[2]")).sendKeys("Test@123");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
		
		driver.switchTo().frame("mainpanel");
		
		List <WebElement> linklist = driver.findElements(By.tagName("a"));
		linklist.addAll(driver.findElements(By.tagName("img")));
		List <WebElement> activelinks = new ArrayList <WebElement>();
		
		System.out.println("Number of all links & images on the Home page of FreeCRM website----->"+linklist.size());
		
		for(int i = 0; i<linklist.size();i++) {
			if(linklist.get(i).getAttribute("href") != null &&(! linklist.get(i).getAttribute("href").contains("javascript"))) {
				
				activelinks.add((linklist.get(i)));
			}
		}
		
		System.out.println("Number of only active links & images on the Home page of FreeCRM website----->"+activelinks.size());
		
		for (int j =0; j < activelinks.size(); j ++) {
			
		         HttpURLConnection connection =	(HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
		         connection.connect();
		         int respCode = connection.getResponseCode();
		         String respMsg = connection.getResponseMessage();
		         
		         System.out.println("URL---"+activelinks.get(j).getAttribute("href")+"   Response Code----"+respCode+"    Response Message----"+respMsg);
		         
		         connection.disconnect();
		}
		
		System.out.println("Test completed successfully");
		
		driver.quit();
		
	}

}
