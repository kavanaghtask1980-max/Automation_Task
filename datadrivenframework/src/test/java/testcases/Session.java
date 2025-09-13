package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class Session extends BaseTest{

    @Test
    public void doLogin(ITestContext context){
        test.log(Status.INFO, "dfgsdfg");
   
        System.out.println("doLogin");
        app.openBrowser("Chrome");
        app.navigate("https://github.com/");
        test.log(Status.INFO, "Finished doLogin Test");
    }

    @Test
    public void doLogin1(ITestContext context){
        test.log(Status.INFO, "Starting doLogin1 Test");
        System.out.println("doLogin1");
        app.openBrowser("Chrome");
        app.navigate("https://thesun.co.uk/");
        test.log(Status.INFO, "Finished doLogin1 Test");
    }
    

}