package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestBase.Base;

public class App extends Base {

    String username = "kavanaghtom1980";
    String paddypower = "http://paddypower.co.uk";
    String password = "";

    @Test
    public void loginPaddyPower() {
        getDriver("Edge");
        driver.get(paddypower);
        String title = driver.getTitle();

        int g = 10;

        for (int i = 0; i < g; i++) {
            System.out.println(title);
            System.out.println(i);
        }
        Assert.assertEquals(title, "Online Betting & Odds | Bet with Paddy Power Sports");

        if (title == "Online Betting & Odds |  with Paddy Power Sports") {
            System.out.print("nText Match");
        } else {
            System.out.print("nText does Match");
        }

        System.out.print(title);
        //Assert.assertTrue(driver.getTitle().contains("Paddy"), "Title doesn't contain abc : Test Failed");
        //	Assert.assertTrue(driver.getTitle().contains("Jimmy"));

        driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"abc-button__content\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"username\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        driver.quit();

    }

    @Test
    public void testApp() {
        getDriver("Edge");
        driver.get("http://cnn.com");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total links " + allLinks.size());
        //By.xpath("//a")

        WebElement fifthLink = allLinks.get(5);// webelement - 6th link
        System.out.println(fifthLink.getText());
        System.out.println(fifthLink.getAttribute("href"));
        //fifthLink.click();
        System.out.println(fifthLink.getLocation().x);
        System.out.println(fifthLink.getLocation().y);

        for (int i = 0; i < allLinks.size(); i++) {
            WebElement link = allLinks.get(i);
            System.out.println(link.getText() + " --- " + link.isDisplayed());
        }

        //a[@class='_2mylT6']
        // a._2mylT6
    }

    @Test
    public void javaScript() {
        getDriver("Edge");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location='" + paddypower + "'");
        js.executeScript("document.getElementByID('username').click");

        driver.quit();

    }

    @Test
    public void printNames() {
        driver.get("https://www.flipkart.com/mens-clothing/tshirts/pr?sid=2oq,s9b,j9y&otracker=nmenu_sub_Men_0_T-Shirts");

        //List<WebElement> allTshirtNames = driver.findElements(By.xpath("//a[@class='_2mylT6']"));
        List<WebElement> allTshirtNames = driver.findElements(By.cssSelector("a._2mylT6"));
        System.out.println("total t shirts - " + allTshirtNames.size());

        for (WebElement e : allTshirtNames) {
            System.out.println(e.getText());
        }

        List<WebElement> allTshirtPrices = driver.findElements(By.xpath("//div[@class='_1vC4OE']"));
        System.out.println("Total Prices " + allTshirtPrices.size());
        for (WebElement e : allTshirtPrices) {
            System.out.println(e.getText());
        }
        System.out.println("------------------");
        for (int i = 0; i < allTshirtNames.size(); i++) {
            System.out.println(allTshirtNames.get(i).getText() + " --- " + allTshirtPrices.get(i).getText());
        }
    }

}
