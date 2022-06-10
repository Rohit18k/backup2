package com.wellness.qa.base;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestBase1 {
	
	public static  WebDriver driver;
 public static Properties pro;


public  static void initialization1() throws Exception {
	File src=new File("./src/main/java/com/wellness/qa/config/config.properties");
	FileInputStream fis=new FileInputStream(src);
	Properties pro=new  Properties();
	pro=new Properties();
	pro.load(fis);
	System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe"); 
	driver=new ChromeDriver();
	  driver.get(pro.getProperty("URL"));
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  String actualTitle=driver.getTitle();
	  String expectedTitle=pro.getProperty("Pagetitle");
	  assertEquals(actualTitle, expectedTitle);
	  System.out.println("Page title is : " + driver.getTitle());

	  WebDriverWait wait = new WebDriverWait(driver, 5);
			 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='loginFormInputs']//button[@class='btn btn-info btn-lg btn-block text-uppercase waves-effect waves-light ladda-button']"))); 
			 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
			 
			 
			 String text1=driver.findElement(By.xpath("//*[@id=\"loginFormInputs\"]/div[1]/div/span")).getText();
				System.out.println(text1);
				String exp1=pro.getProperty("Emailerror1");
				Assert.assertEquals(text1,exp1);
			 
		 
		driver.findElement(By.xpath("//form[@id='loginFormInputs']//input[@placeholder='Email']")).sendKeys("test@gmail@gmail.com");
		
		
		 String text2=driver.findElement(By.xpath("//*[@id=\"loginFormInputs\"]/div[1]/div/span ")).getText();
			System.out.println(text2);
			String exp2=pro.getProperty("Emailerror2");
			Assert.assertEquals(text2,exp2);
		
		
			driver.findElement(By.xpath("//form[@id='loginFormInputs']//input[@placeholder='Email']")).clear();
			
			
			driver.findElement(By.xpath("//form[@id='loginFormInputs']//input[@placeholder='Email']")).sendKeys("test@gmail.com");

		
//			
//			
//			driver.findElement(By.xpath("//form[@id='loginFormInputs']//input[@placeholder='Email']")).sendKeys("admin@webcodegenie.com");
//		
			

			 String text11=driver.findElement(By.xpath("//*[@id=\"loginFormInputs\"]/div[2]/div/span")).getText();
				System.out.println(text11);
				String exp11=pro.getProperty("Passworderror");
				Assert.assertEquals(text11,exp11);
			
			
				driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("wcg@123");
				
				
	//	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("wcg@123");
		
		driver.findElement(By.xpath("//form[@id='loginFormInputs']//button[@class='btn btn-info btn-lg btn-block text-uppercase waves-effect waves-light ladda-button']")).click();

		Thread.sleep(2000);
		
String expected=pro.getProperty("EmailToastmsg");
String actual=driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div[1]/div[1]")).getText();
Assert.assertEquals(actual, expected);

Thread.sleep(2000);

driver.findElement(By.xpath("//form[@id='loginFormInputs']//input[@placeholder='Email']")).clear();

driver.findElement(By.xpath("//form[@id='loginFormInputs']//input[@placeholder='Email']")).sendKeys("admin@webcodegenie.com");

driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();

driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("89563");

driver.findElement(By.xpath("//button/span[contains(text(),'Log In')]")).click();

Thread.sleep(2000);

driver.findElement(By.xpath("//form[@id='loginFormInputs']//input[@placeholder='Email']")).clear();

driver.findElement(By.xpath("//form[@id='loginFormInputs']//input[@placeholder='Email']")).sendKeys("test@gmail.com");

driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();

driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("89563");

driver.findElement(By.xpath("//button/span[contains(text(),'Log In')]")).click();

Thread.sleep(2000);


driver.findElement(By.xpath("//form[@id='loginFormInputs']//input[@placeholder='Email']")).clear();

driver.findElement(By.xpath("//form[@id='loginFormInputs']//input[@placeholder='Email']")).sendKeys("admin@webcodegenie.com");

driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();

driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("wcg@123");

driver.findElement(By.xpath("//button/span[contains(text(),'Log In')]")).click();

//Thread.sleep(2000);
//
//String actual1=driver.getTitle();
//
//String expected1="Dashboard";
//
//Assert.assertEquals(actual1, expected1);
//
//Thread.sleep(2000);
//
//WebElement dropdown=driver.findElement(By.xpath("//span[@class='dropdown-toggle']"));
//Actions actn=new Actions(driver);
//actn.moveToElement(dropdown).click().build().perform();
//
//Thread.sleep(2000);
//
//driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

}


public static void doSelectByVisbleValue(WebElement elt, String value) {
	  Select slt=new Select(elt);
	    slt.selectByValue(value);
	
}



public static void doSelectByIndex(WebElement elt, int in) {
	  Select slt=new Select(elt);
	    slt.selectByIndex(in);
}


public static void doSelectByVisibleText(WebElement elt, String text) {
	  Select slt=new Select(elt);
	    slt.selectByVisibleText(text);
}



public static WebDriver initializeDiver1() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Hema Sahoo\\eclipse-workspace\\Automation\\Driver\\chromedriver.exe"); 
	driver = new ChromeDriver();
	return driver;


}

public static String getScreenshotPath(String TestCaseName, WebDriver driver) throws Exception {
	//WebDriver driver1 = new ChromeDriver();
	 File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
   String despath=System.getProperty("user.dir")+"/Reports/"+TestCaseName+".png";
	   File file= new File(despath); 
	    FileUtils.copyFile(source,file);
	  byte[] imagebytes=  IOUtils.toByteArray(new FileInputStream(despath));
	 return Base64.getEncoder().encodeToString(imagebytes);
	 
	// return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		
		
}


}

