package com.automation.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.GenericLibraries.BaseLibrary;
import com.automation.ObjectRepository.*;

public class testCases extends BaseLibrary{

	@Test (priority = 0)
	public void loginToFacebookAndPost() throws IOException, Throwable
	{
		System.out.println("Login To Facebook Site");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		
		  driver.get("https://www.facebook.com/");
		
		 FacebookPage login=PageFactory.initElements(driver, FacebookPage.class);
		                        login.EnterUsername(pobj.getProperty("FACEBOOK_UID").trim());
		       		           Thread.sleep(2000);
				           
		        		        login.EnterPassword(pobj.getProperty("FACEBOOK_PWD").trim());
		                       Thread.sleep(2000);
		           
		                        login.clickOnSubmit();
		                        Thread.sleep(3000);  
		           		                                              
		                        login.typeToCreatePost();
		                         Thread.sleep(3000);
		           		
		                        login.clickOnPost();
		                         Thread.sleep(3000);  
		                        
		
		           	
     }
	
	@Test (priority = 1)
	public void loginToSwagLabsAndAdd2Cart() throws IOException, Throwable
	{
		System.out.println("Login To Swag Labs Site");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		pobj = fileutil.getpropertiesfileobject();	
		 driver.get(pobj.getProperty("DEMOSITE_URL"));
		 
		 SauceDemoLoginPage loginPg=PageFactory.initElements(driver, SauceDemoLoginPage.class);
		 
		 String PredefU1=loginPg.FetchFirstUName();
		 String passwd=loginPg.FetchPassword();
		 
		   loginPg.EnterUsername(PredefU1.trim());
	       		           Thread.sleep(1000);
			           
	       loginPg.EnterPassword(passwd.trim());
	                       Thread.sleep(1000); 
		 
	                    loginPg.clickOnSubmit();
	                       Thread.sleep(3000); 
	                       
	     SauceDemoProductsPage ProdPg=PageFactory.initElements(driver, SauceDemoProductsPage.class);
	            ProdPg.SortPriceLow2High();
	            Thread.sleep(3000); 
	            
	            js = (JavascriptExecutor)driver;
	            js.executeScript("window.scrollBy(0,300)");
	            
	            System.out.println("The 3rd Highest Price is : "+ ProdPg.get3rdHighestPrice());
	            Thread.sleep(3000); 
	            
	            ProdPg.clickOnAdd2Cart();
	            Thread.sleep(2000);
	            
	            ProdPg.clickOnCart();
	            Thread.sleep(2000);
	            
	     SauceDemoCartPage CartPg=PageFactory.initElements(driver, SauceDemoCartPage.class); 
	            CartPg.click2Checkout();
	            Thread.sleep(2000);
	            
	            CartPg.enterFName(pobj.getProperty("FNAME2CHECKOUT")); 
	            Thread.sleep(500);
	            
	            CartPg.enterLName(pobj.getProperty("LNAME2CHECKOUT")); 
	            Thread.sleep(500);
	            
	            CartPg.enterPostCode(pobj.getProperty("POSTCODE"));
	            Thread.sleep(1000);
	            
	            CartPg.click2Continue();  
	            Thread.sleep(2000);
	            
	            CartPg.click2Finish();  
	            Thread.sleep(2000);
	            
	            String msg = CartPg.assertMsg();
	            Assert.assertEquals(msg,"THANK YOU FOR YOUR ORDER","The actual message is different from expected one");
	            Thread.sleep(2000);
	            
	}
	
		
}
