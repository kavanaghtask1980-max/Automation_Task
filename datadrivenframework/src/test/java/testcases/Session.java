package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.BaseTest;

public class Session extends BaseTest {

    String number = "195";

    @Test
    public void jobChanges(ITestContext context) {
        app.log("jobChanges");
        app.click("buildNameMenu_xpath");
        app.homeBuildJobOptions("Workspace");
        app.buildJobRunNumber(number);
        app.homeBuildJobOptions("Changes");
    }

    @Test
    public void jobConsoleOutput(ITestContext context) {
        app.log("jobConsoleOutput");
        app.click("buildNameMenu_xpath");
        app.homeBuildJobOptions("Workspace");
        app.buildJobRunNumber(number);
        app.homeBuildJobOptions("Console Output");
    }

    @Test
    public void jobEditBuildInf(ITestContext context) {
        app.log("jobEditBuildInf");
        app.click("buildNameMenu_xpath");
        app.homeBuildJobOptions("Workspace");
        app.buildJobRunNumber(number);
        app.homeBuildJobOptions("Edit Build Information");
    }

    @Test
    public void jobDeleteBuild(ITestContext context) {
        app.log("jobDeleteBuild");
        app.click("buildNameMenu_xpath");
        app.homeBuildJobOptions("Workspace");
        app.buildJobRunNumber(number);
        app.homeBuildJobOptions("Delete build");
    }

    @Test
    public void jobTimings(ITestContext context){
      app.log("jobTimings");
      app.click("buildNameMenu_xpath");
        app.homeBuildJobOptions("Workspace");
        app.buildJobRunNumber(number);
        app.homeBuildJobOptions("Timings");
    }

}