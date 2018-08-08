package life4cpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import life4cbase.TestBase;
import life4cutil.TestUtil;

public class ExistingpoliciesPage extends TestBase {

	// Page factory -Or;
	// Existing policies header
	@FindBy(xpath = "//h3[contains(.,'Existing policies')]")
	WebElement EPheader;
	// Existing policies tab
	@FindBy(xpath = "//a[@href='#/existing-policies'][contains(.,'Existing Policies')]")
	WebElement EPtab;
	// Add existing policy header
	@FindBy(xpath = "//h4[contains(.,'Add existing policy')]")
	WebElement AEPheader;
	// Type
	@FindBy(xpath = "//select[contains(@name,'type')]")
	WebElement EPtype;
	// Premium
	@FindBy(xpath = "//input[contains(@name,'premium')]")
	WebElement EPpremium;
	// IN Trust
	@FindBy(xpath = "(//button[@name='in_trust'])[2]")
	WebElement EPintrust;
	// whos covered
	@FindBy(xpath = "(//input[contains(@class,'form-check-input')])[1]")
	WebElement EPch1;
	@FindBy(xpath = "(//input[contains(@class,'form-check-input')])[2]")
	WebElement EPch2;
	// Insurer

	@FindBy(xpath = "//input[contains(@id,'insurer')]")
	WebElement EPinsurer;
	// sum Assured
	@FindBy(xpath = "//input[@id='sum_assured']")
	WebElement EPsumAssured;
	// Term
	@FindBy(xpath = "//input[contains(@name,'term')]")
	WebElement EPTerm;
	// EXisting policydetails
	@FindBy(css = ".table > tbody:nth-child(2)")
	WebElement EPdetails;
	// Previous
	@FindBy(xpath = "//button[@class='btn btn-warning'][contains(.,'Previous')]")
	WebElement prebtn;
	// ADDpolicy
	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Add Policy')]")
	WebElement AddPolicybtn;
	// Next
	@FindBy(xpath = "//button[@class='btn btn-default'][contains(.,'Next')]")
	WebElement nextbtn;

	public ExistingpoliciesPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean ValidateEPtab() {
		return EPtab.isEnabled();
	}

	public String ValidateEPheader() {
		return EPheader.getText();
	}

	public String ValidateAEPheader() {
		return AEPheader.getText();
	}

	public ChildrenPage ExistingPoliciesform() throws InterruptedException {
		Select type = new Select(EPtype);
		type.selectByVisibleText("PMI");
		EPpremium.sendKeys("65");
		EPintrust.click();
		EPch1.click();
		EPch2.click();
		EPinsurer.sendKeys("Exeter");
		EPsumAssured.sendKeys("500000");
		EPTerm.sendKeys("30");
		Thread.sleep(2000);
		AddPolicybtn.click();
		Thread.sleep(2000);
		boolean Epdetails = EPdetails.isDisplayed();
		System.out.println(Epdetails);
		TestUtil.captureScreenShot("ExistingPoliciespage", driver);
		nextbtn.click();
		return new ChildrenPage();

	}

}
