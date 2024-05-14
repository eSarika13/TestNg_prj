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

public class AdminHomepage {
	WebDriver dr;
	@BeforeTest
	public void setup() throws Throwable {
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.navigate().to("http://primusbank.qedgetech.com/");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		dr.findElement(By.name("txtuId")).sendKeys("Admin");
		dr.findElement(By.name("txtPword")).sendKeys("Admin");
		dr.findElement(By.name("login")).click();
		Reporter.log("login Success Url",true);
		Thread.sleep(1000);
	}
	@Test
	public void branch() {
		dr.findElement(By.xpath("//a[@href='admin_banker_master.aspx']//img")).click();
		Reporter.log("System displays Branchs details",true);
	}
	@Test(priority = 3)
	public void role() throws Throwable 
	{
		dr.findElement(By.xpath("(//img)[6]")).click();
		Reporter.log("System displays Role details ",true);
		Thread.sleep(2000);
	}
	@Test(priority = 4)
	public void users() throws Throwable 
	{
		dr.findElement(By.xpath("(//img)[7]")).click();
		Reporter.log("System displays Users details ",true);
		Thread.sleep(2000);
	}
	@Test(priority = 1)
	public void employee() throws Throwable 
	{
		dr.findElement(By.xpath("(//img)[8]")).click();
		Reporter.log("System displays Employee details ",true);
		Thread.sleep(2000);
	}
	@Test(priority = 0,enabled = false)
	public void changepass() throws Throwable 
	{
		dr.findElement(By.xpath("(//img)[3]")).click();
		Reporter.log("System displays Change password page ",true);
		Thread.sleep(2000);
	}
	@Test(priority = 5)
	public void logout() throws Throwable
	{
		dr.findElement(By.xpath("(//img)[4]")).click();
		Reporter.log("System should logout adminhmepage nd displays primus bank home page. ",true);
		Thread.sleep(2000);
	}
	@AfterTest
	public void teardown() {
		dr.quit();
	}
}
