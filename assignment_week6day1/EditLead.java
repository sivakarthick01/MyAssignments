package assignment_week6day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends BaseClass{
@Test(dataProvider = "sendData")
	public void EditLeadTestCase(String phnumber,String companynme) throws InterruptedException 
{
	
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phnumber);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companynme);
		driver.findElement(By.name("submitButton")).click();
	
}
//phonenumber,companyname

	@DataProvider
public String[][] sendData() {
	String[][] data=new String[2][2];
	data[0][0]="99";
	data[0][1]="Cogniznat";
	data[1][0]="90";
	data[1][1]="Accenture";
	return data;

}
}






