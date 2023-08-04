package Marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Salesforce_Questions_Chrome extends parentsalesforce
{
	@BeforeTest
	public void setValues() {
		excelFileName1="SalesForce_Question";
	}
	@Test(dataProvider="sendData")
	public void questionsalesforce(String questions,String details) throws InterruptedException
	{
		/*
		 * ChromeOptions options=new ChromeOptions();
		 * options.addArguments("--disable-notifications");
		 * options.addArguments("--disable-gpu"); ChromeDriver driver=new
		 * ChromeDriver(options); driver.manage().window().maximize();
		 * driver.get("https://login.salesforce.com/");
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 * driver.findElement(By.id("username")).sendKeys("siva@csg.sandbox");
		 * driver.findElement(By.id("password")).sendKeys("Miracle@2023");
		 * driver.findElement(By.id("Login")).click();
		 * driver.findElement(By.className("slds-icon-waffle")).click();
		 * driver.findElement(By.xpath("//input[@class='slds-input']")).click();
		 */
		//6. Click Content Link
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		//7. Click on Chatter Tab
		WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();", chatter);
		//Verify Chatter title on the page
		Thread.sleep(1000);
		String title=driver.getTitle();
		System.out.println("Title is"+title);
		if(title.equalsIgnoreCase("Chatter Home | Salesforce"))
		{
			System.out.println("Title of page is"+title);
		}
		else
		{
			System.out.println("Verified title is not chatter and actual tile is"+title);
		}
		
		//9. Click Question tab
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		//10. Type Question with data (coming from excel)
		driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(questions);
		//11. Type Details with data (coming from excel)
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow']")).sendKeys(details);
		//12. Click Ask
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand cuf-publisherShareButton qe-questionPostDesktop MEDIUM']")).click();
		//13. Confirm the question appears
		//String question = driver.findElement(By.xpath("//span[text()='wf']")).getText();
		//String details = driver.findElement(By.xpath("//span[text()='sad']")).getText();
		//System.out.println("The Question asked is "+question);
		//System.out.println("Details info is"+details);
		String text = driver.findElement(By.xpath("(//article[@class='cuf-feedElement cuf-feedItem'])[1]")).getText();
		String Question="To Understand Salesforde";
		String Details="Detailed info Required";
		if (text.contains("Actions for this Feed Item")) 
		if(text.contains("To Understand Salesforde"))
		System.out.println("Feed question is:"+Question+"and details is:"+Details);
		else
		{
			System.out.println("No feed items");
		}	
		//System.out.println("question and detail"+text);
		//14. Close the browser
		//driver.close();
	
	}

}
