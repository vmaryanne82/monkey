package com.monkey.testCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.monkey.pageObjects.checkoutPage;
import com.monkey.pageObjects.comicListPage;
import com.monkey.pageObjects.homePage;
import com.monkey.pageObjects.productsPage;
import com.monkey.pageObjects.storePage;
import com.monkey.pageObjects.viewProdPage;


public class TC_MON_07 extends BaseClass{
	@Test
	public void dates() throws InterruptedException {
		driver.get(homeURL);
		logger.info("getting url");
		
		homePage hp = new homePage(driver);
		logger.info("initialising home page");
		hp.clickCart();
		storePage st = new storePage(driver);
		st.feature();
		viewProdPage pp = new viewProdPage(driver);
		pp.clickAddCart();
		checkoutPage ck = new checkoutPage(driver);
		ck.clickShop();;
	    productsPage prod = new productsPage(driver);
	    prod.clickDev();
	    pp.clickAddCart();
	    ck.removeDev();
	    ck.confirmFeature();
	    ck.checkout();
	    Thread.sleep(5000);
		
		logger.info("Test passed");
	}

	
	@AfterMethod
    public void tearDown(ITestResult result) throws IOException {
    	if(result.getStatus() == ITestResult.FAILURE) {
    		captureScreen(driver,result.getName());
    	}
	}

}
