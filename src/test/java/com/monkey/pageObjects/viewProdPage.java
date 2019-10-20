package com.monkey.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.monkey.testCases.BaseClass;

public class viewProdPage extends BaseClass {
	public WebDriver ldriver;

	public viewProdPage(WebDriver rdriver)
    {
        ldriver=rdriver;
    PageFactory.initElements(rdriver, this);
    }
	
	@FindBy(xpath="//button[@name='add']")
	WebElement addCart;
	
	public void clickAddCart() {
		addCart.click();
		logger.info("Adding the product to the cart");
	}

}
