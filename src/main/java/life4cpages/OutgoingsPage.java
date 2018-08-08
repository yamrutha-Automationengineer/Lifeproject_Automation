package life4cpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import life4cbase.TestBase;

public class OutgoingsPage extends TestBase {

	// Page factory -Or;
	// Outgoings tab
	@FindBy(xpath = "//a[contains(.,'outgoings')]")
	WebElement OGtab;
	// Outgoings header
	@FindBy(xpath = "//h3[contains(.,'outgoings')]")
	WebElement OGheader;
	// Outgoings housemem1
	@FindBy(xpath = "(//input[@name='house_outgoings'])[1]")
	WebElement OGhousem1;
	// Outgoings billsmem1
	@FindBy(xpath = "(//input[@name='bills_outgoings'])[1]")
	WebElement OGbillsm1;
	// Outgoings carmem1
	@FindBy(xpath = "(//input[@name='car_outgoings'])[1]")
	WebElement OGcarm1;
	// Outgoings Loansmem1
	@FindBy(xpath = "(//input[@name='loan_outgoings'])[1]")
	WebElement OGLoansm1;
	// Outgoings savingsmem1
	@FindBy(xpath = "(//input[@name='savings_outgoings'])[1]")
	WebElement OGsavingsm1;
	// Outgoings othermem1
	@FindBy(xpath = "(//input[@name='other_outgoings'])[1]")
	WebElement OGotherm1;
	// Outgoings Totalmem1
	@FindBy(xpath = "(//input[@name='total_outgoings'])[1]")
	WebElement OGtotalm1;
	// Outgoings Budgetmem1
	@FindBy(xpath = "(//input[@name='budget_outgoings'])[1]")
	WebElement OGBudgetm1;
	// Outgoings housemem2
	@FindBy(xpath = "(//input[@name='house_outgoings'])[2]")
	WebElement OGhousem2;
	// Outgoings billsmem2
	@FindBy(xpath = "(//input[@name='bills_outgoings'])[2]")
	WebElement OGbillsm2;
	// Outgoingscarmem2
	@FindBy(xpath = "(//input[@name='car_outgoings'])[2]")
	WebElement OGcarm2;
	// Outgoings loanmem2
	@FindBy(xpath = "(//input[@name='loan_outgoings'])[2]")
	WebElement OGloansm2;
	// Outgoings Savingsmem2
	@FindBy(xpath = "(//input[@name='savings_outgoings'])[2]")
	WebElement OGsavingsm2;
	// OUTgoings othermem2
	@FindBy(xpath = "(//input[@name='other_outgoings'])[2]")
	WebElement OGotherm2;
	// Outgoings totalmem2
	@FindBy(xpath = "(//input[@name='total_outgoings'])[2]")
	WebElement OGtotalm2;
	// Outgoings budgetmem2
	@FindBy(xpath = "(//input[@name='budget_outgoings'])[2]")
	WebElement OGbudgetm2;
	// previous btn
	@FindBy(xpath = "//button[@class='btn btn-warning'][contains(.,'Previous')]")
	WebElement prebtn;
	// savebtn
	@FindBy(xpath = "(//button[@class='btn btn-primary'][contains(.,'Save')])[2]")
	WebElement savebtn;
	// Nextbtn
	@FindBy(xpath = "//button[@class='btn btn-default'][contains(.,'Next')]")
	WebElement nextbtn;

	public OutgoingsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean ValidateOGtab() {
		return OGtab.isEnabled();
	}

	public String ValidateOGheader() {
		return OGheader.getText();
	}

	public ExistingpoliciesPage Outgoingsform() throws InterruptedException {
		OGhousem1.sendKeys("900");
		OGbillsm1.sendKeys("1000");
		OGcarm1.sendKeys("200");
		OGLoansm1.sendKeys("5000");
		OGsavingsm1.sendKeys("10000");
		OGotherm1.sendKeys("500");
		OGtotalm1.sendKeys("2600");
		OGBudgetm1.sendKeys("70");
		Thread.sleep(3000);
		OGhousem2.sendKeys("900");
		OGbillsm2.sendKeys("1000");
		OGcarm2.sendKeys("200");
		OGloansm2.sendKeys("5000");
		OGsavingsm2.sendKeys("10000");
		OGotherm2.sendKeys("1000");
		OGtotalm2.sendKeys("3100");
		OGbudgetm2.sendKeys("70");
		Thread.sleep(3000);
		savebtn.click();
		nextbtn.click();
		return new ExistingpoliciesPage();

	}
}
