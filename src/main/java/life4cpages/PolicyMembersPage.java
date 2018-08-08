package life4cpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import life4cbase.TestBase;
import life4cutil.TestUtil;

public class PolicyMembersPage extends TestBase {

	// Page factory -Or;
	// Policymembers tab to be enabled.
	@FindBy(xpath = "//a[contains(.,'Policy Members')]")
	WebElement policymemberstab;
	// member1 header
	@FindBy(xpath = "//h3[contains(.,'Member 1')]")
	WebElement member1header;
	// member2 header
	@FindBy(xpath = "//h3[contains(.,'Member 2')]")
	WebElement member2header;
	// Title-member1
	@FindBy(xpath = "(//select[@id='TitleSelector'])[1]")
	WebElement mem1title;
	// Firstname-mem1
	@FindBy(xpath = "(//input[@name='first_name'])[1]")
	WebElement mem1fnname;
	// Lastname-mem1
	@FindBy(xpath = "(//input[@name='last_name'])[1]")
	WebElement mem1lnname;
	// maritalstatus-mem1
	@FindBy(xpath = "(//select[contains(@id,'status')][@name='marital_status'])[1]")
	WebElement mem1martialst;
	// gender-mem1
	@FindBy(xpath = "(//select[contains(@id,'genderSelector')])[1]")
	WebElement mem1gender;
	// dob-mem1
	@FindBy(css = "body > div.container-fluid.h-100 > div > div > div > div > div > div.col-md-10 > div > div.policy-holder > div > div:nth-child(1) > div > div:nth-child(6) > div > div > div > div.react-datepicker-wrapper > div > input")
	WebElement mem1dob;
	// occupation-mem1
	@FindBy(xpath = "//div[contains(@class,'Select-placeholder')]")
	WebElement mem1occupation;
	// telephone-mem1
	@FindBy(xpath = "(//input[@id='telephone'])[1]")
	WebElement mem1telephone;
	// email-mem1
	@FindBy(xpath = "(//input[contains(@name,'email')])[1]")
	WebElement mem1email;
	// Heightft-mem1
	@FindBy(xpath = "(//input[@placeholder='ft'])[1]")
	WebElement mem1heightft;
	// HeightIn-mem1
	@FindBy(xpath = "(//input[@placeholder='in'])[1]")
	WebElement mem1heightIn;
	// Weightst-mem1
	@FindBy(xpath = "(//input[@placeholder='st'])[1]")
	WebElement mem1weightst;
	// weightlb-mem1
	@FindBy(xpath = "(//input[@placeholder='lb'])[1]")
	WebElement mem1weightlb;
	// smoker
	@FindBy(xpath = "(//button[@name='smoker'])[2]")
	WebElement mem1smoker;
	// save
	@FindBy(css = "div.text-center:nth-child(2) > button:nth-child(1)")
	WebElement savebtn;
	// next
	@FindBy(xpath = "//button[@class='btn btn-default'][contains(.,'Next')]")
	WebElement nextbtn;
	// Mem2
	@FindBy(xpath = "(//select[@id='TitleSelector'])[2]")
	WebElement mem2title;
	// Firstname-mem2
	@FindBy(xpath = "(//input[@name='first_name'])[2]")
	WebElement mem2fnname;
	// Lastname-mem2
	@FindBy(xpath = "(//input[@name='last_name'])[2]")
	WebElement mem2lnname;
	// maritalstatus-mem2
	@FindBy(xpath = "(//select[contains(@id,'status')][@name='marital_status'])[2]")
	WebElement mem2martialst;
	// gender-mem2
	@FindBy(xpath = "(//select[contains(@id,'genderSelector')])[2]")
	WebElement mem2gender;
	// dob-mem2
	@FindBy(css = "div.col-md-6:nth-child(2) > div:nth-child(3) > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
	WebElement mem2dob;
	// occupation-mem2
	@FindBy(css = ".Select-placeholder")
	WebElement mem2occupation;
	// telephone-mem2
	@FindBy(xpath = "(//input[@id='telephone'])[2]")
	WebElement mem2telephone;
	// email-mem2
	@FindBy(xpath = "(//input[contains(@name,'email')])[2]")
	WebElement mem2email;
	// Heightft-mem2
	@FindBy(xpath = "(//input[@placeholder='ft'])[2]")
	WebElement mem2heightft;
	// HeightIn-mem2
	@FindBy(xpath = "(//input[@placeholder='in'])[2]")
	WebElement mem2heightIn;
	// Weightst-mem2
	@FindBy(xpath = "(//input[@placeholder='st'])[2]")
	WebElement mem2weightst;
	// weightlb-mem2
	@FindBy(xpath = "(//input[@placeholder='lb'])[2]")
	WebElement mem2weightlb;
	// smoker
	@FindBy(xpath = "(//button[@name='smoker'])[4]")
	WebElement mem2smoker;
	// Initializing the page objects:

	public PolicyMembersPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean validatePMtab() {
		return policymemberstab.isEnabled();
	}

	public String valmem1header() {
		return member1header.getText();

	}

	public String valmem2header() {
		return member2header.getText();
	}

	public HealthPage mem1form() throws Exception {
		Thread.sleep(2000);
		Select mem1tt = new Select(mem1title);
		mem1tt.selectByVisibleText("Mr");
		mem1fnname.sendKeys(TestUtil.generateRandomString(5));
		mem1lnname.sendKeys(TestUtil.generateRandomString(3) + "test");
		Select mem1MS = new Select(mem1martialst);
		mem1MS.selectByVisibleText("Married");
		Select mem1GN = new Select(mem1gender);
		mem1GN.selectByVisibleText("Male");
		mem1dob.click();
		mem1dob.sendKeys(Keys.CONTROL + "a");
		mem1dob.sendKeys(Keys.DELETE);

		mem1dob.sendKeys("12/03/1975");

		mem1dob.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(mem1occupation);
		actions.click();

		actions.sendKeys("Account Executive");

		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
		mem1telephone.sendKeys("078" + TestUtil.generateRandomNumber(7));
		mem1email.sendKeys("test" + TestUtil.generateEmail(10));
		mem1heightft.sendKeys("5");
		mem1heightIn.sendKeys("5");
		mem1weightst.sendKeys("60");
		mem1weightlb.sendKeys("5");
		mem1smoker.click();
		savebtn.click();
		Thread.sleep(2000);
		Select mem2tt = new Select(mem2title);
		mem2tt.selectByVisibleText("Mrs");
		mem2fnname.sendKeys(TestUtil.generateRandomString(5));
		mem2lnname.sendKeys(TestUtil.generateRandomString(3) + "test");
		Select mem2MS = new Select(mem2martialst);
		mem2MS.selectByVisibleText("Married");
		Select mem2GN = new Select(mem2gender);
		mem2GN.selectByVisibleText("Female");
		mem2dob.click();
		mem2dob.sendKeys(Keys.CONTROL + "a");
		mem2dob.sendKeys(Keys.DELETE);

		mem2dob.sendKeys("10/25/1978");

		mem2dob.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(mem2occupation);
		actions1.click();

		actions1.sendKeys("Fashion Stylist");

		actions1.sendKeys(Keys.ENTER);
		actions1.build().perform();
		mem2telephone.sendKeys("078" + TestUtil.generateRandomNumber(7));
		mem2email.sendKeys("test" + TestUtil.generateEmail(10));
		mem2heightft.sendKeys("5");
		mem2heightIn.sendKeys("5");
		mem2weightst.sendKeys("60");
		mem2weightlb.sendKeys("5");
		mem2smoker.click();
		savebtn.click();
		TestUtil.captureScreenShot("PolicyMemberspage", driver);
		nextbtn.click();
		return new HealthPage();
	}
}
