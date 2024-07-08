package My_Package;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Uploading_File {
	WebDriver driver ;
	
	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();		
		driver.get("https://demo.automationtesting.in/FileUpload.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void tc1() throws InterruptedException, IOException {
		
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	   File f = new File("C:/Users/subha/OneDrive/Desktop/New folder (2)/1.png");
	    
       WebElement upload = driver.findElement(By.id("input-4"));
       upload.sendKeys(f.getAbsolutePath());   
       
       driver.findElement(By.xpath("//span[@class=\"hidden-xs\" and text()=\"Upload\"]")).click();
    
	}
	
	@AfterTest
	public void teardwon() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
