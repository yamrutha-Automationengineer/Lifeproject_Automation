package life4cpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import life4cbase.TestBase;
import life4cutil.TestUtil;

public class HealthPage extends TestBase {

	// Page factory -Or;
	// Health header
	@FindBy(xpath = "//h3[contains(.,'health')]")
	WebElement Healthheader;
	// Health tab
	@FindBy(xpath = "//a[@href='#/health'][contains(.,'health')]")
	WebElement Healthtab;
	// Member1 header
	@FindBy(xpath = "//h5[contains(.,'Member 1')]")
	WebElement MEM1header;
	// Member2 header
	@FindBy(xpath = "//h5[contains(.,'Member 2')]")
	WebElement MEM2header;
	// Member1 fieldname
	@FindBy(xpath = "(//strong[contains(.,'Health issues (last 5 years):')])[1]")
	WebElement MEM1flname;
	// Member2 Fieldname
	@FindBy(xpath = "(//strong[contains(.,'Health issues (last 5 years):')])[2]")
	WebElement MEM2flname;
	// Member1 textbox
	@FindBy(xpath = "(//textarea[contains(@name,'health_issues')])[1]")
	WebElement MEM1textbox;
	// Member2 textbox
	@FindBy(xpath = "(//textarea[contains(@name,'health_issues')])[2]")
	WebElement MEM2textbox;
	// Previous btn
	@FindBy(xpath = "//button[@class='btn btn-warning'][contains(.,'Previous')]")
	WebElement prebtn;
	// save btn
	@FindBy(xpath = "(//button[@class='btn btn-primary'][contains(.,'Save')])[2]")
	WebElement savebtn;
	// nextbtn
	@FindBy(xpath = "//button[@class='btn btn-default'][contains(.,'Next')]")
	WebElement nextbtn;
	// Initializing the page objects:

	public HealthPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String valHealthheader() {
		return Healthheader.getText();

	}

	public boolean valHealthtab() {
		return Healthtab.isEnabled();
	}

	public String valMEM1header() {
		return MEM1header.getText();

	}

	public String valMEM2header() {
		return MEM2header.getText();
	}

	public String valMEM1flname() {
		return MEM1flname.getText();

	}

	public String valMEM2flname() {
		return MEM2flname.getText();
	}

	public MortgagePage MEMtextbox() throws Exception {
		MEM1textbox.sendKeys(TestUtil.generateRandomString(100));
		Thread.sleep(3000);
		MEM2textbox.sendKeys(TestUtil.generateRandomString(100));
		savebtn.click();
		Thread.sleep(3000);
		TestUtil.captureScreenShot("HEALTHpage", driver);
		nextbtn.click();
		return new MortgagePage();
	}

	public PolicyMembersPage prebtn() {
		prebtn.isDisplayed();
		prebtn.click();
		return new PolicyMembersPage();
	}

}

