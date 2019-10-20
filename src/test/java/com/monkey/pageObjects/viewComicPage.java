package com.monkey.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.monkey.testCases.BaseClass;

public class viewComicPage extends BaseClass{
	public WebDriver ldriver;

	public viewComicPage(WebDriver rdriver)
    {
        ldriver=rdriver;
    PageFactory.initElements(rdriver, this);
    }

	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[5]/a[1]")
	WebElement next;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/a[1]")
	WebElement previous;
	
	@FindBy(xpath="//time[contains(text(),'04 Dec 2018')]")
	WebElement decComic;
	
	@FindBy(xpath="//time[contains(text(),'19 Jun 2018')]")
	WebElement juneComic;
	
	@FindBy(xpath="//time[contains(text(),'30 May 2017')]")
	WebElement mayComic;
	
	public void clickNext() {
		next.click();
		logger.info("clicked next arrow to view the next comic");
	}
	
	public void clickPrevious() {
		previous.click();
		logger.info("clicked previous arrow to view the previous comic");
	}
	
	public void confirmMay() {
		boolean textPresent = mayComic.isDisplayed();
		String text = "30 MAY 2017";
		AssertTrue(textPresent,text);
		logger.info("confirmed that this is May 30,2018 comic");
	}
	
	public void confirmDec() {
		boolean textPresent = decComic.isDisplayed();
		String text = "04 DEC 2018";
		AssertTrue(textPresent,text);
		logger.info("confirmed that this is December 4,2018 comic");
	}
	
	public void confirmJune()  {
		boolean textPresent = juneComic.isDisplayed();
		String text = "19 JUN 2018";
		AssertTrue(textPresent,text);
		logger.info("confirmed that this is June 19,2018 comic");
		
	}

	private boolean AssertTrue(boolean textPresent, String text) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
