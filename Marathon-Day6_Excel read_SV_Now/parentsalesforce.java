package Marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week6.day2.ReadExcel;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

public class parentsalesforce 
{
	public RemoteWebDriver driver;
	public String excelFileName1;
	@Parameters({"browser","URL","Username","Password"})
	@BeforeMethod
	public void preCondition(String browser,String url,String uName,String pWord) 
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
		}
		else if(browser.equalsIgnoreCase("edge")) 
		{
			driver=new EdgeDriver();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-gpu");
			options.addArguments("--guest");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).click();
	}
	@DataProvider
	public String[][] sendData() throws IOException
	{
		return ReadExcel_Questions.readExcelData(excelFileName1);
	}
	
	@AfterMethod
	public void postcondition()
	{
		driver.close();
	}
	@AfterSuite
		public void stopReport() {
			System.out.println("Stop the report");

	}
}
