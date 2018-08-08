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
import life4cpages.QuotesPage;
import life4cpages.RiskPage;
import life4cutil.TestUtil;

public class QuotesPagetest extends TestBase {

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
	QuotesPage quotespage;

	public QuotesPagetest() {
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
		quotespage = new QuotesPage();
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
		childrenpage.childrensform();

	}

	@Test(priority = 1)
	public void ValQuotesheadertest() {
		String quotesheadertext = quotespage.ValidateQuotesheader();
		Assert.assertEquals(quotesheadertext, "INDICATIVE QUOTES");
		System.out.println(quotesheadertext);

	}

	@Test(priority = 2)
	public void ValQuotestabtest() {
		boolean flag = quotespage.Validatequotestab();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}

	@Test(priority = 3)
	public void Wholeoflifetest() throws InterruptedException {
		quotespage.wholeoflifequote();
		Thread.sleep(15000);
		TestUtil.captureScreenShot("Wholeoflifequote", driver);
	}

	@Test(priority = 4)
	public void Leveltermtest() throws InterruptedException {
		quotespage.LevelTermquote();
		Thread.sleep(15000);
		TestUtil.captureScreenShot("LevelTermquote", driver);

	}

	@Test(priority = 5)
	public void DecreasingTermtest() throws InterruptedException {
		quotespage.DecreasingTermQuote();
		Thread.sleep(15000);
		TestUtil.captureScreenShot("DecreasingTermQuote", driver);
	}

	@Test(priority = 6)
	public void FamilyIncomeBenefittest() throws InterruptedException {
		quotespage.FamilyIncomebenefitquote();
		Thread.sleep(15000);
		TestUtil.captureScreenShot("FamilyIncomebenefitquote", driver);
	}

	@Test(priority = 7)
	public void IncomeProtectiontest() throws InterruptedException {
		quotespage.Incomeprotectionquote();
		Thread.sleep(15000);
		TestUtil.captureScreenShot("Incomeprotectionquote", driver);
	}
}
