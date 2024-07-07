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

public class drag_n_drop {

		WebDriver driver ;
		
		@BeforeTest
		public void setup() {

			driver = new ChromeDriver();		
			driver.get("https://v1.training-support.net/selenium/drag-drop");
			driver.manage().window().maximize();
		}
		
		@Test
		public void tc1() throws InterruptedException, IOException {
			
		   
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   
			TakesScreenshot ss = (TakesScreenshot) driver;
			File f = ss.getScreenshotAs(OutputType.FILE);
			String path = "C:/Users/subha/OneDrive/Desktop/selenium screenshots/screenshot.png"; 
			FileUtils.copyFile(f, new File(path));

			
	       WebElement drg = driver.findElement(By.id("draggable"));
	       WebElement drp1 = driver.findElement(By.id("droppable"));
	       WebElement drp2 = driver.findElement(By.id("dropzone2"));
	       
	       Actions A = new Actions(driver);
	       A.clickAndHold(drg).moveToElement(drp1).release().build().perform();
	       A.clickAndHold(drg).moveToElement(drp2).release().build().perform();
	       
	       TakesScreenshot ss1 = (TakesScreenshot) driver;
			File f1 = ss1.getScreenshotAs(OutputType.FILE);
			String path1 = "C:/Users/subha/OneDrive/Desktop/selenium screenshots/screenshot1.png"; 
			FileUtils.copyFile(f1, new File(path1));
           
           
		}
		
		@AfterTest
		public void teardwon() throws InterruptedException
		{
			Thread.sleep(3000);
			driver.quit();
		}



}
