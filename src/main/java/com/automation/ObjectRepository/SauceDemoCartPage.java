package com.automation.ObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.GenericLibraries.BaseLibrary;

public class SauceDemoCartPage extends BaseLibrary{
	
	@FindBy(xpath="//*[@id='cart_contents_container']/div/div[2]/a[2][text()='CHECKOUT']")
	private WebElement CheckoutBttn;
	
	@FindBy(xpath="//input[@id='first-name']")
	private WebElement FirstNTxtbx;
	
	@FindBy(xpath="//input[@id='last-name']")
	private WebElement LastNTxtbx;
	
	@FindBy(xpath="//input[@id='postal-code']")
	private WebElement ZipCodeFld;
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement ContinueBttn;
	
	@FindBy(xpath="//*[@id='checkout_summary_container']/div/div[2]/div[8]/a[2]")
	private WebElement FinishBttn;
	
	@FindBy(xpath="//*[@id='checkout_complete_container']/h2")
	private WebElement ThankUMsg;
	
public void click2Checkout(){
		CheckoutBttn.click();
	}

public void enterFName(String fname){
	FirstNTxtbx.sendKeys(fname);
}

public void enterLName(String lname){
	LastNTxtbx.sendKeys(lname);
}

public void enterPostCode(String zip){
	ZipCodeFld.sendKeys(zip);
}

public void click2Continue(){
	ContinueBttn.click();
}

public void click2Finish(){
	js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();", FinishBttn);
	FinishBttn.click();
}

public String assertMsg(){
	String msg = ThankUMsg.getText();
	return msg;
}

}