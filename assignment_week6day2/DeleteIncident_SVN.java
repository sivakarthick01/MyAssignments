package assignment_week6day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class DeleteIncident_SVN extends BaseClass_SVN {
	
	@BeforeTest
	public void setValues() {
		excelFileName1="SVN_UpdateIncident";
	}
	@Test(dataProvider="sendData")

	public  void UpdateTestCase(String Incident_to_delete)
	{ /*
		 * String incident="INC0010016"; //Launch Service now application ChromeOptions
		 * options=new ChromeOptions(); options.addArguments("--disable-notifications");
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
		 * //click all(ShadowDom) Shadow shadow=new Shadow(driver);
		 * shadow.setImplicitWait(20);
		 * shadow.findElementByXPath("//div[text()='All']").click();
		 * 
		 * //click incidents(ShadowDom) shadow.setImplicitWait(10);
		 * shadow.findElementByXPath("//span[text()='Incidents']").click();
		 * 
		 * //inside frame so we need to switch WebElement newincpg =
		 * shadow.findElementByXPath("//iframe[@id='gsft_main']");
		 * driver.switchTo().frame(newincpg);
		 */

	//Search for the existing incident in the search box and click on the incident
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Incident_to_delete,Keys.ENTER);
	driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	
	//Delete the incident
	driver.findElement(By.xpath("//button[@id='sysverb_delete']")).click();
	driver.findElement(By.xpath("(//button[text()='Delete'])[3]")).click();
	String text = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
	System.out.println(text);

	}

}
