package com.monkey.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.monkey.testCases.BaseClass;

public class homePage extends BaseClass {
	
	public WebDriver ldriver;

	public homePage(WebDriver rdriver)
    {
        ldriver=rdriver;
    PageFactory.initElements(rdriver, this);
    }
	
	@FindBy(xpath="//a[@id='list']")
	WebElement comicList;
	@FindBy(xpath="//a[contains(text(),'SHOP')]")
	WebElement cart;
	
	public void clickList() {
		comicList.click();
		logger.info("Comic List has been clicked");
	}
	
	public void clickCart() {
		cart.click();
		logger.info("Shopping cart has been clicked");
	}
}
