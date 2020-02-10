package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;		

public class Steps {
	
	WebDriver driver;
	
	@Given("^Open the Chrome and launch the application$")				
    public void openChromeandLaunchApplication() throws Throwable							
    {		
		System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/ChromeDriver/chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
    }		

    @When("^Enter the Username and Password$")					
    public void enterUsernamePassword() throws Throwable 							
    {		
       driver.findElement(By.xpath("//input[@name='email']")).sendKeys("8017100150");	
       Thread.sleep(500);
       driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("abcd#123");
       Thread.sleep(500);
    }		

    @Then("^Login to the application with the credentials$")					
    public void loginToSite() throws Throwable 							
    {    		
    	driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();				
    }		

}	


