package com.monkey.testCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.monkey.pageObjects.comicListPage;
import com.monkey.pageObjects.homePage;

public class TC_MON_04 extends BaseClass{
	@Test
	public void history() {
		driver.get(homeURL);
		logger.info("getting url");
		
		homePage hp = new homePage(driver);
		logger.info("initialising home page");
		hp.clickList();
		comicListPage cm = new comicListPage(driver);
		logger.info("initialising comic list page");
		cm.comicHistory();
		logger.info("Test passed");
	}

	
	@AfterMethod
    public void tearDown(ITestResult result) throws IOException {
    	if(result.getStatus() == ITestResult.FAILURE) {
    		captureScreen(driver,result.getName());
    	}
    }

}
