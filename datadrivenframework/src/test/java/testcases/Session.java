package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.BaseTest;

public class Session extends BaseTest{

    @Test
    public void newLocalBuild(ITestContext context){
        app.log("newLocalBuild");
        app.click("newItem_css");
        app.type("newItemName_css", "localRepo");
        app.getText("newItemType_css");
       
     
       // app.getRowNumWithCellData("buildJobsHome", "testNGSelenium");
        //app.reportFailure("openBrowserSun non critical fault", true);
   
    }

    @Test
    public void createNewItem(ITestContext context){
        app.log("createNewItem");
        //startBuildJob(String buildName)
        app.click("buildNamePlay_xpath");
        app.click("buildNameMenu_xpath");
        
        
    }
    

}