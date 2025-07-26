package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.TestBase.Base;

public class App extends Base {

    @Test
    public void testApp2() {
        getDriver("Chrome");
		    driver.get("http://dailymail.co.uk");
    				driver.findElement(By.xpath("//button[@class=\"button_cVc76 primary_vX6Hs full-width_Orq_e consent_BHP9G\"]")).click();
			String text = driver.findElement(By.xpath("//div[@class=\"links\"]/a[1]")).getText();
		System.out.println(text);
		driver.quit();
	
    }

    @Test
    public void testApp() {
        getDriver("Edge");
        driver.get("http://google.com");
        //driver.findElement(By.name("q")).sendKeys("hello");
        //driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.quit();
    }

    @Test
    public void testApp1() {
        getDriver("chrome");
        driver.get("https://www.dice.com/jobs");

        int p = 1;
        while (p != 6) {

            List<WebElement> names = driver.findElements(By.cssSelector("a.card-title-link.bold"));
            for (int i = 0; i < names.size(); i++) {
                System.out.println(names.get(i).getText());
            }
            System.out.println("--------------------------------------------------------------------------------");
            driver.findElement(By.xpath("//a[text()='" + (p + 1) + "']")).click();
            p++;
        }

    }

}
