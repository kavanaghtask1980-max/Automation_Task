package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.BaseTest;

public class Session extends BaseTest {

    String number = "205";

    @Test
    public void hpBuildJobMenuNav(ITestContext context) {
        app.log("hpBuildJobMenuNav");
        app.click("buildNameMenu_xpath");
        app.hpSelectBuildJobPopMenu("Changes");
        app.click("buildNameMenu_xpath");
        app.hpSelectBuildJobPopMenu("Workspace");
        app.click("buildNameMenu_xpath");
        app.hpSelectBuildJobPopMenu("Configure");
        //    < ---- REVIST ---- >
        // app.click("buildNameMenu_xpath");
        // app.hpSelectBuildJobPopMenu("Delete Project");
        app.click("buildNameMenu_xpath");
        app.hpSelectBuildJobPopMenu("Rename");
         app.click("buildNameMenu_xpath");
        app.hpSelectBuildJobPopMenu("Credentials");
        // < ---- REVIST ---- >
        // app.click("buildNameMenu_xpath");
        // app.hpSelectBuildJobPopMenu("Build Now");
        
        }
    
    

    // @Test
    // public void buildJobConsoleOutput(ITestContext context) {
    //     app.log("jobConsoleOutput");
    //     app.click("buildNameMenu_xpath");
    //     app.hpSelectBuildJobPopMenu("Workspace");
    //     app.buildNumberMenu(number);
    //     app.hpSelectBuildJobPopMenu("Console Output");
    // }

    // @Test
    // public void jobEditBuildInf(ITestContext context) {
    //     app.log("jobEditBuildInf");
    //     //select build job
    //     app.click("buildNameMenu_xpath");
    //     app.hpSelectBuildJobPopMenu("Workspace");
    //     app.buildJobRunNumber(number);
    //     app.hpSelectBuildJobPopMenu("Edit Build Information");
    // }

    // @Test
    // public void jobDeleteBuild(ITestContext context) {
    //     app.log("jobDeleteBuild");
    //     app.click("buildNameMenu_xpath");
    //     app.hpSelectBuildJobPopMenu("Workspace");
    //     app.buildJobRunNumber(number);
    //     app.hpSelectBuildJobPopMenu("Delete build");
    // }

    // @Test
    // public void jobTimings(ITestContext context){
    //   app.log("jobTimings");
    //   app.click("buildNameMenu_xpath");
    //     app.hpSelectBuildJobPopMenu("Workspace");
    //     app.buildJobRunNumber(number);
    //     app.hpSelectBuildJobPopMenu("Timings");
    // }

 }