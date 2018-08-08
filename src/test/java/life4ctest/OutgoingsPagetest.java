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
import life4cpages.OutgoingsPage;
import life4cpages.PolicyMembersPage;
import life4cpages.RiskPage;

public class OutgoingsPagetest extends TestBase {

	LoginPage loginpage;
	AppsPage appspage;
	Dashboardpage dashboardpage;
	PolicyMembersPage policymemberspage;
	HealthPage healthpage;
	MortgagePage mortgagepage;
	OccupationPage occupationpage;
	RiskPage riskpage;
	OutgoingsPage outgoingspage;

	public OutgoingsPagetest() {
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
		riskpage = new RiskPage();
		outgoingspage = new OutgoingsPage();
		appspage = loginpage.login(prop.getProperty("email"), prop.getProperty("pwd"));
		appspage.lifeinsurance();
		dashboardpage.NewJourneybtn();
		policymemberspage.mem1form();
		healthpage.MEMtextbox();
		mortgagepage.Mortgageform();
		occupationpage.Occupationform();
		riskpage.ValidateRiskform();
	}

	@Test(priority = 1)
	public void valOGheadertest() {
		String OGheadertext = outgoingspage.ValidateOGheader();
		Assert.assertEquals(OGheadertext, "OUTGOINGS");
		System.out.println(OGheadertext);

	}

	@Test(priority = 2)
	public void valOGtabtest() {
		boolean flag = outgoingspage.ValidateOGtab();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}

	@Test(priority = 3)
	public void Outgoingsformtest() throws InterruptedException {
		outgoingspage.Outgoingsform();
	}

}
