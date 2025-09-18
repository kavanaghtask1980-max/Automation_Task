package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.BaseTest;

public class Session extends BaseTest {

    @Test
    public void jobConsoleOutput(ITestContext context) {
        app.log("jobConsoleOutput");
        app.click("buildNameMenu_xpath");
        app.homeBuildJobOptions("Workspace");
        app.buildJobRunNumber("191");
        app.homeBuildJobOptions("Console Output");
    }

    @Test
    public void jobChanges(ITestContext context) {
        app.log("jobChanges");
        app.click("buildNameMenu_xpath");
        app.homeBuildJobOptions("Workspace");
        app.buildJobRunNumber("191");
        app.homeBuildJobOptions("Changes");
    }

    @Test
    public void jobEditBuildInf(ITestContext context) {
        app.log("buildJobWorkspace");
        app.click("buildNameMenu_xpath");
        app.homeBuildJobOptions("Workspace");
        app.buildJobRunNumber("191");
        app.homeBuildJobOptions("Edit Build Information");
    }

    // @Test
    // public void buildJobConfigure(ITestContext context) {
    //     app.log("buildJobConfigure");
    //     app.click("buildNameMenu_xpath");
    //     app.homeBuildJobOptions("Configure");
    // }

    // @Test
    // public void buildJobDeleteProject(ITestContext context){
    //   app.log("Delete Project");
    //   app.click("buildNameMenu_xpath");
    //   app.homeBuildJobOptions("Delete Project");
    // }



}