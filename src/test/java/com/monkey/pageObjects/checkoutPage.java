package com.monkey.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.monkey.testCases.BaseClass;

public class checkoutPage extends BaseClass {
	public WebDriver ldriver;

	public checkoutPage(WebDriver rdriver)
    {
        ldriver=rdriver;
    PageFactory.initElements(rdriver, this);
    }
	
	@FindBy(xpath="//span[@class='site-nav__label'][contains(text(),'Products')]")
	WebElement products;
	
	@FindBy(partialLinkText="Continue shoppi")
	WebElement shopping;
	
	@FindBy(xpath="//a[contains(text(),'Developer')]")
	WebElement devProduct;
	
	@FindBy(xpath="//a[contains(text(),'Feature')]")
	WebElement feaProd;
	
	@FindBy(xpath="//tr[@class='cart__row border-bottom line1 border-top']//a[@class='text-link text-link--accent'][contains(text(),'Remove')]")
	WebElement devRemove;
	
	@FindBy(xpath="//input[@id='updates_large_11337235595300:1de031961c91e61cb2983bc26a87c986']")
	WebElement input;
	
	@FindBy(xpath="//input[@name='checkout']")
	WebElement check;
	
	public void clickProdTab() {
		products.click();
		logger.info("clicked on the products tab");
	}
	
	public void clickShop() {
		shopping.click();
		logger.info("clicked on the continue shopping link");
	}
	
	public void removeDev() {
		boolean textPresent = devProduct.isDisplayed();
		String text = "Developer";
		AssertTrue(textPresent,text);
		logger.info("confirmed that this is Developer product");
		devRemove.click();
		logger.info("removed the developer product");
		
	}

	private void AssertTrue(boolean textPresent, String text) {
		// TODO Auto-generated method stub
		
	}
	
	public void confirmFeature() {
		boolean textPresent = feaProd.isDisplayed();
		String text = "Feature";
		AssertTrue(textPresent,text);
		logger.info("confirmed that this is Feature product");
	}
	
	public void checkout() {
		check.click();
		logger.info("Clicking the checkout button");
		
	}

}
