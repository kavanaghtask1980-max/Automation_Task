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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
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

       public void homeBuildJobOptions(String homeBuildOption) {

        WebElement homeBuildJobMenu = getElement("homeBuildJobMenu_css");
        List<WebElement> elements = homeBuildJobMenu.findElements(By.className("jenkins-dropdown__item"));
        
        System.out.println("Number of elements:" + elements.size());

        for (int i = 0; i < elements.size(); i++) {
            String menuOptionActual = elements.get(i).getText();
            if (menuOptionActual.contains(homeBuildOption)) {
                
                WebElement e = elements.get(i);
                Actions actions = new Actions(driver);
                
                actions.moveToElement(e);
                actions.clickAndHold(e).release().build().perform();
              
                String pageTitle = driver.getTitle();
                test.log(Status.INFO, "Menu item selected " + homeBuildOption);
                test.log(Status.INFO, "Page title is " +pageTitle);
                break;
            }
        }

    }

    public void homeBuildJobOptions1(String homeBuildOption) {

        WebElement homeBuildJobMenu = getElement("homeBuildJobMenu_css");
        List<WebElement> elements = homeBuildJobMenu.findElements(By.className("jenkins-dropdown__item"));
        
        System.out.println("Number of elements:" + elements.size());

        for (int i = 0; i < elements.size(); i++) {
            WebElement arrowLocation = elements.get(i);
            String menuOptionActual = elements.get(i).getText();
            JavascriptExecutor js = (JavascriptExecutor) driver;

            int z = arrowLocation.getLocation().y;
            System.out.println(z);
            System.out.println(menuOptionActual);
            js.executeScript("javascript:window.scrollBy(0,"+z+")");

       
            if (menuOptionActual.contains(homeBuildOption)) {
                
                WebElement e = elements.get(i);
                Actions actions = new Actions(driver);
                
                actions.moveToElement(e);
               // actions.clickAndHold(e).release().build().perform();
                e.click();
                waitForPageToLoad();
                String pageTitle = driver.getTitle();
                test.log(Status.INFO, "Menu item selected " + homeBuildOption);
                test.log(Status.INFO, "Page title is " +pageTitle);
                
            break;}
            }
        }

    	public void wait(int time){
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		
		while(i!=10){
		String state = (String)js.executeScript("return document.readyState;");
		System.out.println("STATE **********************************" + state);

		if(state.equals("complete")){

        System.out.println("BREAK *******************************" + state);
        
			break;}
		else
			wait(2);

		i++;
		}
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		wait(2);// wait of 2 sec between page status and jquery
		//check for jquery status
		// i=0;
		// while(i!=10){
	
		// 	Boolean result= (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
		// 	System.out.println(result);
		// 	if(result){
        //         System.out.println("result **********************************" + result);
        //         break;}
		// 	else
		// 		 wait(2);
		// 	 i++;
				
		// 	}
		
		}



    public void buildJobRunNumber(String buildNumber) {
    
    WebElement buildHistoryMenu = driver.findElement(By.cssSelector("div#jenkins-build-history"));
       
    List<WebElement> arrowMenu = buildHistoryMenu.findElements(By.xpath("//button[@class='jenkins-card__reveal jenkins-jumplist-link']"));
    List<WebElement> buildNumbers = buildHistoryMenu.findElements(By.cssSelector("div.app-builds-container__item"));
    
    System.out.println("Number of arrowMenu:" + arrowMenu.size());
    System.out.println("Number of buildNumbers:" + buildNumbers.size());
    
    for(int i=0;i<arrowMenu.size();i++){
        System.out.println("Number of arrowMenu: " + i);
        
        WebElement arrowMenuChoice = arrowMenu.get(i);
        String buildNumberChoice = buildNumbers.get(i).getText();
        System.out.println("buildNumber: " + buildNumbers.get(i).getText());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int y = arrowMenuChoice.getLocation().y;
        System.out.println(y);
        System.out.println(buildNumberChoice);
        js.executeScript("javascript:window.scrollBy(0,"+y+")");
        if(buildNumberChoice.contains(buildNumber)){
           Actions actions = new Actions(driver);
           actions.moveToElement(arrowMenuChoice);
           actions.clickAndHold(arrowMenuChoice).release().build().perform();
           waitForPageToLoad();
        }
	}
}
    
    

    public void openBrowser(String browserName) {

        log("Opening the browser " + browserName);

        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\kavan\\Automation_Task\\demo\\chromedriver.exe");
            ChromeOptions chOptions = new ChromeOptions();
            chOptions.addArguments("--remote-allow-origins=*");
            chOptions.addArguments("--disable-notifications");
            chOptions.addArguments("--start-maximized");
            chOptions.addArguments("--ignore-certificate-errors");
            driver = new ChromeDriver(chOptions);

        } else if (browserName.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\kavan\\Automation_Task\\demo\\msedgedriver.exe");
            //  System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
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
        log("Clicking on " + locatorKey);
        getElement(locatorKey).click();
    }

    public void type(String locatorKey, String data) {
        log("Typing into locator => " + locatorKey + " with => " + data);
        getElement(locatorKey).sendKeys(data);
    }

    public void select(String locater, String data) {

    }

    public void getText(String locatorKey) {
        String text = getElement(locatorKey).getText();
        log(text);
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
        for (int rNum = 0; rNum < rows.size(); rNum++) {
            WebElement row = rows.get(rNum);
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (int cNum = 0; cNum < cells.size(); cNum++) {
                WebElement cell = cells.get(cNum);
                System.out.println("Text " + cell.getText());
                if (!cell.getText().trim().equals("")) {
                    if (data.startsWith(cell.getText())) {
                        return (rNum + 1);
                    }
                }
            }
        }

        return -1; // data is not found
    }

    public WebElement getElement(String locatorKey) {
        //  check the presence

        //lkgetLocator(locaterKey);
        if (!isElementPresent(locatorKey)) {
            // report failure
            //System.out.println("Element not present "+locatorKey);
        }
        //  check the visibility
        if (!isElementVisible(locatorKey)) {
            // report failure
            //System.out.println("Element not visible "+locatorKey);
        }

        WebElement e = driver.findElement(getLocator(locatorKey));

        return e;
    }

    public boolean isElementPresent(String locatorKey) {
        log("Checking presence of " + locatorKey);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));

        } catch (Exception e) {
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
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public By getLocator(String locatorKey) {
        By by = null;
        if (locatorKey.endsWith("_id")) {
            by = By.id(prop.getProperty(locatorKey)); 
        }else if (locatorKey.endsWith("_xpath")) {
            by = By.xpath(prop.getProperty(locatorKey)); 
        }else if (locatorKey.endsWith("_css")) {
            by = By.cssSelector(prop.getProperty(locatorKey)); 
        }else if (locatorKey.endsWith("_name")) {
            by = By.name(prop.getProperty(locatorKey));
        }

        return by;

    }

}
