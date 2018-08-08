package life4cpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import life4cbase.TestBase;
import life4cutil.TestUtil;

public class OccupationPage extends TestBase {

	// Page factory -Or;
	// occupationtab
	@FindBy(xpath = "//a[@href='#/occupation'][contains(.,'occupation')]")
	WebElement occupationtab;
	// occupationheader
	@FindBy(xpath = "//h3[contains(.,'occupation')]")
	WebElement occupationheader;
	// occupationof mem1
	@FindBy(xpath = "(//strong[contains(.,'Occupation:')])[1]")
	WebElement occupationmem1;
	// employment status-mem1
	@FindBy(css = "div.col-6:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > select:nth-child(2)")
	WebElement Empstmem1;
	// Deathinservice-mem1
	@FindBy(css = "div.col-6:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > select:nth-child(2)")
	WebElement Deathinservicemem1;
	// Full sickpay-mem1
	@FindBy(css = "div.col-6:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > select:nth-child(2)")
	WebElement Fullsickpaymem1;
	// HAlfsickpay-mem1
	@FindBy(css = "div.col-6:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > select:nth-child(2)")
	WebElement Halfsickpaymem1;
	// salary-mem1
	@FindBy(xpath = "(//input[contains(@name,'salary_net')])[1]")
	WebElement Salarymem1;
	// Bonus Commission-mem1
	@FindBy(xpath = "(//input[@name='bonus_commission'])[1]")
	WebElement Bonuscmmmem1;
	// Other income-mem1
	@FindBy(xpath = "(//input[@name='other_income'])[1]")
	WebElement Otherincmem1;
	// Retirementage-mem1
	@FindBy(xpath = "(//input[@name='retirement_age'])[1]")
	WebElement Retagemem1;
	// savebtn
	@FindBy(xpath = "(//button[@class='btn btn-primary'][contains(.,'Save')])[2]")
	WebElement savebtn;
	// employment status-mem2
	@FindBy(css = "div.col-6:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > select:nth-child(2)")
	WebElement Empstmem2;
	// Deathinservice-mem2
	@FindBy(css = "div.col-6:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > select:nth-child(2)")
	WebElement Deathinservicemem2;
	// Full sickpay-mem2
	@FindBy(css = "div.col-6:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > select:nth-child(2)")
	WebElement Fullsickpaymem2;
	// HAlfsickpay-mem2
	@FindBy(css = "div.col-6:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > select:nth-child(2)")
	WebElement Halfsickpaymem2;
	// salary-mem2
	@FindBy(xpath = "(//input[contains(@name,'salary_net')])[2]")
	WebElement Salarymem2;
	// Bonus Commission-mem2
	@FindBy(xpath = "(//input[@name='bonus_commission'])[2]")
	WebElement Bonuscmmmem2;
	// Other income-mem2
	@FindBy(xpath = "(//input[@name='other_income'])[2]")
	WebElement Otherincmem2;
	// Retirementage-mem2
	@FindBy(xpath = "(//input[@name='retirement_age'])[2]")
	WebElement Retagemem2;
	// nextbtn
	@FindBy(xpath = "//button[@class='btn btn-default'][contains(.,'Next')]")
	WebElement nextbtn;

	// Initialising the page objects:
	public OccupationPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean validateOccupationtab() {
		return occupationtab.isEnabled();
	}

	public String valOccheader() {

		return occupationheader.getText();
	}

	public String valOccmem1() {

		return occupationmem1.getText();
	}

	public RiskPage Occupationform() throws Exception {
		Thread.sleep(2000);
		Select Mem1Empst = new Select(Empstmem1);
		Mem1Empst.selectByVisibleText("Contractor");
		Select Mem1Deathinservice = new Select(Deathinservicemem1);
		Mem1Deathinservice.selectByValue("15");
		Thread.sleep(3000);
		Select Mem1Fullsickpay = new Select(Fullsickpaymem1);
		Mem1Fullsickpay.selectByVisibleText("3 months");
		Select Mem1halfsickpay = new Select(Halfsickpaymem1);
		Mem1halfsickpay.selectByVisibleText("6 months");
		Thread.sleep(2000);
		Salarymem1.sendKeys("45000");
		Bonuscmmmem1.sendKeys("5");
		Otherincmem1.sendKeys("5000");
		Retagemem1.sendKeys("60");
		savebtn.click();
		Thread.sleep(3000);
		Select Mem2Empst = new Select(Empstmem2);
		Mem2Empst.selectByVisibleText("Employed Part-time");
		Select Mem2Deathinservice = new Select(Deathinservicemem2);
		Mem2Deathinservice.selectByValue("15");
		Thread.sleep(3000);
		Select Mem2Fullsickpay = new Select(Fullsickpaymem2);
		Mem2Fullsickpay.selectByVisibleText("3 months");
		Select Mem2halfsickpay = new Select(Halfsickpaymem2);
		Mem2halfsickpay.selectByVisibleText("6 months");
		Salarymem2.sendKeys("30000");
		Bonuscmmmem2.sendKeys("2");
		Otherincmem2.sendKeys("2000");
		Retagemem2.sendKeys("60");
		savebtn.click();
		TestUtil.captureScreenShot("OccupationPage", driver);
		driver.navigate().refresh();
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		WebElement element1 = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='btn btn-default'][contains(.,'Next')]")));
		element1.click();
		return new RiskPage();

	}
}
