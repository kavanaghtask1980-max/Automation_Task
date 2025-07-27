package com.example;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.TestBase.Base;

public class App extends Base {

	String username = "kavanaghtom1980";
	String paddypower = "http://paddypower.co.uk";

    @Test
    public void loginPaddyPower() {
        getDriver("Edge");
		    driver.get(paddypower);
    				driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]")).click();
					driver.findElement(By.xpath("//div[@class=\"abc-button__content\"]")).click();
					driver.findElement(By.xpath("//input[@name=\"username\"]")).click();
					driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(username);
					driver.findElement(By.xpath("//input[@name=\"password\"]")).click();
					driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
					driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
		 }

    @Test
    public void testApp() {
        getDriver("Edge");
           driver.get("http://dailymail.co.uk");
    				driver.findElement(By.xpath("//button[@class=\"button_cVc76 primary_vX6Hs full-width_Orq_e consent_BHP9G\"]")).click();
					String headline = driver.findElement(By.xpath("//div[@class=\"article article-tri-headline\"]/h2/a")).getText();
					driver.findElement(By.xpath("//div[@class=\"article article-tri-headline\"]/h2/a")).click();

					
		System.out.println(headline);
		driver.quit();
        
    }

   

    }