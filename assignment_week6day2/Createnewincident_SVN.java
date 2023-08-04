package assignment_week6day2;

import java.time.Duration;




import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;


public class Createnewincident_SVN extends BaseClass_SVN{
	@BeforeTest
	public void setValues() {
		excelFileName1="SVN_CreateIncident";
	}
	@Test(dataProvider="sendData")
	
	public  void CreatenewTestCase(String description){
		
	//Launch Service now application	
	/*
	 * ChromeOptions options=new ChromeOptions();
	 * options.addArguments("--disable-notifications");
	 * options.addArguments("--disable-gpu"); ChromeDriver driver=new
	 * ChromeDriver(options); driver.manage().window().maximize();
	 * driver.get("https://dev156587.service-now.com/");
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 * 
	 * //Login with valid credentials
	 * driver.findElement(By.id("user_name")).sendKeys("admin");
	 * driver.findElement(By.id("user_password")).sendKeys("Miracle@2023");
	 * driver.findElement(By.id("sysverb_login")).click();
	 * 
	 * //click all Shadow shadow=new Shadow(driver); shadow.setImplicitWait(20);
	 * shadow.findElementByXPath("//div[text()='All']").click();
	 * 
	 * //click incidents shadow.setImplicitWait(10);
	 * shadow.findElementByXPath("//span[text()='Incidents']").click();
	 * 
	 * //Click on New option and fill the mandatory fields and click Submit.
	 * 
	 * //shadow.findElementByXPath("//button[text()='New']").click(); WebElement
	 * newincpg = shadow.findElementByXPath("//iframe[@id='gsft_main']");
	 * driver.switchTo().frame(newincpg);
	 */
	driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
	String text = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
	System.out.println("Incident"+text);
	driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(description);
	driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text,Keys.ENTER);
	String text1 = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
	//Verify the newly created incident ( copy the incident number and paste it in search field and enter then verify the instance number created or not)
	if(text.equalsIgnoreCase(text1))
	{
		System.out.println("Incident created successfully");
	}
	else
	{
		System.out.println("Incident not created");
	}
	
	}
	

}
