package life4cpages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import life4cbase.TestBase;
import life4cutil.TestUtil;

public class Dashboardpage extends TestBase {

	// Page factory -Or;
	// logo
	@FindBy(xpath = "//img[@alt='Usay Compare']")
	WebElement LogoonDashp;

	// Apps
	@FindBy(xpath = "//a[@class='nav-link'][contains(.,'Apps')]")
	WebElement Appsbtn;

	// LifeInsurance
	@FindBy(xpath = "//a[@class='nav-link  dropdown-toggle'][contains(.,'Life Insurance')]")
	WebElement LifeInsurancebtn;

	// lifeinsurance-Dashboard
	@FindBy(xpath = "//a[@class='nav-link'][contains(.,'Dashboard')]")
	WebElement Dashboardbtn;

	// lifeinsurance-NewJourney
	@FindBy(xpath = "//a[@class='nav-link'][contains(.,'New Journey')]")
	WebElement NewJourneybtn;

	// Management
	@FindBy(xpath = "//a[@class='nav-link  dropdown-toggle'][contains(.,'Management')]")
	WebElement Managementbtn;

	// dailer
	@FindBy(xpath = "//span[contains(@class,'oi oi-headphones')]")
	WebElement Dailerbtn;

	// Start Dialling
	@FindBy(xpath = "//button[@class='btn btn-success'][contains(.,'START DIALLING')]")
	WebElement Startdaillingbtn;

	// personbtn for signout
	@FindBy(xpath = "//span[contains(@class,'oi oi-person')]")
	WebElement Personbtn;
	@FindBy(xpath = "//a[contains(.,'Sign out')]")
	WebElement signoutbtn;

	// ClientJourneys table title
	@FindBy(xpath = "//div[@class='mr-auto p-2 table-title'][contains(.,'Client Journeys')]")
	WebElement Cjtitle;

	// Search
	@FindBy(xpath = "(//div[@class='p-2 align-self-center table-search'][contains(.,'Search')])[1]")
	WebElement Searchopt;
	@FindBy(xpath = "(//input[contains(@type,'text')])[1]")
	WebElement JourneyID;
	@FindBy(xpath = "(//input[contains(@type,'text')])[2]")
	WebElement Firstname;
	@FindBy(xpath = "(//input[contains(@type,'text')])[3]")
	WebElement Lastname;
	@FindBy(xpath = "(//input[contains(@type,'text')])[4]")
	WebElement Telephone;
	@FindBy(xpath = "(//input[contains(@type,'text')])[5]")
	WebElement Status;
	@FindBy(xpath = "(//input[contains(@type,'text')])[6]")
	WebElement Created;
	@FindBy(css = "div.rt-tbody:nth-child(4) > div:nth-child(1) > div:nth-child(1)")
	WebElement resultjourney;
	// policyholder header
	@FindBy(xpath = "//div[@class='rt-th'][contains(.,'Policy holder')]")
	WebElement Phheader;

	// table
	@FindBy(css = "#clients-dashboard")
	List<WebElement> Clientstable;

	// Initializing the page objects:

	public Dashboardpage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	// for login
	public boolean ValUClogooncjp() throws InterruptedException {
		Thread.sleep(3000);
		return LogoonDashp.isDisplayed();
	}

	// for Apps
	public AppsPage Validateapps() throws InterruptedException {
		Thread.sleep(3000);
		Appsbtn.click();
		return new AppsPage();

	}

	// for LifeInsurance
	public void Lifeinsuranceondash() {
		LifeInsurancebtn.click();

	}

	public Dashboardpage ValDashboardbtn() throws InterruptedException {
		LifeInsurancebtn.click();
		Thread.sleep(3000);
		Dashboardbtn.click();
		return new Dashboardpage();
	}

	public PolicyMembersPage NewJourneybtn() throws InterruptedException {
		LifeInsurancebtn.click();
		Thread.sleep(3000);
		NewJourneybtn.click();
		return new PolicyMembersPage();

	}

	public void ValMgmtbtn() {
		Managementbtn.click();
	}

	public void ValDailler() {
		Dailerbtn.click();
		Startdaillingbtn.click();

	}

	public LoginPage Signoutbtn() {
		Personbtn.click();
		signoutbtn.click();
		return new LoginPage();

	}

	public String CJtitletext() {
		return Cjtitle.getText();
	}

	public boolean Search() throws InterruptedException {
		Searchopt.click();
		JourneyID.sendKeys("24");
		Thread.sleep(3000);
		TestUtil.captureScreenShot("ClientJourneytablesearch", driver);
		return resultjourney.isDisplayed();
	}

	public String CJTableheader() {
		return Phheader.getText();
	}

	public List<WebElement> CJtable() throws Exception {
		Thread.sleep(3000);
		for (WebElement g : Clientstable) {
			System.out.println(g.getText());
		}
		return Clientstable;
	}
}

