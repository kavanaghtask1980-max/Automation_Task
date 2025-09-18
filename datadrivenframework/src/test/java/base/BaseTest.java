package base;

import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import keywords.ApplicationKeywords;
import reports.ExtentManager;

public class BaseTest {

    public ApplicationKeywords app;
    public ExtentReports rep;
    public ExtentTest test;

    @BeforeTest(alwaysRun = true)
    public void BeforeTest(ITestContext context) {

    app = new ApplicationKeywords();
    context.setAttribute("app", app);
    
    rep = ExtentManager.getReports();
    test = rep.createTest(context.getCurrentXmlTest().getName());
    
    app.setReport(test);

    context.setAttribute("report", rep);
    context.setAttribute("test", test);
    app.openBrowser("Chrome");
    app.navigate("url"); 
    
    }

    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod(ITestContext context){
    test.log(Status.INFO, "In BeforeMethod" );
    test = (ExtentTest)context.getAttribute("test");

    String criticalFailure = (String)context.getAttribute("criticalFailure");

    if(criticalFailure != null && criticalFailure.equals("Y")){
      test.log(Status.SKIP, "Critical Failure In Previous Tests" );
        throw new SkipException("Critical Failure In Previous Tests");
    }
		rep = (ExtentReports)context.getAttribute("report");
    }

    @AfterTest
    public void quit(){
      ////app.quit();
      test.log(Status.INFO, "In AfterTest" );
      if(rep != null)rep.flush();
      
    }
}      