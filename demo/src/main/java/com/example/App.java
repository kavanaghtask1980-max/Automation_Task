package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {
        System.setProperty("webdriver.edge.driver","C:\\Users\\kavan\\OneDrive\\Documents\\GitHub\\Automation_Task\\demo\\msedgedriver.exe");
       
        WebDriverM

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver cd = new EdgeDriver(options);
        cd.get("http://www.google.com");
        
    }
}
