package life4cpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import life4cbase.TestBase;
import life4cutil.TestUtil;

public class RiskPage extends TestBase {

	// Page factory -Or;
	// risk tab
	@FindBy(xpath = "//a[@href='#/risk'][contains(.,'risk')]")
	WebElement Risktab;
	// Risk header
	@FindBy(xpath = "//h3[contains(.,'risk')]")
	WebElement Riskheader;
	// Member1 Header
	@FindBy(xpath = "//h5[contains(.,'Member 1')]")
	WebElement Mem1header;
	// Member2 Header
	@FindBy(xpath = "//h5[contains(.,'Member 2')]")
	WebElement Mem2header;
	// Hazardous pursuitsfieldname-mem1
	@FindBy(xpath = "(//strong[contains(.,'Hazardous Pursuits:')])[1]")
	WebElement HPflnamemem1;
	// hazardous pursuits radiobtn-mem1
	@FindBy(xpath = "(//input[contains(@name,'pursuits')])[1]")
	WebElement HPsyesbtnmem1;
	// hazardous pursuits details:mem1
	@FindBy(xpath = "(//strong[contains(.,'Hazardous Pursuits details:')])[1]")
	WebElement HPdtflnamemem1;
	// hazardous pursuits textbox:mem1
	@FindBy(xpath = "(//textarea[@name='hazardous_pursuits_details'])[1]")
	WebElement HPtextboxmem1;
	// International travel fieldname:mem1
	@FindBy(xpath = "(//strong[contains(.,'International Travel:')])[1]")
	WebElement ITflnamemem1;
	// International travel radiobtn-mem1
	@FindBy(xpath = "(//input[contains(@name,'travel')])[1]")
	WebElement ITradiobtnmem1;
	// International travel details fieldname:mem1
	@FindBy(xpath = "(//strong[contains(.,'International Travel details:')])[1]")
	WebElement ITdtflnamemem1;
	// International travel textbox:mem1
	@FindBy(xpath = "(//textarea[contains(@name,'international_travel_details')])[1]")
	WebElement ITtextboxmem1;
	// Hazardous pursuitsfieldname-mem2
	@FindBy(xpath = "(//strong[contains(.,'Hazardous Pursuits:')])[2]")
	WebElement HPflnamemem2;
	// hazardous pursuits radiobtn-mem1
	@FindBy(xpath = "(//input[contains(@name,'pursuits')])[3]")
	WebElement HPsyesbtnmem2;
	// hazardous pursuits details:mem1
	@FindBy(xpath = "(//strong[contains(.,'Hazardous Pursuits details:')])[2]")
	WebElement HPdtflnamemem2;
	// hazardous pursuits textbox:mem1
	@FindBy(xpath = "(//textarea[@name='hazardous_pursuits_details'])[2]")
	WebElement HPtextboxmem2;
	// International travel fieldname:mem1
	@FindBy(xpath = "(//strong[contains(.,'International Travel:')])[2]")
	WebElement ITflnamemem2;
	// International travel radiobtn-mem1
	@FindBy(xpath = "(//input[contains(@name,'travel')])[3]")
	WebElement ITradiobtnmem2;
	// International travel details fieldname:mem1
	@FindBy(xpath = "(//strong[contains(.,'International Travel details:')])[2]")
	WebElement ITdtflnamemem2;
	// International travel textbox:mem1
	@FindBy(css = "div.col-6:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > textarea:nth-child(2)")
	WebElement ITtextboxmem2;
	// previous btn
	@FindBy(xpath = "//button[@class='btn btn-warning'][contains(.,'Previous')]")
	WebElement prebtn;
	// Savebtn
	@FindBy(xpath = "(//button[@class='btn btn-primary'][contains(.,'Save')])[2]")
	WebElement savebtn;
	// Nextbtn
	@FindBy(xpath = "//button[@class='btn btn-default'][contains(.,'Next')]")
	WebElement nextbtn;

	// Initialising the page objects:
	public RiskPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	// Risktab
	public boolean ValidateRisktab() {
		return Risktab.isEnabled();
	}

	public String ValidateRiskheader() {
		return Riskheader.getText();
	}

	public String ValidateMem1header() {
		return Mem1header.getText();

	}

	public String ValidateMem2header() {
		return Mem2header.getText();

	}

	public String ValidateHPflmem1() {
		return HPflnamemem1.getText();

	}

	public String ValidateHPdtflnamemem1() {
		return HPdtflnamemem1.getText();
	}

	public String ValidateITflnamemem1() {
		return ITflnamemem1.getText();
	}

	public String ValidateITdtflnamemem1() {
		return ITdtflnamemem1.getText();
	}

	public String ValidateHPflnamemem2() {
		return HPflnamemem2.getText();
	}

	public String ValidateHPdtflnamemem2() {
		return HPdtflnamemem2.getText();

	}

	public String ValidateITflnamemem2() {
		return ITflnamemem2.getText();
	}

	public String ValidateITdtflnamemem2() {
		return ITdtflnamemem2.getText();
	}

	public OutgoingsPage ValidateRiskform() throws InterruptedException {
		HPsyesbtnmem1.click();
		HPtextboxmem1.sendKeys(TestUtil.generateRandomString(300));
		ITradiobtnmem1.click();
		Thread.sleep(3000);
		ITtextboxmem1.sendKeys(TestUtil.generateRandomString(300));
		savebtn.click();
		HPsyesbtnmem2.click();
		HPtextboxmem2.sendKeys(TestUtil.generateRandomString(300));
		ITradiobtnmem2.click();
		Thread.sleep(3000);
		ITtextboxmem2.sendKeys(TestUtil.generateRandomString(300));
		savebtn.click();
		nextbtn.click();
		return new OutgoingsPage();
	}
}
