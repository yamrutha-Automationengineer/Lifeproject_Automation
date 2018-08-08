package life4ctest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import life4cbase.TestBase;
import life4cpages.AppsPage;
import life4cpages.Dashboardpage;
import life4cpages.LoginPage;

public class DashboardPagetest extends TestBase {

	LoginPage loginpage;
	AppsPage appspage;
	Dashboardpage dashboardpage;

	public DashboardPagetest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		appspage = new AppsPage();
		dashboardpage = new Dashboardpage();
		appspage = loginpage.login(prop.getProperty("email"), prop.getProperty("pwd"));
		appspage.lifeinsurance();
	}

	@Test(priority = 1)
	public void Usaylogotestondashboardtest() throws InterruptedException {
		boolean flag = dashboardpage.ValUClogooncjp();
		Assert.assertTrue(flag);
		System.out.println(flag);

	}

	@Test(priority = 2)
	public void Appsbtntest() throws InterruptedException {
		dashboardpage.Validateapps();
	}

	@Test(priority = 3)
	public void Lifeinsuranceopttest() {
		dashboardpage.Lifeinsuranceondash();
	}

	@Test(priority = 4)
	public void ReturntodashfromLItest() throws InterruptedException {
		dashboardpage.ValDashboardbtn();
	}

	@Test(priority = 4)
	public void NewJourneybtntest() throws InterruptedException {
		dashboardpage.NewJourneybtn();
	}

	@Test(priority = 5)
	public void Mgmtbtntest() throws InterruptedException {
		dashboardpage.ValMgmtbtn();
	}

	@Test(priority = 6)
	public void Daillingbtntest() throws InterruptedException {
		dashboardpage.ValDailler();
	}

	@Test(priority = 7)
	public void Signoutbtntest() {
		dashboardpage.Signoutbtn();
	}

	@Test(priority = 8)
	public void Cjtitletest() {
		String text = dashboardpage.CJtitletext();
		System.out.println(text);

	}

	@Test(priority = 9)
	public void Searchtest() throws InterruptedException {
		boolean flag = dashboardpage.Search();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}

	@Test(priority = 10)
	public void CJTableheadertest() {
		String headertext = dashboardpage.CJTableheader();
		System.out.println(headertext);
	}

	@Test(priority = 11)
	public void listingclientstabletest() throws Exception {
		dashboardpage.CJtable();

	}
}