package tests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;

public class third {

	@Test
	public void test() {
		
		System.setProperty("webdriver.chrome.driver","/home/marko/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	    String baseUrl = "https://orangehrm-demo-6x.orangehrmlive.com/";
        driver.get(baseUrl);
        
        //submit the login form
        WebElement loginBtn = driver.findElement(By.name("Submit"));
        loginBtn.click();
        
        //wait for a page to load
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        
        //navigate to recruitment
        WebElement recruitment = driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/span[2]"));
        recruitment.click();
        
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        
        //Hit Burger menu button
        //WebElement menu = driver.findElement(By.xpath("//*[@id=\"content\"]/div[5]/nav/div/a[1]"));
        //WebElement menu = driver.findElement(By.className("mdi-navigation-menu"));
        //menu.click();        
        //can't figure it out how to open this menu so I'm skipping it for now
        
        //redirecting directly to candidates page
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/recruitment/viewCandidates");
        WebElement pagination = driver.findElement(By.className("pagination"));
        String pagText = pagination.getText();
        String numberOfCandidates = pagText.substring(pagText.lastIndexOf(" ")+1);
        System.out.println(numberOfCandidates);

        //Click add new Candidate Button
        WebElement addButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[8]/div/div[1]/a/i"));
        addButton.click();
        
        //find all mandatory fields 
        WebElement firstName = driver.findElement(By.id("addCandidate_firstName"));
        WebElement lastName = driver.findElement(By.id("addCandidate_lastName"));
        WebElement email = driver.findElement(By.id("addCandidate_email"));
        WebElement saveButton = driver.findElement(By.id("saveCandidateButton"));

        //Get today's date - this will be userd for last name
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	Date date = new Date();
        
    	//Populate the form then submit
        firstName.sendKeys("QA Automation");
        lastName.sendKeys(dateFormat.format(date));
        email.sendKeys("test@test.com");
        saveButton.click();
        
        //Use Junit Assert to check if the number of candidates is increased by 1.
        
        
        //new candidate is not instantly added, I'll delete the last added candidate.
        
        WebElement checkbox = driver.findElement(By.xpath("/html/body/div[1]/div/div[8]/div/div[2]/table/tbody/tr[1]/td[1]/input"));
        checkbox.click();
        
        
        //I had no time to finish this one, sorry...
        
	}

}
