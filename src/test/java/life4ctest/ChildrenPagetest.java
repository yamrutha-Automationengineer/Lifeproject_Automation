package life4ctest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import life4cbase.TestBase;
import life4cpages.AppsPage;
import life4cpages.ChildrenPage;
import life4cpages.Dashboardpage;
import life4cpages.ExistingpoliciesPage;
import life4cpages.HealthPage;
import life4cpages.LoginPage;
import life4cpages.MortgagePage;
import life4cpages.OccupationPage;
import life4cpages.OutgoingsPage;
import life4cpages.PolicyMembersPage;
import life4cpages.RiskPage;

public class ChildrenPagetest extends TestBase {

	LoginPage loginpage;
	AppsPage appspage;
	Dashboardpage dashboardpage;
	PolicyMembersPage policymemberspage;
	HealthPage healthpage;
	MortgagePage mortgagepage;
	OccupationPage occupationpage;
	RiskPage riskpage;
	OutgoingsPage outgoingspage;
	ExistingpoliciesPage existingpoliciespage;
	ChildrenPage childrenpage;

	public ChildrenPagetest() {
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
		existingpoliciespage = new ExistingpoliciesPage();
		childrenpage = new ChildrenPage();
		appspage = loginpage.login(prop.getProperty("email"), prop.getProperty("pwd"));
		appspage.lifeinsurance();
		dashboardpage.NewJourneybtn();
		policymemberspage.mem1form();
		healthpage.MEMtextbox();
		mortgagepage.Mortgageform();
		occupationpage.Occupationform();
		riskpage.ValidateRiskform();
		outgoingspage.Outgoingsform();
		existingpoliciespage.ExistingPoliciesform();

	}

	@Test(priority = 1)
	public void ValCHheadertest() {
		String CHheadertext = childrenpage.Validatechheader();
		Assert.assertEquals(CHheadertext, "CHILDREN");
		System.out.println(CHheadertext);

	}

	@Test(priority = 2)
	public void ValCHtabtest() {
		boolean flag = childrenpage.Validatechtab();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}

	@Test(priority = 3)
	public void ValACHtabtest() {
		String ACHheadertext = childrenpage.ValidateAchheader();
		Assert.assertEquals(ACHheadertext, "ADD CHILD");
		System.out.println(ACHheadertext);
	}

	@Test(priority = 4)
	public void Childrenformtest() throws InterruptedException {
		childrenpage.childrensform();
	}

}
