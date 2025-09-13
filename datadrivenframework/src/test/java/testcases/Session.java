package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.BaseTest;

public class Session extends BaseTest{

    @Test
    public void Git(ITestContext context){
        app.log("Starting Git Test");
        app.openBrowser("Chrome");
        app.navigate("https://github.com/");
        app.quit();
     
    }

    @Test
    public void Sun(ITestContext context){
        app.log("Starting Sun Test");
        app.openBrowser("Chrome");
        app.navigate("https://thesun.co.uk/");
        app.quit();
        
    }

    @Test
    public void Dailymail(ITestContext context){
        app.log("Starting Dailymail Test");
        app.openBrowser("Chrome");
        app.navigate("https://dailymail.co.uk/");
        app.quit();
    }
    

}