package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.BaseTest;

public class Session extends BaseTest {

    @Test
    public void buildJobChanges(ITestContext context) {
        app.log("buildJobChanges");
        app.click("buildNameMenu_xpath");
        app.homeBuildJobOptions("Changes");
    }

    @Test
    public void buildJobWorkspace(ITestContext context) {
        app.log("buildJobWorkspace");
        app.click("buildNameMenu_xpath");
        app.homeBuildJobOptions("Workspace");
    }

    @Test
    public void buildJobBuildNow(ITestContext context) {
        app.log("buildJobBuildNow");
        app.click("buildNameMenu_xpath");
        app.homeBuildJobOptions("Build Now");
    }

    @Test
    public void buildJobConfigure(ITestContext context) {
        app.log("buildJobConfigure");
        app.click("buildNameMenu_xpath");
        app.homeBuildJobOptions("Configure");
    }

    @Test
    public void buildJobDeleteProject(ITestContext context){
      app.log("Delete Project");
      app.click("buildNameMenu_xpath");
      app.homeBuildJobOptions("Delete Project");
    }



}