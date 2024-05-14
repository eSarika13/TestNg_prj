package apr05;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	WebDriver dr;
	@Parameters({"Browser"})
	@BeforeTest
	public void setup(String brw) 
	{
		switch (brw) {
		case "Chrome":
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			break;
		case "Firefox":
			dr = new FirefoxDriver();
			break;
		default:
			Reporter.log("Browser value does not matching",true);
			break;
		}
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
