package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.BaseTest;

public class Session extends BaseTest{

    @Test
    public void newLocalBuild(ITestContext context){
        app.log("goToJenkins");
        app.openBrowser("Chrome");
        app.navigate("url");
        app.click("newItem_css");
        app.type("newItemName_css", "localRepo");
        app.getText("newItemType_css");
       
     
       // app.getRowNumWithCellData("buildJobsHome", "testNGSelenium");
        //app.reportFailure("openBrowserSun non critical fault", true);
   
    }

    @Test
    public void newRemoteBuild(ITestContext context){
        app.log("createNewItem");
        app.openBrowser("Chrome");
        app.navigate("url");
        app.click("newItem_css");
        app.type("newItemName_css", "gitHubRepo");
        app.getText("newItemType_css");
      
    }
    

}