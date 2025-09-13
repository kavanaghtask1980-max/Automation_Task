package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class Session extends BaseTest{

    @Test
    public void Git(ITestContext context){
        test.log(Status.INFO, "Starting Git Test");
        app.openBrowser("Chrome");
        int x = 0;
        for(x=0;x<10;x++){

        test.log(Status.ERROR, "For Loop " + context);
       
        }
        app.navigate("https://github.com/");
     
    }

    @Test
    public void Sun(ITestContext context){
        test.log(Status.INFO, "Starting Sun Test");
        app.openBrowser("Chrome");
        int x = 0;
        for(x=0;x<10;x++){

        test.log(Status.WARNING, "For Loop " + context);
       
        }
        app.navigate("https://thesun.co.uk/");
        
    }

    @Test
    public void Dailymail(ITestContext context){
        test.log(Status.INFO, "Starting Dailymail Test");
        app.openBrowser("Chrome");
        int x = 0;
        for(x=0;x<20;x++){

        test.log(Status.INFO, "For Loop " + context);
        }
        app.navigate("https://dailymail.co.uk/");
        
    }
    

}