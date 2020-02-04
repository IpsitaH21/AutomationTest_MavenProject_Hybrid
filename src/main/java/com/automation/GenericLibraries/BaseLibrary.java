/*Author: Ipsita Hazra
 * To run this project with Hybrid framework,(1)Right click on 'testng.xml'-->Select 'Run As'--> choose 'TestNG Suite' 
 * OR (2)Right click on 'pom.xml'-->Select 'Run As'-->choose 'Maven test'*/
package com.automation.GenericLibraries;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.ObjectRepository.*;

public class BaseLibrary {
	
	public static WebDriver driver;
	public UtilityLibrary fileutil=new UtilityLibrary();
	public Properties pobj; 
	public JavascriptExecutor js;
	
	@BeforeMethod  
	public void openBrowser() throws IOException
	{
		System.out.println("========Launching Browser========");
		pobj = fileutil.getpropertiesfileobject();	
		String browsername=pobj.getProperty("BROWSER");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			ChromeOptions Goptions = new ChromeOptions();
			Goptions.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/ChromeDriver/chromedriver.exe");
			driver=new ChromeDriver(Goptions);
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			FirefoxOptions opt = new FirefoxOptions();
			opt.addPreference("dom.webnotifications.enabled", false);
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/FirefoxDriver/geckodriver.exe");
			 driver=new FirefoxDriver(opt);
 		}
		else throw new RuntimeException("Please enter a valid browser name in ConfigFile.");
		
	  driver.manage().window().maximize();
	  
	  }
	 
	
	
	@AfterMethod 
	 public void closeBrowser()
		{
			System.out.println("========Closing browser=========");
               driver.quit();
		
	 }	
}
 


