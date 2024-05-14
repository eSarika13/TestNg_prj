package apr03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecndTestNGclass {
	WebDriver dr;
	@BeforeMethod
	public void setup() {
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://primusbank.qedgetech.com/Admin_Emp_details.aspx");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		dr.findElement(By.name("txtuId")).sendKeys("Admin");
		dr.findElement(By.name("txtPword")).sendKeys("Admin");
		dr.findElement(By.name("login")).click();
		Reporter.log("Running beforemethod", true);
	}
	@Test(priority=3)
	public void branch() {
		dr.findElement(By.xpath("(//img)[5]")).click();
		Reporter.log("Executing Branch",true);
	}
	@Test(priority=2)
	public void role() {
		dr.findElement(By.xpath("(//img)[6]")).click();
		Reporter.log("Executing role",true);
		
	}
	@Test(priority=1)
	public void user() {
		dr.findElement(By.xpath("(//img)[7]")).click();
		Reporter.log("Executing user",true);
	}
	@Test(priority=0,enabled = false)
	public void empolyee() {
		dr.findElement(By.xpath("(//img)[8]")).click();
		Reporter.log("Executing employee",true);
	}
	@AfterMethod
	public void tearDown() {
		dr.quit();
		Reporter.log("Running aftermethod", true);
	}

}
