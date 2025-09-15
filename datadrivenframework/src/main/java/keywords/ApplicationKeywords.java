package keywords;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;

public class ApplicationKeywords {

    public WebDriver driver;
    public Properties prop;
    public Properties envProp;
    public ExtentTest test;
    public SoftAssert softAssert;

    public ApplicationKeywords() {

        String path = System.getProperty("user.dir") + "//src//test//resources//env.properties";
        prop = new Properties();
        envProp = new Properties();
        try {
            FileInputStream fs = new FileInputStream(path);
            prop.load(fs);
            String env = prop.getProperty("env") + ".properties";
            path = System.getProperty("user.dir") + "//src//test//resources//" + env;
            fs = new FileInputStream(path);
            envProp.load(fs);
        } catch (Exception e) {

            e.printStackTrace();
        }

        softAssert = new SoftAssert();

    }

    public void openBrowser(String browserName) {

        log("Opening the browser " + browserName);

        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\kavan\\OneDrive\\Documents\\GitHub\\Automation_Task\\demo\\chromedriver.exe");
            ChromeOptions chOptions = new ChromeOptions();
            chOptions.addArguments("--remote-allow-origins=*");
            chOptions.addArguments("--disable-notifications");
            chOptions.addArguments("--start-maximized");
            chOptions.addArguments("--ignore-certificate-errors");
            driver = new ChromeDriver(chOptions);

        } else if (browserName.equalsIgnoreCase("Edge")) {

            System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
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
    }

    public void navigate(String url) {
        log("Navigating to " + url);
        driver.get(envProp.getProperty(url));
        String title = driver.getTitle();
        log("Page Title => " + title);
    }

    public void quit() {
        String title = driver.getTitle();
        log("Closing browser => " + title);
        driver.quit();
    }

    	public void click(String locatorKey) {
		log("Clicking on "+locatorKey);
		getElement(locatorKey).click();
	}

    public void type(String locater, String data) {
        driver.findElement(By.id(locater)).sendKeys(data);
    }

    public void select(String locater, String data) {

    }

    public void getText(String locater) {

    }

    public void setReport(ExtentTest test) {
        this.test = test;
    }

    public void log(String msg) {
        test.log(Status.INFO, msg);
    }

    public void reportFailure(String failureMsg, boolean stopOnFailure) {
        takeScreenShot();
        test.log(Status.FAIL, failureMsg);
        softAssert.fail(failureMsg);
        if (stopOnFailure) {
            Reporter.getCurrentTestResult().getTestContext().setAttribute("criticalFailure", "Y");
            assertAll();
        }
    }

    public void assertAll() {
        softAssert.assertAll();
    }

    public void takeScreenShot() {
        // fileName of the screenshot
        Date d = new Date();
        String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
        // take screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // get the dynamic folder name
            FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath + "//" + screenshotFile));
            //put screenshot file in reports
            test.log(Status.INFO, "Screenshot-> " + test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath + "//" + screenshotFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    	public int getRowNumWithCellData(String tableLocator, String data) {
		
		WebElement table = getElement(tableLocator);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int rNum=0;rNum<rows.size();rNum++) {
			WebElement row = rows.get(rNum);
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(int cNum=0;cNum<cells.size();cNum++) {
				WebElement cell = cells.get(cNum);
				System.out.println("Text "+ cell.getText());
				if(!cell.getText().trim().equals(""))
					if(data.startsWith(cell.getText()))
						return(rNum+1);
			}
		}
		
		return -1; // data is not found
	}

    public WebElement getElement(String locatorKey) {
		//  check the presence
       
       //lkgetLocator(locaterKey);
		if(!isElementPresent(locatorKey)) {
			// report failure
			//System.out.println("Element not present "+locatorKey);
		}
		//  check the visibility
		if(!isElementVisible(locatorKey)) {
			// report failure
			//System.out.println("Element not visible "+locatorKey);
		}
			
		WebElement e = driver.findElement(getLocator(locatorKey));
		
		return e;
	}

    	public boolean isElementPresent(String locatorKey) {
		log("Checking presence of "+locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	// true - visible
	// false - not visible
	public boolean isElementVisible(String locatorKey) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public By getLocator(String locatorKey) {
		By by=null;
		System.out.println(locatorKey);
		if(locatorKey.endsWith("_id"))
			by = By.id(prop.getProperty(locatorKey));
		else if(locatorKey.endsWith("_xpath"))
			by = By.xpath(prop.getProperty(locatorKey));
		else if(locatorKey.endsWith("_css"))
			by = By.cssSelector(prop.getProperty(locatorKey));
		else if(locatorKey.endsWith("_name"))
			by = By.name(prop.getProperty(locatorKey));
		
		return by;
		
		
	}

	

}
