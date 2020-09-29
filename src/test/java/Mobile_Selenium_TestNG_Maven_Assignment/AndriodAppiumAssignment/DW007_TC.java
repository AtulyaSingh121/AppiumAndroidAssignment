package Mobile_Selenium_TestNG_Maven_Assignment.AndriodAppiumAssignment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class DW007_TC {
	AndroidDriver driver;
	  @Test
	  public void Login() throws InterruptedException {
		  driver.get("http://demowebshop.tricentis.com/");
		  driver.findElement(By.xpath("//span[@class='icon']")).click();
	      driver.findElement(By.xpath("//a[contains(text(),'Electronics')]//following-sibling::span")).click();
	      driver.findElement(By.xpath("//ul[@class='mob-top-menu show']//li//a[contains(text(),'Camera, photo')]")).click();
	      Thread.sleep(5000);
	      Select dropdown = new Select( driver.findElement(By.xpath("//select[@id=\"products-pagesize\"]")));
	      dropdown.selectByVisibleText("12");
	  }
	  @BeforeTest
	  public void URLLaunch() throws MalformedURLException {
		  DesiredCapabilities capability= new DesiredCapabilities();
	      capability.setCapability("deviceName", "Mobile");
	      capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	      capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	      driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
	        
	  }

	  @AfterTest
	  public void LogOut() throws InterruptedException {
		  Thread.sleep(5000);
	      driver.close();
	  }

	}
