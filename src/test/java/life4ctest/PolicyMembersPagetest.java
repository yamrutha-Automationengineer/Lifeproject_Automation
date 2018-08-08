package life4ctest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import life4cbase.TestBase;
import life4cpages.AppsPage;
import life4cpages.Dashboardpage;
import life4cpages.LoginPage;
import life4cpages.PolicyMembersPage;

public class PolicyMembersPagetest extends TestBase {
	LoginPage loginpage;
	AppsPage appspage;
	Dashboardpage dashboardpage;
	PolicyMembersPage policymemberspage;

	public PolicyMembersPagetest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		appspage = new AppsPage();
		dashboardpage = new Dashboardpage();
		policymemberspage = new PolicyMembersPage();
		appspage = loginpage.login(prop.getProperty("email"), prop.getProperty("pwd"));
		appspage.lifeinsurance();
		dashboardpage.NewJourneybtn();
	}

	@Test(priority = 1)
	public void enabPMtabtest() {
		boolean flag = policymemberspage.validatePMtab();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}

	@Test(priority = 2)
	public void valmem1headertest() {
		String headertextmem1 = policymemberspage.valmem1header();
		Assert.assertEquals(headertextmem1, "MEMBER 1");
		System.out.println(headertextmem1);
	}

	@Test(priority = 3)
	public void valmem2headertest() {
		String headertextmem2 = policymemberspage.valmem2header();
		Assert.assertEquals(headertextmem2, "MEMBER 2");
		System.out.println(headertextmem2);
	}

	@Test(priority = 4)
	public void mem1formtest() throws Exception {
		policymemberspage.mem1form();
	}
}
