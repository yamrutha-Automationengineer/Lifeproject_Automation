package life4cpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import life4cbase.TestBase;
import life4cutil.TestUtil;

public class LoginPage extends TestBase {

	// Page factory -Or;
	// email
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	// password
	@FindBy(xpath = "//input[@id='password']")
	WebElement pwd;

	// sighinbutton
	@FindBy(id = "signInButton")
	WebElement signinbtn;

	// logo
	@FindBy(xpath = "//img[@id='logo']")
	WebElement logo;

	@FindBy(xpath = "//h1[contains(.,'Sign in to 4C to begin.')]")
	WebElement text;

	// Initializing the page objects:

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPagetitle() {
		return driver.getTitle();
	}

	public boolean validateUClogo() throws InterruptedException {
		Thread.sleep(3000);
		return logo.isDisplayed();

	}

	public boolean signintotext() {

		return text.isDisplayed();
	}

	public AppsPage login(String el, String pd) throws InterruptedException {
		email.sendKeys(el);
		pwd.sendKeys(pd);
		signinbtn.click();
		Thread.sleep(3000);
		return new AppsPage();
	}

	public static void screenshot() throws InterruptedException {
		Thread.sleep(3000);
		TestUtil.captureScreenShot("LoginPage", driver);
	}
}
