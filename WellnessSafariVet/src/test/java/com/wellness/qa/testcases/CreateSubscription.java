package com.wellness.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.wellness.qa.base.TestBase1;

public class CreateSubscription extends TestBase1{


	public CreateSubscription() {
	super();
	}
	
	@BeforeTest
	public void openBrowser() throws Exception {
		initialization1();
	}

	
	  @Test(priority=1)
	     public void  createSubscription() throws Exception {
	         Thread.sleep(5000);
	         
	         File src=new File("./src/main/java/com/wellness/qa/config/config.properties");
	     	FileInputStream fis=new FileInputStream(src);
	     	Properties pro=new  Properties();
	     	pro=new Properties();
	     	pro.load(fis);
	         
	         Actions actn= new Actions(driver);
	       actn.moveToElement(driver.findElement(By.xpath("//*[@id=\"sidebarnav\"]/li[1]/a[3]/span"))).click().build().perform();
	       
	       Thread.sleep(5000);
			 
   
	       Actions actn1= new Actions(driver);
	       actn1.moveToElement(driver.findElement(By.xpath("//*[@id=\"plan_type\" or @name=\"plan_type\"]"))).click().build().perform();

	       Thread.sleep(2000);
	    Boolean wellneesslist=   driver.findElement(By.xpath("//*[@id=\"plan_type\"]")).isDisplayed();
	    System.out.println(wellneesslist);
	    
	WebElement opt1=driver.findElement(By.id("plan_type"));
	
	WebElement opt2=driver.findElement(By.id("plan_type"));
	
	    	doSelectByVisbleValue(opt1,pro.getProperty("WellnessPlan"));
	    	
	    	
	 
	    Thread.sleep(5000);

	    WebElement element11 =    driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div/div/app-create-subscription/div[1]/div/div/div/div[4]/div[1]/div/div[2]/button"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element11);  
	   
		  WebDriverWait wait = new WebDriverWait(driver, 5);
			 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(element11)); 
			 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

			 WebElement element3 =    driver.findElement(By.xpath("//input[@placeholder='Search user']"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);  
		   
			  Thread.sleep(1000);
			  
			  element3.sendKeys(pro.getProperty("User"));
		

		Thread.sleep(2000);

	Actions act = new Actions(driver);
		act.sendKeys(Keys.DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
	
		
		 
		 
		 WebElement element21 =    driver.findElement(By.xpath("//*[@id=\"pet_selection\"]"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element21);
		 
		 
		 Actions action1 = new Actions(driver);
	        action1.moveToElement(element21).click().build().perform();
		 
	    	WebElement opt3=driver.findElement(By.id("pet_selection"));
	    	
	    	Thread.sleep(4000);
	    	
	    	doSelectByVisibleText(opt3,pro.getProperty("Pet"));
		 

		 
		 Actions action2 = new Actions(driver);
		 
		 action2.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Next')]"))).click().build().perform();
		 
		 
		 Thread.sleep(3000);
		 
			String actual=driver.getTitle();
			System.out.println(actual);
		String expected= "Subscribe Plan";
		Assert.assertEquals(actual, expected);
	
		 Thread.sleep(2000);
		 
	String amount=	 driver.findElement(By.xpath("//h4/span")).getText();
	System.out.println(amount);
	Assert.assertEquals(amount,pro.getProperty("Amount2"));

 Actions action21 = new Actions(driver);
		 
		 action21.moveToElement(driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div/div/app-create-subscription/div[2]/div/div/div/div/div[5]/address/button/span[1]"))).click().build().perform();
		 	
	}
	  

	  @Test(priority=2)
	     public void subscriptionDetails() throws Exception {
	         Thread.sleep(5000);

	         File src=new File("./src/main/java/com/wellness/qa/config/config.properties");
		     	FileInputStream fis=new FileInputStream(src);
		     	Properties pro=new  Properties();
		     	pro=new Properties();
		     	pro.load(fis);
		     	
			 driver.navigate().to("http://wellness.projectdemo.us/admin/dashboard");
			 
			   Thread.sleep(2000);
			 
		WebElement subs= driver.findElement(By.xpath("//span[normalize-space()='Subscription']"));
			   
			 Actions actn=new Actions(driver);
			 actn.moveToElement(subs).click().build().perform();
			 
			   Thread.sleep(2000);
			   
			   String title=driver.getTitle();
			   System.out.println(title);
			   Assert.assertEquals(title,"Subscription");
			   
			   Thread.sleep(2000);
			   
			   driver.findElement(By.xpath("//input[@name=\"search\"] ")).sendKeys(pro.getProperty("Plan"));
			   
			   driver.findElement(By.xpath("//span[@class=\"input-group-text fa fa-search cursor\"]")).click();
			   
		   driver.findElement(By.xpath("//input[@name=\"search\"] ")).clear();
		   
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//input[@name=\"search\"] ")).sendKeys(pro.getProperty("Subscriptionanme"));
		   
		   driver.findElement(By.xpath("//span[@class=\"input-group-text fa fa-search cursor\"]")).click();
			   
		   driver.findElement(By.xpath("//input[@name=\"search\"] ")).clear();
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//input[@name=\"search\"] ")).sendKeys(pro.getProperty("Subscriber"));
			   
		   driver.findElement(By.xpath("//span[@class=\"input-group-text fa fa-search cursor\"]")).click();
			   
		   driver.findElement(By.xpath("//input[@name=\"search\"] ")).clear();
		   
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//input[@name=\"search\"] ")).sendKeys(pro.getProperty("Petname"));
		   
		   
		   driver.findElement(By.xpath("//span[@class=\"input-group-text fa fa-search cursor\"]")).click();
		   
		   driver.findElement(By.xpath("//input[@name=\"search\"] ")).clear();
		   
		   Thread.sleep(1000);
		   
		   
		  WebElement status= driver.findElement(By.xpath("//select[@name=\"filter\"]"));
		  
		  status.click();
		   
		  Select slt=new Select(status);
		    slt.selectByVisibleText(pro.getProperty("Status1"));
		    
		    Thread.sleep(1000);
		    status.click();
			   
			  Select slt1=new Select(status);
			    slt1.selectByVisibleText(pro.getProperty("Status2"));
			    
			    Thread.sleep(1000);
			    status.click();
				   
				  Select slt2=new Select(status);
				    slt2.selectByVisibleText(pro.getProperty("Status3"));

				    
				    Thread.sleep(1000);
				    
				    
		List<WebElement>	lst= driver.findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/thead"));
		for(WebElement el: lst) {
			System.out.println(el.getText());
			}
		
	
		   Thread.sleep(2000);
		
		List<WebElement>	row= driver.findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]"));
		for(WebElement el1: row) {
			System.out.println(el1.getText());
			
			if(el1.getText().equals(pro.getProperty("Plan"))) {
			Boolean	status7=true;
				break;
			}
		}
	
		 Thread.sleep(2000);
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[7]/a[1]")).click();
		
		
		 Thread.sleep(2000);
		 
		 String title1=driver.getTitle();
		   System.out.println(title1);
		   Assert.assertEquals(title1,"Subscription Details");
		   
		   
		   List<WebElement>	PlanLevelDetails=driver.findElements(By.xpath("//*[@id=\"PlanDetails\"]/div[2]/div[1]/div/div[2]/div/div"));
		   
		   for(WebElement el2: PlanLevelDetails) {
				System.out.println(el2.getText());
				
				if(el2.getText().equals(pro.getProperty("Planname1"))) {
					Boolean	status2=true;
						break;
					}	
				
				
			}
		   
		   
List<WebElement>	PetDetails=driver.findElements(By.xpath("//*[@id=\"PlanDetails\"]/div[2]/div[2]/div/div[2]/div/div"));
		   
		   for(WebElement el3: PetDetails) {
				System.out.println(el3.getText());
				
				if(el3.getText().equals(pro.getProperty("Petname1"))) {
					Boolean	status3=true;
						break;
					}	
			
			}
		   
List<WebElement> SubscriberDetails=driver.findElements(By.xpath("//*[@id=\"PlanDetails\"]/div[2]/div[3]/div/div[2]/div/div"));
		   
		   for(WebElement el4: SubscriberDetails) {
				System.out.println(el4.getText());
				if(el4.getText().equals(pro.getProperty("Subscriber1"))) {
					Boolean	status4=true;
						break;
					}	
				
			}
		   		   
		   
List<WebElement> AddonsDetails=driver.findElements(By.xpath("//*[@id=\"PlanDetails\"]/div[2]/div[5]/div/div[2]/div/div "));
		   
		   for(WebElement el5: AddonsDetails) {
				System.out.println(el5.getText());
				if(el5.getText().equals(pro.getProperty("Addon"))) {
					Boolean	status5=true;
						break;
					}	
				
			}
		
	Thread.sleep(2000);
	
	Actions actn1=new Actions(driver);
	actn1.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Payment History')]"))).click().build().perform();
	
	
    
    
List<WebElement>	PaymentHistory= driver.findElements(By.xpath("//*[@id=\"first-table\"]/thead"));
for(WebElement el6: PaymentHistory) {
	System.out.println(el6.getText());
}
	
	
List<WebElement>	rowdata= driver.findElements(By.xpath("//*[@id=\"first-table\"]/tbody/tr[1]"));
for(WebElement el7: rowdata) {
	System.out.println(el7.getText());
	if(el7.getText().equals(pro.getProperty("Amount1"))) {
		Boolean	status6=true;
			break;
		}	
	
}	   
	  }
	  

	  
}