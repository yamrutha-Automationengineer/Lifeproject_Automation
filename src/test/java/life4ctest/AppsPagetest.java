package life4ctest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import life4cbase.TestBase;
import life4cpages.AppsPage;
import life4cpages.Dashboardpage;
import life4cpages.LoginPage;

public class AppsPagetest extends TestBase {
	LoginPage loginpage;
	AppsPage appspage;
	Dashboardpage dashboardpage;

	public AppsPagetest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		appspage = loginpage.login(prop.getProperty("email"), prop.getProperty("pwd"));
	}

	@Test(priority = 1)
	public void usertest() {
		String user = appspage.validateuser();
		System.out.println(user);
	}

	@Test(priority = 2)
	public void imgtest() {
		boolean flag = appspage.validateUCimg();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}

	@Test(priority = 3)
	public void dashboardtexttest() {
		String text = appspage.validate4cdashboardtext();
		System.out.println(text);
	}

	@Test(priority = 4)
	public void lifeinsurancetest() {
		dashboardpage = appspage.lifeinsurance();
	}

	@Test(priority = 5)
	public void signouttest() {
		loginpage = appspage.signout();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
