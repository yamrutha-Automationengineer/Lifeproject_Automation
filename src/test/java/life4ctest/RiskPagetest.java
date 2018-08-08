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
import life4cpages.RiskPage;

public class RiskPagetest extends TestBase {

	LoginPage loginpage;
	AppsPage appspage;
	Dashboardpage dashboardpage;
	PolicyMembersPage policymemberspage;
	HealthPage healthpage;
	MortgagePage mortgagepage;
	OccupationPage occupationpage;
	RiskPage riskpage;

	public RiskPagetest() {
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
		appspage = loginpage.login(prop.getProperty("email"), prop.getProperty("pwd"));
		appspage.lifeinsurance();
		dashboardpage.NewJourneybtn();
		policymemberspage.mem1form();
		healthpage.MEMtextbox();
		mortgagepage.Mortgageform();
		occupationpage.Occupationform();
	}

	@Test(priority = 1)
	public void valRiskheadertest() {
		String Riskheadertext = riskpage.ValidateRiskheader();
		Assert.assertEquals(Riskheadertext, "RISK");
		System.out.println(Riskheadertext);

	}

	@Test(priority = 2)
	public void valRisktabtest() {
		boolean flag = riskpage.ValidateRisktab();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}

	@Test(priority = 3)
	public void Valmem1headertest() {
		String Riskmem1text = riskpage.ValidateMem1header();
		Assert.assertEquals(Riskmem1text, "MEMBER1");
		System.out.println(Riskmem1text);
	}

	@Test(priority = 4)
	public void Valmem2headertest() {
		String Riskmem2text = riskpage.ValidateMem2header();
		Assert.assertEquals(Riskmem2text, "MEMBER2");
		System.out.println(Riskmem2text);
	}

	@Test(priority = 5)
	public void ValHPflmem1test() {
		String HPflmem1text = riskpage.ValidateHPflmem1();
		Assert.assertEquals(HPflmem1text, "Hazardous Pursuits:");
		System.out.println(HPflmem1text);
	}

	@Test(priority = 6)
	public void ValHPdtflnamemem1test() {
		String HPdtflnamemem1 = riskpage.ValidateHPdtflnamemem1();
		Assert.assertEquals(HPdtflnamemem1, "Hazardous Pursuits details:");
		System.out.println(HPdtflnamemem1);
	}

	@Test(priority = 7)
	public void ValITflnamemem1test() {
		String ITdtflnamemem1 = riskpage.ValidateITflnamemem1();
		Assert.assertEquals(ITdtflnamemem1, "International Travel:");
		System.out.println(ITdtflnamemem1);

	}

	@Test(priority = 8)
	public void ValITdtflnamemem1test() {
		String ITdtflnamemem1 = riskpage.ValidateITdtflnamemem1();
		Assert.assertEquals(ITdtflnamemem1, "International Travel details:");
		System.out.println(ITdtflnamemem1);
	}

	@Test(priority = 9)
	public void ValHPflmem2test() {
		String HPflmem2text = riskpage.ValidateHPflnamemem2();
		Assert.assertEquals(HPflmem2text, "Hazardous Pursuits:");
		System.out.println(HPflmem2text);
	}

	@Test(priority = 10)
	public void ValHPdtflnamemem2test() {
		String HPdtflnamemem2 = riskpage.ValidateHPdtflnamemem2();
		Assert.assertEquals(HPdtflnamemem2, "Hazardous Pursuits details:");
		System.out.println(HPdtflnamemem2);
	}

	@Test(priority = 11)
	public void ValITflnamemem2test() {
		String ITflnamemem2 = riskpage.ValidateITflnamemem2();
		Assert.assertEquals(ITflnamemem2, "International Travel:");
		System.out.println(ITflnamemem2);
	}

	@Test(priority = 12)
	public void ValITfldtnamemem2test() {
		String ITdtflnamemem2 = riskpage.ValidateITdtflnamemem2();
		Assert.assertEquals(ITdtflnamemem2, "International Travel details:");
		System.out.println(ITdtflnamemem2);
	}

	@Test(priority = 13)
	public void Valriskformtest() throws InterruptedException {
		riskpage.ValidateRiskform();
	}

}
