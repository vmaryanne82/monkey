package com.monkey.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.monkey.testCases.BaseClass;

public class storePage extends BaseClass {
	public WebDriver ldriver;

	public storePage(WebDriver rdriver)
    {
        ldriver=rdriver;
    PageFactory.initElements(rdriver, this);
    }
	
	@FindBy(xpath="//li[1]//div[1]//a[1]")
	WebElement feature;
	
	@FindBy(xpath="//li[2]//div[1]//a[1]")
	WebElement developer;
	
	public void feature() {
		feature.click();
		logger.info("clicking on the feature product");
	}
	
	public void developer() {
		developer.click();
		logger.info("clicking on the developer product");
	}
}
