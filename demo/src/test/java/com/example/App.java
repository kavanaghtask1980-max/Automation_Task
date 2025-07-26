package com.example;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.TestBase.Base;


public class App extends Base {

    
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
		
		
		int p=1;
		while(p!=6) {
			
			List<WebElement> names =driver.findElements(By.cssSelector("a.card-title-link.bold"));
			for(int i=0;i<names.size();i++) {
				System.out.println(names.get(i).getText());
			}
			System.out.println("--------------------------------------------------------------------------------");
			driver.findElement(By.xpath("//a[text()='"+(p+1)+"']")).click();
			p++;
		}
		
	}

}