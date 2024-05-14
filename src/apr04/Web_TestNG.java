package apr04;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import net.bytebuddy.asm.Advice.Return;

public class Web_TestNG {
	WebDriver dr;
	@BeforeTest
	public void setup() 
	{
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		}
	
	@DataProvider
	public Object Datasupply() 
	{
		Object login [][]= {{"Admin","Qedge123!@#"},{"Admin","Admin1"},{"Admin","Qedge123!@#"},{"Sarika","Admin"},{"Admin","Admin"}};
		return login;	
	}
	
	@Test(dataProvider = "Datasupply")
	public void verification(String user, String pass) throws Throwable
	{
		dr.get("http://orangehrm.qedgetech.com/");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		dr.findElement(By.name("txtUsername")).sendKeys(user);
		dr.findElement(By.name("txtPassword")).sendKeys(pass);
		dr.findElement(By.name("Submit")).click();
		String exp = "dashboard";
		String act = dr.getCurrentUrl();
		if(act.contains(exp)) {
			Reporter.log("login pass",true);
		}else {
			Reporter.log("login fail",true);
		}
	}
	
	@AfterTest
	public void teardown() {
		dr.quit();
	}
}
