package assignment_week6day1;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {
//For Dynamic Parametirization

	@Test(dataProvider ="sendData")
	public void CreateLeadTestCase(String companynme,String Fname,String Lname,String Phnumber) 
	{
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companynme);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(Fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(Lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(Phnumber);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("Testleaf")) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
		}

	}
		
	@DataProvider
	//companyname,firstname,lastname,phonenumber
	public String[][] sendData() 
	{
		String [][] data=new String[2][4];
		data[0][0]="Infosys";
		data[0][1]="Thaswika";
		data[0][2]="Sri";
		data[0][3]="91";
		data[1][0]="TCS";
		data[1][1]="Sharwin";
		data[1][2]="Shrikar";
		data[1][3]="99";
		return data;
	}
}






