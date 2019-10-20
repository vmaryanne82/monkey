package com.monkey.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.monkey.testCases.BaseClass;

public class productsPage extends BaseClass {
		public WebDriver ldriver;

		public productsPage(WebDriver rdriver)
	    {
	        ldriver=rdriver;
	    PageFactory.initElements(rdriver, this);
	    }
		
		@FindBy(xpath="//li[1]//div[1]//a[1]")
		WebElement devProd;
		
		public void clickDev() {
			devProd.click();
			logger.info("Clicking on the developer product");
		}
		
		
}
