package life4ctest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Loginpage4cplus {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		// to run Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Amruta.Yembuluru\\driver\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://login.4cplus-staging.uk");
	}

	@Test
	public void logintest() throws InterruptedException {
		String title = driver.getTitle();
		System.out.println("Your page title Is : " + title);
		Assert.assertEquals(title, "4C - Login", "title is not matched");

		Thread.sleep(2000);
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("amruta.yembuluru@usaycompare.com");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		pwd.sendKeys("secret");
		driver.findElement(By.id("signInButton")).click();
		Thread.sleep(2000);
		// checking the user is visible.
		if (driver.findElement(By.xpath("//div[@id='user']")).isDisplayed()) {
			System.out.println("Element is Visible");
		} else {
			System.out.println("Element is InVisible");
		}
		// checking the usaycompare title exists.
		WebElement logo = driver.findElement(By.xpath("//img[@id='logo']"));
		String uclogo = logo.getText();
		if (logo.isDisplayed()) {
			System.out.println("logo is displayed:" + uclogo);
		} else {
			System.out.println("logo is not displayed:" + uclogo);
		}

		// checking the text"your 4c Dashboard"
		if (driver.findElement(By.xpath("//h1[contains(.,'Your 4C Dashboard.')]")).isDisplayed()) {
			System.out.println("Element is Visible");
		} else {
			System.out.println("Element is InVisible");
		}
		// User
		WebElement user = driver.findElement(By.id("user"));
		String Userdis = user.getText();
		System.out.println("The Logged username is:" + Userdis);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
