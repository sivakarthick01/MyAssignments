package assignment_week6day2;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Marathon.ReadExcel_Questions;
import Marathon.readExcel_Oppurtunity;
import io.github.sukgu.Shadow;

public class BaseClass_SVN {

	public RemoteWebDriver driver;
	public String excelFileName1;
	@Parameters({"browser","URL","Username","Password"})
	@BeforeMethod
	public void precondition(String browser,String url,String uName,String pWord) {
		// TODO Auto-generated method stub
	//Launch Service now application	
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
		/*
		 * ChromeOptions options=new ChromeOptions();
		 * options.addArguments("--disable-notifications");
		 * options.addArguments("--disable-gpu"); ChromeDriver driver=new
		 * ChromeDriver(options);
		 */
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//Login with valid credentials
		driver.findElement(By.id("user_name")).sendKeys(uName);
		driver.findElement(By.id("user_password")).sendKeys(pWord);
		driver.findElement(By.id("sysverb_login")).click();

		//click all(ShadowDom)
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();

		//click incidents(ShadowDom)
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//span[text()='Incidents']").click();

		//inside frame so we need to switch
		WebElement newincpg = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(newincpg);
		System.out.println("");
}
	
	@DataProvider(indices=1)
	public String[][] sendData() throws IOException
	{
		
		return readExcel_SalesForce.readExcelData(excelFileName1);
	}
	@AfterMethod
	public void postcondition() {
		driver.close();

	}
	@AfterSuite
	public void stopreport() {
		System.out.println("Stop the Report");

	}
}