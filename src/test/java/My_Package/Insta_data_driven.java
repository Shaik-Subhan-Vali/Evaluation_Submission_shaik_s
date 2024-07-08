package My_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Insta_data_driven {
WebDriver driver ;
	
	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();		
		driver.get("https://www.instagram.com/accounts/login/?hl=en");
		driver.manage().window().maximize();
	}
	
	@Test
	public void tc1() throws InterruptedException, IOException {
		
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	   
	    
       WebElement uname = driver.findElement(By.cssSelector("[aria-label=\"Phone number, username, or email\"]"));
       WebElement pwd = driver.findElement(By.cssSelector("[aria-label=\"Password\"]"));
       WebElement login = driver.findElement(By.cssSelector("[class=\" _acan _acap _acas _aj1- _ap30\"]"));
      
       File  excel = new File("C:/Users/subha/OneDrive/Desktop/DDusingExcel.xlsx");
   	
    	FileInputStream fis = new FileInputStream(excel);   //to read excel file
   	
   	try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
		XSSFSheet sht = wb.getSheet("Sheet1"); // to read from the sheet
		
		int rowcount=  sht.getLastRowNum();  //fetch the data till the last row of the sheet
		
		for(int i = 0;i <= rowcount ;i++)
		{
			String c1 = sht.getRow(i).getCell(0).getStringCellValue();   // for going inside column A
			String c2 = sht.getRow(i).getCell(1).getStringCellValue();    // for going inside column B
			
			System.out.println(c1);
			System.out.println(c2);
			
			uname.sendKeys(c1);     
			pwd.sendKeys(c2);    
			login.click();
			
		}
	}
	}
	
	@AfterTest
	public void teardwon() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
