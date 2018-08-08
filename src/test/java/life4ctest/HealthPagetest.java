package life4ctest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import life4cbase.TestBase;
import life4cpages.AppsPage;
import life4cpages.Dashboardpage;
import life4cpages.HealthPage;
import life4cpages.LoginPage;
import life4cpages.PolicyMembersPage;

public class HealthPagetest extends TestBase {
	LoginPage loginpage;
	AppsPage appspage;
	Dashboardpage dashboardpage;
	PolicyMembersPage policymemberspage;
	HealthPage healthpage;

	public HealthPagetest() {
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

		appspage = loginpage.login(prop.getProperty("email"), prop.getProperty("pwd"));
		appspage.lifeinsurance();
		dashboardpage.NewJourneybtn();
		policymemberspage.mem1form();
	}

	@Test(priority = 1)
	public void valHealthheadertest() {
		String headertext = healthpage.valHealthheader();
		Assert.assertEquals(headertext, "HEALTH");
		System.out.println(headertext);
	}

	@Test(priority = 2)
	public void valHealthtabtest() {
		boolean flag = healthpage.valHealthtab();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}

	@Test(priority = 3)
	public void valMEM1headertest() {
		String MEM1text = healthpage.valMEM1header();
		Assert.assertEquals(MEM1text, "MEMBER1");
		System.out.println(MEM1text);

	}

	@Test(priority = 4)
	public void valMEM2headertest() {
		String MEM2text = healthpage.valMEM2header();
		Assert.assertEquals(MEM2text, "MEMBER2");
		System.out.println(MEM2text);
	}

	@Test(priority = 5)
	public void valMEM1flnametest() {
		String MEM1flname = healthpage.valMEM1flname();
		Assert.assertEquals(MEM1flname, "MEMBER2");
		System.out.println(MEM1flname);
	}

	@Test(priority = 6)
	public void valMEM2flnametest() {
		String MEM2flname = healthpage.valMEM2flname();
		Assert.assertEquals(MEM2flname, "MEMBER2");
		System.out.println(MEM2flname);
	}

	@Test(priority = 7)
	public void MEMtextboxtest() throws Exception {
		healthpage.MEMtextbox();

	}

}
