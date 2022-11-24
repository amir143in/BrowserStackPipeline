package pathCheck;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckThePath {
	public WebDriver driver;

	@BeforeMethod
		public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	//	WebDriver driver = new ChromeDriver();
		String url = "https://www.browserstack.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get(url);
	}
	
	@Test
	public void verifyHomepageTitle() {
		
		String expectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
