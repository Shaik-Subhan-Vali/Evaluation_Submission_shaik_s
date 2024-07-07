package My_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
		public void tc1() throws InterruptedException {
			
		   
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	       WebElement drg = driver.findElement(By.id("draggable"));
	       WebElement drp1 = driver.findElement(By.id("droppable"));
	       WebElement drp2 = driver.findElement(By.id("dropzone2"));
	       
	       Actions A = new Actions(driver);
	       A.clickAndHold(drg).moveToElement(drp1).release().build().perform();
	       A.clickAndHold(drg).moveToElement(drp2).release().build().perform();
           
           
		}
		
		@AfterTest
		public void teardwon() throws InterruptedException
		{
			Thread.sleep(3000);
			driver.quit();
		}



}
