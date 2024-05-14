package primusBank;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrimusHomepage {
	WebDriver dr;
	@BeforeTest
	public void setup()
	{
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://primusbank.qedgetech.com/");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Reporter.log("Running in befortest ", true);
	}
	@Test(priority = 0)
	public void pbanking() 
	{
		dr.findElement(By.xpath("(//img)[4]")).click();
		Reporter.log("System displays information about Personal Banking", true);
		
	}
	@Test(priority = 1)
	public void cbanking()
	{
		dr.findElement(By.xpath("(//img)[5]")).click();
		Reporter.log("System displays information about Corporate Banking", true);
	}
	@Test(priority = 1)
	public void ibanking() 
	{
		dr.findElement(By.xpath("(//img)[6]")).click();
		Reporter.log("System displays information about Internet Banking", true);
	}
	@Test(priority = 2)
	public void aboutus()
	{
		dr.findElement(By.xpath("(//img)[7]")).click();
		Reporter.log("System displays information aboutus PrimusBank ",true);
	}
	@Test(priority = 3)
	public void CustomerServices()
	{
		dr.findElement(By.partialLinkText("Customer Servi")).click();
		Reporter.log("System displays Customer Service information of Primus Bank",true);
	}
	@Test(priority = 4)
	public void FAQ()
	{
		dr.findElement(By.xpath("//a[@href='faqs.html']")).click();
		Reporter.log("System displays FAQ's for internet banking FAQ's",true);
	}
	@Test(priority = 5)
	public void privacy()
	{
		dr.findElement(By.partialLinkText("Priva")).click();
		Reporter.log("System display privacy commitment of primus Bank",true);
	}
	@Test(priority = 6)
	public void termsndconditions()
	{
		dr.findElement(By.linkText("Terms and Conditions")).click();
		Reporter.log("System display terms nd condition of Internet Banking",true);
	}
	@Test(priority = 7)
	public void disclaimer()
	{
		dr.findElement(By.partialLinkText("Disclaim")).click();
		Reporter.log("System displays notice and copyright of this site",true);
	}
	@Test(priority = 8)
	public void sitemap()
	{
		dr.findElement(By.linkText("Site Map")).click();
		Reporter.log("System displays Site map of primus bank",true);
	}
	
	@AfterTest
	public void teardown()
	{
		dr.quit();
		Reporter.log("Running in aftertest ", true);
		
	}

}
