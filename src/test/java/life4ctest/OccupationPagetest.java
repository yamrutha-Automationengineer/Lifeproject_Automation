package life4ctest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import life4cbase.TestBase;
import life4cpages.AppsPage;
import life4cpages.Dashboardpage;
import life4cpages.HealthPage;
import life4cpages.LoginPage;
import life4cpages.MortgagePage;
import life4cpages.OccupationPage;
import life4cpages.PolicyMembersPage;

public class OccupationPagetest extends TestBase {

	LoginPage loginpage;
	AppsPage appspage;
	Dashboardpage dashboardpage;
	PolicyMembersPage policymemberspage;
	HealthPage healthpage;
	MortgagePage mortgagepage;
	OccupationPage occupationpage;

	public OccupationPagetest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage = new LoginPage();
		appspage = new AppsPage();
		dashboardpage = new Dashboardpage();
		policymemberspage = new PolicyMembersPage();
		healthpage = new HealthPage();
		mortgagepage = new MortgagePage();
		occupationpage = new OccupationPage();
		appspage = loginpage.login(prop.getProperty("email"), prop.getProperty("pwd"));
		appspage.lifeinsurance();
		dashboardpage.NewJourneybtn();
		policymemberspage.mem1form();
		healthpage.MEMtextbox();
		mortgagepage.Mortgageform();
	}

	@Test(priority = 1)
	public void valOccheadertest() {
		String Occheadertext = occupationpage.valOccheader();
		Assert.assertEquals(Occheadertext, "OCCUPATION");
		System.out.println(Occheadertext);

	}

	@Test(priority = 2)
	public void valOcctabtest() {
		boolean flag = occupationpage.validateOccupationtab();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}

	@Test(priority = 3)
	public void Occupationformtest() throws Exception {
		occupationpage.Occupationform();
	}
}
