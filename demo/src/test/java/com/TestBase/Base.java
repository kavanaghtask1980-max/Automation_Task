package com.TestBase;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

public class Base {

	public WebDriver driver; 
	
	public WebDriver getDriver(String browserName) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\kavan\\OneDrive\\Documents\\GitHub\\Automation_Task\\demo\\chromedriver.exe");
        ChromeOptions chOptions = new ChromeOptions();
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		chOptions.addArguments("--remote-allow-origins=*");
		chOptions.addArguments("--disable-notifications");
		chOptions.addArguments("--start-maximized"); 	
		chOptions.addArguments("--ignore-certificate-errors");
		driver = new ChromeDriver(chOptions);
		
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			
			System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
			EdgeOptions options = new EdgeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			//options.setBinary(new File(""));
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);
			
		}
		// dynamic wait- not pause
	    // global time out- all driver.findelement
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("", "");
		return driver;
	}

		
		


}
