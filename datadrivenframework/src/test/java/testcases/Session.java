package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.BaseTest;

public class Session extends BaseTest{

    @Test
    public void openBrowserGit(ITestContext context){
        app.log("openBrowserGit");
        app.openBrowser("Chrome");
        app.navigate("https://github.co.uk/");
        app.reportFailure("openBrowserGit non critical fault", true);
        
       
     }

    @Test
    public void openBrowserSun(ITestContext context){
        app.log("openBrowserSun");
        app.openBrowser("Chrome");
        app.navigate("https://thesun.co.uk/");
        app.reportFailure("openBrowserSun non critical fault", false);
      
     }
    

}