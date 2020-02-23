package tests;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;

public class second {

	@Test
	public void test() {
		
		System.setProperty("webdriver.chrome.driver","/home/marko/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	    String baseUrl = "https://www.google.com/";
        driver.get(baseUrl);
        
        WebElement searchForm = driver.findElement(By.name("q"));
        searchForm.sendKeys("cheese");
        searchForm.submit();
        	
        //find total results and extract number from string
        WebElement resultsEl = driver.findElement(By.id("mBMHK"));
        String resultsStr = resultsEl.getText().split(" ")[1];
        //remove dots from string for conversion
        resultsStr = resultsStr.replaceAll("[.]","");
        
        Integer results = Integer.parseInt(resultsStr);
        Integer controlValue = 777;
        
        //close browser
        driver.close();	
        
        assertEquals("There is too much cheese on the internet", results, controlValue);
        
	}
}
