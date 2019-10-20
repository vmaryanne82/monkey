package com.monkey.pageObjects;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.monkey.testCases.BaseClass;

import junit.framework.Assert;

public class comicListPage extends BaseClass{
	public WebDriver ldriver;

	public comicListPage(WebDriver rdriver)
    {
        ldriver=rdriver;
    PageFactory.initElements(rdriver, this);
    }
	
	@FindBy(xpath="//a[contains(text(),'S3cur1ty')]")
	WebElement random;
	
	@FindBy(xpath="//div[@class='page']//div[1]/div[1]/div[1]/a[1]")
	WebElement newComic;
	
	@FindBy(xpath="//time[contains(text(),'December 4, 2018')]")
	WebElement decComic;
	
	@FindBy(xpath="//time[contains(text(),'June 19, 2018')]")
	WebElement juneComic;
	
	@FindBy(xpath="//time[contains(text(),'May 30, 2017')]")
	WebElement mayComic;
	
	@FindBy(linkText="Happy Flow")
	WebElement happyFlow;
	
	@FindBy(linkText="Trial And")
	WebElement trialAnd;
	
	@FindBy(linkText="Angular vs. React")
	WebElement angular;
	
	public void clickRandom() {
		random.click();
		logger.info("view random comic");
	}
	
	public void clickNew() {
		newComic.click();
		logger.info("clicking new comic");
	}
	
	public void comicHistory() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the web page till end.		
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        logger.info("Scrolls to the bottom of the page to view the history of comics");
      //This will scroll the page till the element is found	top of the page	
        js.executeScript("arguments[0].scrollIntoView();", newComic);
        logger.info("Scrolls to the top of the page after viewing the history of comics");
	}
	
	public void clickHappy() {
		happyFlow.click();
		logger.info("Clicking on June 19,2018 comic");
	}
	
	public void clickTrial() {
		trialAnd.click();
		logger.info("Clicking on December 4,2018 comic");
	}
	
	public void clickAngular() {
		angular.click();
		logger.info("Clicking on May 30,2017 comic");
		
	}
	
	public void calendar() {
		
		Date date3 = Calendar.getInstance().getTime();
        SimpleDateFormat df2 = new SimpleDateFormat("MMMM dd,yyyy");
		String newdate2 = df2.format(date3);
		System.out.println(newdate2);
		
		List<WebElement> strDate =driver.findElements(By.xpath("//*[contains(text(),'"+newdate2+"')]"));
		if(strDate.isEmpty()) {
			System.out.println("Element using link text is NOT found");
			logger.info("Comic doesnt exist for this date");
		}else {
			System.out.println("Element using text is found");
			logger.info("Comic exists for this date");
		}
		
	}
	
	
	
}
