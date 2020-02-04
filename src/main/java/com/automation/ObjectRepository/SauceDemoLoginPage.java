package com.automation.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceDemoLoginPage {
	
	@FindBy(id="user-name")
	private WebElement user_name;
	
	@FindBy(id="password")
	private WebElement pass_word;
	
	@FindBy(xpath="//*[@id='login_credentials']")
	private WebElement firsttusername;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div[2][@class='login_password']")
	private WebElement preDefPwd;
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement LoginBttn;
	
	
	public String FetchFirstUName(){
		String usernames = firsttusername.getText();
		String[] unames = usernames.split("\n+");
	    //System.out.println(unames[1]);
		return unames[1];
	}
	
	public String FetchPassword(){
		String pass = preDefPwd.getText();
		String[] pwd = pass.split("\n+");
	   //System.out.println(pwd[1]);
		return pwd[1];
	}
	
	public void EnterUsername(String username){
		user_name.sendKeys(username);
		}
	
	public void EnterPassword(String password){
		pass_word.sendKeys(password);
	}
	
	public void clickOnSubmit(){
		LoginBttn.click();
	}
}
