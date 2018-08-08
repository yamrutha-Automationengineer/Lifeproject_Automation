package life4cpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import life4cbase.TestBase;

public class QuotesPage extends TestBase {

	// Page factory -Or;
	// quotestab
	@FindBy(xpath = "//a[contains(.,'Quotes')]")
	WebElement Quotestab;
	// quotesheader
	@FindBy(xpath = "//h3[contains(.,'Indicative Quotes')]")
	WebElement Quotesheader;
	// Get a new quote btn
	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Get a new quote')]")
	WebElement NewQuotebtn;
	// Get Quotes header
	@FindBy(xpath = "//h5[@class='modal-title'][contains(.,'Get Quotes')]")
	WebElement GetQuotesheader;
	// Product
	@FindBy(css = ".product-options > div:nth-child(1) > div:nth-child(1) > select:nth-child(2)")
	WebElement product;
	// Quotebasis
	@FindBy(css = ".product-options > div:nth-child(1) > div:nth-child(2) > select:nth-child(2)")
	WebElement quotebasis;
	// Initial commission
	@FindBy(css = "span.input-group > input:nth-child(2)")
	WebElement Initialcommission;
	// Clients to quote for
	@FindBy(css = "div.col-md:nth-child(4) > select:nth-child(2)")
	WebElement Clientstoquotefor;
	// Lumpsumamount
	@FindBy(css = "div.input-group > input:nth-child(2)")
	WebElement lumpsumamount;
	// term
	@FindBy(css = "input.form-control:nth-child(3)")
	WebElement term;
	// lifecoveramount
	@FindBy(css = "div.row:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)")
	WebElement lifecoveramount;
	// critical illness cover
	@FindBy(css = "div.row:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)")
	WebElement criticalillnesscover;
	// Accelerated
	@FindBy(css = "div.row:nth-child(4) > div:nth-child(1) > select:nth-child(2)")
	WebElement accelerated;
	// loan amount
	@FindBy(css = "div.row:nth-child(5) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)")
	WebElement loanamount;
	// Interestrate
	@FindBy(css = "div.row:nth-child(5) > div:nth-child(2) > div:nth-child(2) > input:nth-child(2)")
	WebElement Interestrate;
	// Primary occupation status
	@FindBy(css = ".product-options > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > select:nth-child(2)")
	WebElement primaryoccupationst;
	// Incomeamount
	@FindBy(css = "div.row:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)")
	WebElement IncomeamountIP;
	// Incomeamount
	@FindBy(css = "div.row:nth-child(5) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)")
	WebElement IncomeamountFIB;
	// First benefit
	@FindBy(xpath = "//strong[contains(.,'First benefit')]")
	WebElement Firstbenefit;
	// Income payment
	@FindBy(css = "div.mb-3:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)")
	WebElement Incomepayment;
	// Deferred period
	@FindBy(css = "div.mb-3:nth-child(4) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > input:nth-child(2)")
	WebElement deferredperiod;
	// Payout period
	@FindBy(css = "div.mb-3:nth-child(4) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > input:nth-child(2)")
	WebElement payoutperiod;
	// ADD Another
	@FindBy(xpath = "//button[@class='btn btn-sm btn-link float-right'][contains(.,'Add another')]")
	WebElement addanother;
	// Second benefit
	@FindBy(xpath = "//strong[contains(.,'Second benefit')]")
	WebElement secondbenefit;

	// submit btn
	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Submit')]")
	WebElement submitbtn;
	// cancelbtn
	@FindBy(xpath = "//button[@class='btn'][contains(.,'Cancel')]")
	WebElement cancelbtn;

	public QuotesPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean Validatequotestab() {
		return Quotestab.isEnabled();
	}

	public String ValidateQuotesheader() {
		return Quotesheader.getText();
	}

	public void wholeoflifequote() {
		NewQuotebtn.click();
		Select WOLproduct = new Select(product);
		WOLproduct.selectByVisibleText("Whole of Life");
		Select WOLQuotebasis = new Select(quotebasis);
		WOLQuotebasis.selectByVisibleText("Benefit");
		Initialcommission.clear();
		Initialcommission.sendKeys("90");
		Select WOLClientstoquotefor = new Select(Clientstoquotefor);

		WOLClientstoquotefor.selectByValue("1");
		lumpsumamount.sendKeys("800000");
		submitbtn.click();

	}

	public void LevelTermquote() {
		NewQuotebtn.click();
		Select LTproduct = new Select(product);
		LTproduct.selectByVisibleText("Level Term");
		Select LTQuotebasis = new Select(quotebasis);
		LTQuotebasis.selectByVisibleText("Benefit");
		Initialcommission.clear();
		Initialcommission.sendKeys("90");
		Select LTClientstoquotefor = new Select(Clientstoquotefor);
		LTClientstoquotefor.selectByValue("1");
		term.clear();
		term.sendKeys("60");
		lifecoveramount.clear();
		lifecoveramount.sendKeys("600000");
		criticalillnesscover.clear();
		criticalillnesscover.sendKeys("200000");
		Select LTaccelerated = new Select(accelerated);
		LTaccelerated.selectByVisibleText("No");
		submitbtn.click();

	}

	public void DecreasingTermQuote() {
		NewQuotebtn.click();
		Select DTproduct = new Select(product);
		DTproduct.selectByVisibleText("Decreasing Term");
		Select DTQuotebasis = new Select(quotebasis);
		DTQuotebasis.selectByVisibleText("Benefit");
		Initialcommission.clear();
		Initialcommission.sendKeys("90");
		Select LTClientstoquotefor = new Select(Clientstoquotefor);

		LTClientstoquotefor.selectByValue("1");
		term.clear();
		term.sendKeys("60");
		lifecoveramount.clear();
		lifecoveramount.sendKeys("600000");
		criticalillnesscover.clear();
		criticalillnesscover.sendKeys("200000");
		Select LTaccelerated = new Select(accelerated);
		LTaccelerated.selectByVisibleText("No");
		loanamount.sendKeys("280000");
		Interestrate.clear();
		Interestrate.sendKeys("2.09");
		submitbtn.click();
	}

	public void FamilyIncomebenefitquote() {
		NewQuotebtn.click();
		Select FIBproduct = new Select(product);
		FIBproduct.selectByVisibleText("Family Income Benefit");
		Select FIBQuotebasis = new Select(quotebasis);
		FIBQuotebasis.selectByVisibleText("Benefit");
		Initialcommission.clear();
		Initialcommission.sendKeys("80");
		Select FTBClientstoquotefor = new Select(Clientstoquotefor);

		FTBClientstoquotefor.selectByValue("1");
		term.clear();
		term.sendKeys("60");
		lifecoveramount.clear();
		lifecoveramount.sendKeys("600000");
		criticalillnesscover.clear();
		criticalillnesscover.sendKeys("200000");
		Select FTBaccelerated = new Select(accelerated);
		FTBaccelerated.selectByVisibleText("No");
		IncomeamountFIB.clear();
		IncomeamountFIB.sendKeys("40000");
		submitbtn.click();

	}

	public void Incomeprotectionquote() {
		NewQuotebtn.click();
		Select IPproduct = new Select(product);
		IPproduct.selectByVisibleText("Income Protection");
		Select IPQuotebasis = new Select(quotebasis);
		IPQuotebasis.selectByVisibleText("Benefit");
		Initialcommission.clear();
		Initialcommission.sendKeys("80");
		Select IPClientstoquotefor = new Select(Clientstoquotefor);

		IPClientstoquotefor.selectByValue("1");
		term.clear();
		term.sendKeys("60");
		Select IPprimaryoccupationst = new Select(primaryoccupationst);
		IPprimaryoccupationst.selectByVisibleText("Other");
		IncomeamountIP.clear();
		IncomeamountIP.sendKeys("40000");
		boolean firstbenefitheader = Firstbenefit.isDisplayed();
		System.out.println(firstbenefitheader);
		Incomepayment.clear();
		Incomepayment.sendKeys("2000");
		deferredperiod.clear();
		deferredperiod.sendKeys("3");
		payoutperiod.clear();
		payoutperiod.sendKeys("6");
		submitbtn.click();

	}
}

