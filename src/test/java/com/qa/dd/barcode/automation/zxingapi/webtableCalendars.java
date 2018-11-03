package com.qa.dd.barcode.automation.zxingapi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtableCalendars {

	public static void main(String[] args)  {
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
		
		String birthdate = "09/December/1985";
		Select select_month = new Select(driver.findElement(By.xpath("//*[@id=\"crmcalendar\"]/table/tbody/tr[1]/td/select[1]")));
		Select select_year = new Select(driver.findElement(By.name("slctYear")));
		
		String birthdateArr[] = birthdate.split("/");
		
		birthdateArr[0] = "09";
		birthdateArr[1] = "December";
		birthdateArr[2] = "1985" ;
		
		
		try {
			select_month.selectByVisibleText(birthdateArr[1]);
			select_year.selectByVisibleText(birthdateArr[2]);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]
		
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[1]
		
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]
		
		String before_xpath = "//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
		String after_xpath = "]/td[";
		String cal_date = null;
		
		boolean flag = false;
		
		         for(int row = 2; row <=7; row++) {
			                  for (int col =1; col <=7; col++)    {
			                	  
			                	      String total_xpath = before_xpath+row+after_xpath+col+"]";
			                	      
			                	      try {
			                	                  cal_date = driver.findElement(By.xpath(total_xpath)).getText();
			                	      }catch(NoSuchElementException e)       {
			                	    	  System.out.println("Wrong date has been selected for the month please enter a valid date");
			                	    	  flag = true;
			                	    	  break;
			                	      }
			                	      if(birthdateArr[0].contentEquals(cal_date)) {
			                	    	  
			                	    	  driver.findElement(By.xpath(total_xpath)).click();
			                	    	  flag = true;
			                	    	  break;
			                	      }
				
				                   if(flag)
				                	   break;
			                  }
	              }
		
		
		
		
		
	    }

}
