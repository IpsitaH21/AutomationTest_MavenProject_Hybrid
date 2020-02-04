package com.automation.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.automation.GenericLibraries.BaseLibrary;

public class SauceDemoProductsPage extends BaseLibrary{
	
	@FindBy(xpath="//*[@id='inventory_filter_container']/select")
	private WebElement SortingDropDwn ;
	
	@FindBy(xpath="//*[@class='inventory_item_price']")
	private List<WebElement> ItemPrices;
	
	public WebElement Add2Cart;
	
	@FindBy(xpath="//*[@id='shopping_cart_container']/a")
	private WebElement Cart;
	
	public void SortPriceLow2High(){
	Select sel = new Select(SortingDropDwn);
	sel.selectByVisibleText("Price (low to high)");
	}
	
	public String get3rdHighestPrice(){
		int ListSize = ItemPrices.size();
		String[] priceWithCurrency = new String[ListSize];
		int i = 0;
		for(WebElement w:ItemPrices)
		{
		priceWithCurrency[i++] = w.getText();
		}
	Add2Cart=driver.findElement(By.xpath("//*[@id='inventory_container']/div/div["+(ListSize-2)+"]/div[3]/button"));
			
		return priceWithCurrency[ListSize-3];
	}
		
	public void clickOnAdd2Cart(){
		
		Add2Cart.click();
	}
	
	public void clickOnCart() {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", Cart);
		Cart.click();
	}
	}
	

