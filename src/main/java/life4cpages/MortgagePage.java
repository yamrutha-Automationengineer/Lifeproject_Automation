package life4cpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import life4cbase.TestBase;
import life4cutil.TestUtil;

public class MortgagePage extends TestBase {

	// Page factory -Or;
	// Mortgage tab
	@FindBy(xpath = "//a[@href='#/mortgage'][contains(.,'mortgage')]")
	WebElement mortgagetab;
	// Mortgageheader
	@FindBy(xpath = "//h3[contains(.,'mortgage')]")
	WebElement Mortgageheader;
	// Member1 header
	@FindBy(xpath = "//h5[contains(.,'Member 1')]")
	WebElement Member1header;
	// Member2 header
	@FindBy(xpath = "//h5[contains(.,'Member 2')]")
	WebElement Member2header;
	// mem1-mortgage-Yes& no radiobtn
	@FindBy(xpath = "(//input[contains(@type,'radio')])[1]")
	WebElement Mem1mortgage;
	// mem1-TYPe of mortgage
	@FindBy(xpath = "(//input[contains(@id,'type3')])[1]")
	WebElement Mem1typeofmtg;
	// mem1-OutstandingAmount
	@FindBy(xpath = "(//input[contains(@name,'outstanding_amount')])[1]")
	WebElement Mem1Outamt;
	// mem1-Outstndingterm
	@FindBy(xpath = "(//input[contains(@name,'outstanding_term')])[1]")
	WebElement Mem1Outterm;
	// mem1-Monthlyrepayment
	@FindBy(xpath = "(//input[contains(@name,'monthly_repayment')])[1]")
	WebElement Mem1mtlyrpm;
	// savebtn
	@FindBy(xpath = "(//button[@class='btn btn-primary'][contains(.,'Save')])[2]")
	WebElement savebtn;
	// mem2-moertage-Yes& no radiobtn
	@FindBy(xpath = "(//input[contains(@type,'radio')])[5]")
	WebElement Mem2mortgage;
	// mem1-TYPe of mortgage
	@FindBy(xpath = "(//input[contains(@id,'type3')])[2]")
	WebElement Mem2typeofmtg;
	// mem1-OutstandingAmount
	@FindBy(xpath = "(//input[contains(@name,'outstanding_amount')])[2]")
	WebElement Mem2Outamt;
	// mem1-Outstndingterm
	@FindBy(xpath = "(//input[contains(@name,'outstanding_term')])[2]")
	WebElement Mem2Outterm;
	// mem1-Monthlyrepayment
	@FindBy(xpath = "(//input[contains(@name,'monthly_repayment')])[2]")
	WebElement Mem2mtlyrpm;

	// nextbtn
	@FindBy(xpath = "//button[@class='btn btn-default'][contains(.,'Next')]")
	WebElement nextbtn;

	// Initialising the page objects:
	public MortgagePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean validateMortgagetab() {
		return mortgagetab.isEnabled();
	}

	public String valmtgheader() {
		Member1header.getText();
		Member2header.getText();
		return Mortgageheader.getText();
	}

	public OccupationPage Mortgageform() throws Exception {
		Thread.sleep(2000);
		Mem1mortgage.click();
		Mem1typeofmtg.click();
		Mem1Outamt.sendKeys("260000");
		Mem1Outterm.sendKeys("23");
		Mem1mtlyrpm.sendKeys("950");
		savebtn.click();
		Thread.sleep(3000);
		Mem2mortgage.click();
		Mem2typeofmtg.click();
		Mem2Outamt.sendKeys("260000");
		Mem2Outterm.sendKeys("23");
		Mem2mtlyrpm.sendKeys("950");
		savebtn.click();
		TestUtil.captureScreenShot("Mortgagepage", driver);
		nextbtn.click();
		return new OccupationPage();
	}

}
