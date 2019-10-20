package com.monkey.testCases;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.monkey.utilities.ReadConfig1;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseClass {
	ReadConfig1 readconfig=new ReadConfig1();
	
	public String homeURL = readconfig.getURL();
    
    
    public static WebDriver driver;
    
    public static Logger logger;
    
    
    
	@Parameters("browser")
    @BeforeClass
    public void setup(String br)
	{
		logger = Logger.getLogger("Monkey"); //Added logger
		PropertyConfigurator.configure("Log4j.properties");//Added logger
		
		if (br.equals("firefox")) {
			// Firefox Browser
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}

		else if (br.equals("chrome")) {
			// opens the browser
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			ChromeOptions capabilities = new ChromeOptions();
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            logger.info("clearing browser cache");
			ChromeOptions opts = new ChromeOptions();
			opts.addArguments("start-maximized");
			logger.info("maximising window");
			opts.addArguments("--incognito");
			logger.info("cognito mode");
			capabilities.setCapability(ChromeOptions.CAPABILITY, opts);

			driver = new ChromeDriver(capabilities);
			driver.manage().deleteAllCookies();
		}
		
		else if (br.equals("ie")) {
			// opens the browser
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
	
		// Global implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	  @AfterClass 
	  public void tearDown() { 
		  driver.quit(); 
		  }
	 
	  public void captureScreen(WebDriver driver, String tname) throws IOException {
		     
		    File directory = new File("Screenshots");
		    directory.mkdir();
		    
		
		  Date d = new Date(); 
		  String filename = d.toString().replace(":", "_").replace(" ", "_");
		  String sname = tname+filename;
		 
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + sname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
}
