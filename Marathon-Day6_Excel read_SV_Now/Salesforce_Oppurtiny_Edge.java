package Marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Salesforce_Oppurtiny_Edge extends parentsalesforce {
@BeforeTest
public void setValues() {
	excelFileName1="SalesForce_Oppurtunity";

}
@Test(dataProvider="sendData")
	public void oppurtunitySalesforce(String oppname,String e_amount)
	{
		/*
		 * EdgeOptions options=new EdgeOptions();
		 * options.addArguments("--disable-notifications");
		 * options.addArguments("--disable-gpu"); options.addArguments("--guest");
		 * EdgeDriver driver=new EdgeDriver(options);
		 * driver.manage().window().maximize(); //1. Login to
		 * https://login.salesforce.com driver.get("https://login.salesforce.com/");
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 * driver.findElement(By.id("username")).sendKeys("siva@csg.sandbox");
		 * driver.findElement(By.id("password")).sendKeys("Miracle@2023");
		 * driver.findElement(By.id("Login")).click(); //2. Click on toggle menu button
		 * from the left corner
		 * driver.findElement(By.className("slds-icon-waffle")).click(); //3. Click view
		 * All and click Sales from App Launcher
		 * driver.findElement(By.xpath("//input[@class='slds-input']")).click();
		 */		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales");
		driver.findElement(By.xpath("(//p[@class='slds-truncate'])[3]")).click();
		//4. Click View All Key Deals in Key Deals 
		WebElement scrolldown = driver.findElement(By.xpath("//span[text()='Key Deals - Recent Opportunities']"));
		Actions action=new Actions(driver);
		action.scrollToElement(scrolldown).perform();
		driver.findElement(By.xpath("(//span[@part='boundary'])[21]")).click();
		driver.findElement(By.xpath("//a[@title='All Opportunities']")).click();
		WebElement viewAllKeyDeals = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
		//Wait.until(ExpectedConditions.visibilityOf(viewAllKeyDeals));
        driver.executeScript("arguments[0].click();", viewAllKeyDeals);
		//6. Click on New
        driver.findElement(By.xpath("//div[text()='New']")).click();
		//7. Give Opportunity Name  (From Excel)
        driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys(oppname);
        
			//8. Select Type as New Customer and Lead Source as Partner Referral
        WebElement combodropdown = driver.findElement(By.xpath("(//label[@class='slds-form-element__label'])[4]"));
		Actions action3=new Actions(driver);
		action3.scrollToElement(combodropdown).perform();
		driver.executeScript("arguments[0].click();", combodropdown);
        driver.findElement(By.xpath("(//span[@class='slds-truncate'])[39]")).click();
        //Lead source as Partner Referral
        WebElement partnerelement = driver.findElement(By.xpath("//label[text()='Lead Source']"));
        driver.executeScript("arguments[0].click();", partnerelement);
        driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
        //9. Give Amount as 75000 (from Excel)
        WebElement amount = driver.findElement(By.xpath("//input[@name='Amount']"));
        Actions actionamount=new Actions(driver);
        actionamount.scrollToElement(amount).perform();
        driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(e_amount);
        //10. Select Close Date as tomorrow
        driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
        driver.findElement(By.xpath("(//span[@class='slds-day'])[5]")).click();
		//11. Select Stage as Needs Analysis
        WebElement Needanalysiselement = driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']"));
			driver.executeScript("arguments[0].click();", Needanalysiselement);
			driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
        //12. Click in Primary Campaign  Source and Select first option
			WebElement Campaignscrolldown = driver.findElement(By.xpath("//label[text()='Primary Campaign Source']"));
			Actions scrollaction=new Actions(driver);
			scrollaction.scrollToElement(Campaignscrolldown).perform();
			driver.executeScript("arguments[0].click();", Campaignscrolldown);
			driver.findElement(By.xpath("//span[text()='selenium']")).click();
		  //13. Click Save and Verify the opportunity is created"
			driver.findElement(By.xpath("//button[text()='Save']")).click();
			String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
			
			System.out.println("Text"+text);
			if(text.contains("Oppurtunity 1"))
				System.out.println("Verified"+text+"is Created successfully");
			//14. Close the browser
			

	}

}
