package com.monkey.testCases;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.monkey.pageObjects.comicListPage;
import com.monkey.pageObjects.homePage;

import com.monkey.utilities.XLUtils1;

public class TC_MON_06 extends BaseClass{
	
	@Test 
	public void dates() {
		driver.get(homeURL);
		logger.info("getting url");
		homePage hp = new homePage(driver);
		logger.info("initialising home page");
		hp.clickList();
		comicListPage cm = new comicListPage(driver);
		logger.info("initialising comic list page");
		cm.calendar();
			
		logger.info("Test passed");
	}

	
	@AfterMethod
    public void tearDown(ITestResult result) throws IOException {
    	if(result.getStatus() == ITestResult.FAILURE) {
    		captureScreen(driver,result.getName());
    	}
	}


	 @DataProvider(name="DateData")
	    public static Object[][] credentials() throws IOException {
	    String path=System.getProperty("user.dir")+"/src/test/java/com/monkey/testData/Dates.xlsx";
	    String date = XLUtils1.getCellData(path,"Date", 1, 1);
	    
	              return new Object[][] { { date }};
	     
	      }
		
}
