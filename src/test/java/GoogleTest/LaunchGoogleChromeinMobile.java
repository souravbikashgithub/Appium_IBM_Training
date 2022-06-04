package GoogleTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchGoogleChromeinMobile {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SouravAndroid");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, System.getProperty("user.dir")+"\\src\\test\\resources\\ChromeDriver\\chromedriver.exe");
		
		AndroidDriver ad= new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
	ad.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		ad.get("http://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		ad.findElement(By.xpath("//*[@class='ico-register']")).click();
		Thread.sleep(5000);
		ad.findElement(By.xpath("//*[@id='gender-male']")).click();
		ad.findElement(By.xpath("//*[@id='FirstName']")).sendKeys("Sourav");
		ad.findElement(By.xpath("//*[@id='LastName']")).sendKeys("Saha");

	    String generatedString = String.valueOf(Math.random());
		ad.findElement(By.xpath("//*[@id='Email']")).sendKeys("AppiumSourav"+generatedString+"@test.com");
		ad.findElement(By.xpath("//*[@id='Password']")).sendKeys("S0urav1234");
		ad.findElement(By.xpath("//*[@id='ConfirmPassword']")).sendKeys("S0urav1234");
		
		ad.findElement(By.xpath("//*[@id='register-button']")).click();
		Thread.sleep(5000);
		if(ad.findElement(By.xpath("//*[@class='result']")).isDisplayed()==true) {
			
			Assert.assertEquals(ad.findElement(By.xpath("//*[@class='result']")).getText(),"Your registration completed");
		}
		else {
			Thread.sleep(5000);
			Assert.assertEquals(ad.findElement(By.xpath("//*[@class='result']")).getText(),"Your registration completed");
			
		}
		
	}

}
