package com.qa.dd.barcode.automation.zxingapi;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BarcodeAutomate {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(140, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		driver.get("https://barcode.tec-it.com/en");
		
		WebElement barcodelem = driver.findElement(By.xpath("//*[@id=\"infoTarget\"]/div[1]/img"));
		String barcodeURL = barcodelem.getAttribute("src");
		System.out.println(barcodeURL);
		
		URL url = new URL(barcodeURL);
		BufferedImage bufferedimage = ImageIO.read(url);
		
		LuminanceSource luminancesource = new BufferedImageLuminanceSource(bufferedimage);
		BinaryBitmap binarybitmap = new BinaryBitmap(new HybridBinarizer(luminancesource));
		
		
		Result result = new MultiFormatReader().decode(binarybitmap);
		System.out.println(result.getText());
		
		
		
		
		
		
	}

}
