package com.automation.ObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.GenericLibraries.BaseLibrary;

public class FacebookPage extends BaseLibrary{
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement user_name;
		
	@FindBy(xpath="//input[@name='pass']")
	private WebElement pass_word;
	
	@FindBy(xpath="(//*[@type='submit'])[1]")
	private WebElement loginBttn;
	
	@FindBy(xpath="//textarea[contains(@id,'js_')]")
	private WebElement CreatePostTxtBx;
	
	@FindBy(xpath="//button[contains(@data-testid,'post')]")
	private WebElement PostBttn;
	
	
	
	public void EnterUsername(String username){
		user_name.sendKeys(username);
	}
	
	public void EnterPassword(String password){
		pass_word.sendKeys(password);
	}
	
	public void clickOnSubmit()   {
		loginBttn.click();
	}
	
	public void typeToCreatePost()   {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", CreatePostTxtBx);
		CreatePostTxtBx.sendKeys("Hello World");
	}
	
	public void clickOnPost()   {
		PostBttn.click();
	}
	

}
