package keywords;

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

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ApplicationKeywords{

    public WebDriver driver;
    public Properties prop;
    public Properties envProp;
    public ExtentTest test;

    public void openBrowser(String browserName) {

        test.log(Status.INFO, "Opening the browser " + browserName);

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
        test.log(Status.INFO, "Navigating to " + url);
        driver.get(url);
        test.log(Status.INFO, "Closing browser => " + url);
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
      
        System.out.print("Set Report Function " + test);
        System.out.print("Set Report Function " + test); 
        this.test=test;
       
    }

    

}