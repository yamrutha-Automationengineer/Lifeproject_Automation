package life4cpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import life4cbase.TestBase;

public class AppsPage extends TestBase {

	// Page factory -Or;
	// user
	@FindBy(xpath = "//div[@id='user']")
	WebElement user;
	// logo
	@FindBy(xpath = "//img[contains(@alt,'Usay Compare')]")
	WebElement img;
	// your 4c dashboard text

	@FindBy(xpath = "//h1[contains(.,'Your 4C Dashboard.')]")
	WebElement text;

	// life insurance
	@FindBy(xpath = "//h3[@class='card-title'][contains(.,'Life Insurance')]")
	WebElement lifeinsurancebtn;

	// signoutbtn
	@FindBy(xpath = "//h3[@class='card-title'][contains(.,'Sign Out')]")
	WebElement signoutbtn;

	// Initializing the page objects:

	public AppsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateuser() {
		return user.getText();

	}

	public boolean validateUCimg() {
		return img.isDisplayed();
	}

	public String validate4cdashboardtext() {
		return text.getText();
	}

	public Dashboardpage lifeinsurance() {

		lifeinsurancebtn.click();
		return new Dashboardpage();
	}

	public LoginPage signout() {
		signoutbtn.click();
		return new LoginPage();
	}

}
