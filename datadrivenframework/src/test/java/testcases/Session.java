package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.BaseTest;

public class Session extends BaseTest{

    @Test
    public void goToJenkins(ITestContext context){
        app.log("goToJenkins");
        app.openBrowser("Chrome");
        app.navigate("url");
        app.click("newItem_css");
        //app.type()
        //app.getRowNumWithCellData("buildJobsHome", "testNGSelenium");
        //app.reportFailure("openBrowserSun non critical fault", true);
   
    }

    @Test
    public void createNewItem(ITestContext context){
        app.log("createNewItem");
        
        
        
       
    }
    

}