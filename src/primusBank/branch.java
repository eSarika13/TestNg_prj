package primusBank;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class branch {
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
	
}
