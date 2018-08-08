package life4ctest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import life4cbase.TestBase;
import life4cpages.AppsPage;
import life4cpages.LoginPage;

public class LoginPagetest extends TestBase {
	LoginPage loginPage;
	AppsPage appspage;

	public LoginPagetest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginpageTitletest() {
		String title = loginPage.validateLoginPagetitle();
		Assert.assertEquals(title, "4C - Login");
		System.out.println(title);
	}

	@Test(priority = 2)
	public void logintest() throws InterruptedException {
		appspage = loginPage.login(prop.getProperty("email"), prop.getProperty("pwd"));
	}

	@Test(priority = 3)
	public void Usaylogotest() throws InterruptedException {
		boolean flag = loginPage.validateUClogo();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}

	@Test(priority = 4)
	public void signintotexttest() {
		boolean flag = loginPage.signintotext();
		Assert.assertTrue(flag);
		System.out.println(flag);

	}

	@Test(priority = 5)
	public void screenshottest() throws InterruptedException {
		LoginPage.screenshot();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
