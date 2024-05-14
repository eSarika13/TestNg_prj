package apr03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class FrstTestNGclass {
	
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
	@Test(priority=1)
	public void pbanking() 
	{
		dr.findElement(By.xpath("(//img)[4]")).click();
		Reporter.log("Execting pbanking Text", true);
		
	}
	@Test(priority=2)
	public void cbanking()
	{
		dr.findElement(By.xpath("(//img)[5]")).click();
		Reporter.log("Execting cbanking Text", true);
	}
	@Test(priority=0)
	public void ibanking() 
	{
		dr.findElement(By.xpath("(//img)[6]")).click();
		Reporter.log("Execting ibanking Text", true);
	}
	@Test(priority=3)
	public void about()
	{
		dr.findElement(By.xpath("(//img)[7]")).click();
		Reporter.log("Execting about Text",true);
	}
	@AfterTest
	public void teardown()
	{
		dr.quit();
		Reporter.log("Running in aftertest ", true);
		
	}

}