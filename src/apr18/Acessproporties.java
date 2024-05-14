package apr18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Acessproporties {
	WebDriver dr;
	Properties pp;
	@Test
	public void test() throws Throwable{
		pp = new Properties();
		pp.load( new FileInputStream("OR.properties"));
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(pp.getProperty("url"));
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		dr.findElement(By.xpath(pp.getProperty("objuser"))).sendKeys("username");
		dr.findElement(By.xpath(pp.getProperty("objpass"))).sendKeys("password");
		dr.findElement(By.xpath(pp.getProperty("objlogin"))).click();
		dr.close();
	}
}
