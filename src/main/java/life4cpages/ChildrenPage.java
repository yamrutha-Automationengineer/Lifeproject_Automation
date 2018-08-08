package life4cpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import life4cbase.TestBase;
import life4cutil.TestUtil;

public class ChildrenPage extends TestBase {

	// Page factory -Or;

	// children tab
	@FindBy(xpath = "//a[contains(.,'Children')]")
	WebElement chtab;

	// children header
	@FindBy(xpath = "//h3[contains(.,'Children')]")
	WebElement chheader;
	// add child header
	@FindBy(xpath = "//h4[contains(.,'Add child')]")
	WebElement addchheader;
	// name
	@FindBy(xpath = "//input[contains(@name,'name')]")
	WebElement chname;
	// Age
	@FindBy(xpath = "//input[contains(@name,'age')]")
	WebElement chage;
	// parents
	@FindBy(xpath = "(//input[contains(@name,'parents[]')])[1]")
	WebElement chparent1;
	@FindBy(xpath = "(//input[contains(@name,'parents[]')])[2]")
	WebElement chparent2;
	// add btn
	@FindBy(xpath = "//button[contains(.,'Add Child')]")
	WebElement chaddbtn;
	// pre btn
	@FindBy(xpath = "//button[@class='btn btn-warning'][contains(.,'Previous')]")
	WebElement prebtn;
	// next btn
	@FindBy(xpath = "//button[@class='btn btn-default'][contains(.,'Next')]")
	WebElement nextbtn;
	// addchild textbox
	@FindBy(xpath = "//td[contains(@class,'text-center')]")
	WebElement childdetails;

	public ChildrenPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean Validatechtab() {
		return chtab.isEnabled();
	}

	public String Validatechheader() {
		return chheader.getText();
	}

	public String ValidateAchheader() {
		return addchheader.getText();
	}

	public QuotesPage childrensform() {
		chname.sendKeys(TestUtil.generateRandomString(5));
		chage.sendKeys(TestUtil.generateRandomNumber(1));
		chparent1.click();
		chparent2.click();
		chaddbtn.click();
		boolean chdetails = childdetails.isDisplayed();
		System.out.println(chdetails);
		TestUtil.captureScreenShot("childrenpage", driver);
		nextbtn.click();
		return new QuotesPage();
	}
}
