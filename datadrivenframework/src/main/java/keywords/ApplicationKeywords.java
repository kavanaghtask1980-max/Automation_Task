package keywords;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ApplicationKeywords{

    public WebDriver driver;
    public Properties prop;
    public Properties envProp;
    public ExtentTest test;
    public SoftAssert softAssert;

    public ApplicationKeywords() {
		String path  = System.getProperty("user.dir")+"//src//test//resources//env.properties";
		prop = new Properties();
		envProp = new Properties();
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
			String env=prop.getProperty("env")+".properties";
			path  = System.getProperty("user.dir")+"//src//test//resources//"+env;
			fs = new FileInputStream(path);
			envProp.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
        driver.get(url);
    }

    public void quit() {
        String title = driver.getTitle();
        log("Closing browser => " + title);
        driver.quit();
    }

    public void click(String locater) {
		driver.findElement(By.xpath(locater)).click();
    }

    public void type(String locater, String data) {
		driver.findElement(By.id(locater)).sendKeys(data);
    }

    public void select(String locater, String data) {

    }

    public void getText(String locater) {

    }

    public void setReport(ExtentTest test) {
       this.test=test;
       log("In Set Report Function " + test);
    }

    public void log(String msg) {
        test.log(Status.INFO, msg);
    }

    public void reportFailure(String failureMsg) {
        System.out.print(failureMsg);
        softAssert.fail(failureMsg);
    }
    
    public void assertAll(){
        softAssert.assertAll();
    }

    

}