package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TakesScreenshot;


public class firstTest {


    public static void main(String[] args) {
    	
        // declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.gecko.driver","/home/marko/selenium/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver","/home/marko/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		//maximize browser
		driver.manage().window().maximize();
    	
        String baseUrl = "https://www.google.com/";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        
        // enter keywords and submit
        WebElement searchForm = driver.findElement(By.name("q"));
        searchForm.sendKeys("demoqa.com");
        searchForm.submit();
        
        //click on the first result
        WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3"));
        firstResult.click();
        
        WebElement droppable = driver.findElement(By.linkText("Droppable"));
        droppable.click();
        
        //find drag and drop boxes
        WebElement draggable = driver.findElement(By.id("draggable"));
        droppable = driver.findElement(By.id("droppable"));
 
        //Create an object 'action'
        Actions action = new Actions(driver);
        //Perform Drag&Drop Action
        action.dragAndDrop(draggable, droppable).build().perform();
        
        
        //take a screenshot
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        //File destFile = new File("/home/marko/selenium/screen.png");

        //Copy file at destination
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(scrFile, new File("/home/marko/selenium/screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        //navigate to tooltip page
        WebElement tooltips = driver.findElement(By.linkText("Tooltip"));
        tooltips.click();
        //print text from tooltip
        WebElement tooltip = driver.findElement(By.id("age"));       
        System.out.println(tooltip.getAttribute("title"));
        
        //close Fire fox
        //driver.close();	
       
    }

}
