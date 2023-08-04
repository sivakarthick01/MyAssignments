package assignment_week6day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class UpdateIncident_SVN extends BaseClass_SVN {
	@BeforeTest
	public void setValues() {
		excelFileName1="SVN_UpdateIncident";
	}
	@Test(dataProvider="sendData")

	public void UpdateTestCase(String Incident_to_update) {
		//String incident="INC0010013";
		
		/*
		 * //Launch Service now application ChromeOptions options=new ChromeOptions();
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
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Incident_to_update,Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		//Update the incidents with Urgency as High and State as In Progress and click Update button
		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select select=new Select(urgency);
		select.selectByValue("1");
		WebElement status = driver.findElement(By.id("incident.state"));
		Select select1=new Select(status);
		select1.selectByVisibleText("In Progress");
		
	    //List<WebElement> statusstr = select1.getOptions();
	   // String string = statusstr.get(1).toString();
	    
		
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		//Click on the incident again and Verify the Incident state 
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		//String in_state = driver.findElement(By.xpath("//span[text()='Incident state']")).getText();
		//System.out.println("Incident status"+in_state);
		
		String updatedstatus = driver.findElement(By.xpath("(//span[@class='sn-widget-list-table-cell']/span)[1]")).getText();
         System.out.println("The updated status is: "+updatedstatus);
         
        
         
	}

}
