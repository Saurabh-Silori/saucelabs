package Grid.SauceLabs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sauceLabs {


	WebDriver driver;
	@BeforeTest
	public void setup() throws MalformedURLException
	{
//		DesiredCapabilities caps = new DesiredCapabilities();
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setCapability("platformName", "Windows 10");
		browserOptions.setCapability("browserVersion", "latest");
		Map<String, Object> sauceOptions = new HashMap<>();
		browserOptions.setCapability("sauce:options", sauceOptions);
		
		driver = new RemoteWebDriver(
			    new URL("https://oauth-saurabh.silori-ffc45:55fece9a-4d1a-4880-ba2d-c4bd15a2c388@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions
			);
}

	@Test
	public void launchgoogle()
	{
		driver.get("https://www.google.com");
	}
	
	@AfterTest
	
	public void teardown()
	{
		driver.quit();
	}
	
}