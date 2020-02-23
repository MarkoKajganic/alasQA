package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class secondTest {

	public static void main(String[] args) {
		
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
        //System.out.println(results.getText().split(" ")[1]);
        String resultsStr = resultsEl.getText().split(" ")[1];
        //remove dots from string for conversion
        resultsStr = resultsStr.replaceAll("[.]","");
        
        Integer results = Integer.parseInt(resultsStr);
        Integer controlValue = 777;
        //System.out.println(results);
        
        assertEquals("There is too much cheese on the internet", results, controlValue);
  
        
	}

}
