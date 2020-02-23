package tests;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;

public class treci {

	@Test
	public void test() {
		
		System.setProperty("webdriver.chrome.driver","/home/marko/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	    String baseUrl = "https://orangehrm-demo-6x.orangehrmlive.com/";
        driver.get(baseUrl);
		
	}

}
