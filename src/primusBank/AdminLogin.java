package primusBank;

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

public class AdminLogin {
	WebDriver dr;
	@Parameters({"Browser"})
	@BeforeTest
	public void setup(String brws)
	{
		switch (brws) {
		case "Chrome": 
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			break;
		case "Firefox":
			dr = new FirefoxDriver();
			break;
		default:
		Reporter.log("Browser value does not match",true);
	}
	}
	@DataProvider
	public Object supplydata()
	{
		Object login[][] = {{"Admin","Admin"},{"Test","Admin"},{"Admin","admin2"},{"Admin","Admin"}};
		return login;
	}
	@Test(dataProvider = "supplydata")
	public void verification(String user, String pass) throws Throwable
	{
		dr.get("http://primusbank.qedgetech.com/");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		dr.findElement(By.name("txtuId")).sendKeys(user);
		dr.findElement(By.name("txtPword")).sendKeys(pass);
		dr.findElement(By.name("login")).click();
		
		String exp = "adminflow.aspx";
		
		
		try {
			dr.switchTo().alert().accept();
			
		} 
		catch (Exception e) {
			
		}
		String act = dr.getCurrentUrl();
		if(act.contains(exp)) {
			Reporter.log("login pass",true);
		}
		else {
			Reporter.log("login fail",true);
		}
	}
	
	@AfterTest
	public void teardown() {
		dr.quit();
	}
	}
	
