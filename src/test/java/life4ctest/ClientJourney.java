package life4ctest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import life4ctests.GenerateData;
import life4ctests.Utility;

public class ClientJourney {
	WebDriver driver;
	GenerateData genData;

	@BeforeTest
	public void setUp() throws InterruptedException {
		// to run Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Amruta.Yembuluru\\driver\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		genData = new GenerateData();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.get("https://login.4cplus-staging.uk");
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("amruta.yembuluru@usaycompare.com");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		pwd.sendKeys("secret");
		driver.findElement(By.id("signInButton")).click();
	}

	@Test
	public void newclientjourney() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(
				"body > div > div > div > div.row.w-75.justify-content-start.mb-3 > div > div > div > div > div.col > h3"))
				.click();
		// new Select(driver.findElement(By.cssSelector("#clients-dashboard >
		// div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) >
		// div:nth-child(2) > span:nth-child(2) >
		// select:nth-child(1)"))).selectByValue("50");

		// driver.findElement(By.xpath("(//button[contains(@class,'btn btn-sm
		// btn-primary')])[1]")).click();
		driver.findElement(By.id("Life Insurance")).click();
		driver.findElement(By.xpath("//a[contains(.,'New Journey')]")).click();
		// Member 1
		// title
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath("(//select[@id='TitleSelector'])[1]"))).selectByVisibleText("Mr");
		// firstname
		WebElement fnname = driver.findElement(By.xpath("(//input[contains(@id,'first_name')])[1]"));
		fnname.clear();
		fnname.sendKeys(genData.generateRandomString(5));
		Thread.sleep(3000);
		// Lastname
		WebElement lnname = driver.findElement(By.id("last_name"));
		lnname.clear();
		lnname.sendKeys(genData.generateRandomString(4) + "test");
		// Martial Status
		new Select(driver.findElement(By.id("marital_status"))).selectByVisibleText("Married");
		// Gender
		new Select(driver.findElement(By.id("genderSelector"))).selectByVisibleText("Male");
		// DOB
		Thread.sleep(1000);
		WebElement dob = driver.findElement(By.cssSelector(
				"body > div.container-fluid.h-100 > div > div > div > div > div > div.col-md-10 > div > div.policy-holder > div > div:nth-child(1) > div > div:nth-child(6) > div > div > div > div.react-datepicker-wrapper > div > input"));
		dob.click();
		dob.sendKeys(Keys.CONTROL + "a");
		dob.sendKeys(Keys.DELETE);

		dob.sendKeys("12/03/1975");

		dob.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// Occupation
		WebElement occupation = driver.findElement(By.xpath("//div[contains(@class,'Select-placeholder')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(occupation);
		actions.click();

		actions.sendKeys("Account Executive");

		actions.sendKeys(Keys.ENTER);
		actions.build().perform();

		// Telephone

		WebElement tel = driver.findElement(By.id("telephone"));
		tel.clear();
		tel.sendKeys("078" + genData.generateRandomNumber(7));
		// Email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("mem1" + genData.generateEmail(15));
		// Height
		driver.findElement(By.xpath("(//input[contains(@placeholder,'ft')])")).sendKeys("5");
		driver.findElement(By.xpath("(//input[contains(@placeholder,'st')])")).sendKeys("55");
		driver.findElement(By.xpath("(//button[@type='button'][contains(.,'Yes')])[1]")).click();
		// postcode

		/****
		 * WebElement
		 * postcode=driver.findElement(By.xpath("//input[contains(@placeholder,'Address
		 * postcode')]")); postcode.clear(); postcode.sendKeys("sn3 1aa");
		 * Thread.sleep(2000); driver.findElement(By.cssSelector("body >
		 * div.container-fluid.h-100 > div > div > div > div > div > div.col-md-10 > div
		 * > div.policy-holder > div > div:nth-child(1) > div > div:nth-child(15) >
		 * div.form-group.row > div > div > div > div > button")).click(); WebElement
		 * chooseadd=driver.findElement(By.cssSelector("body > div.container-fluid.h-100
		 * > div > div > div > div > div > div.col-md-10 > div > div.policy-holder > div
		 * > div:nth-child(1) > div > div:nth-child(15) > div.form-group.row.mb-5 > div
		 * > select")); chooseadd.click(); chooseadd.sendKeys(Keys.ARROW_DOWN);
		 * chooseadd.sendKeys(Keys.ENTER);
		 ****/
		// save
		driver.findElement(By.cssSelector("div.text-center:nth-child(2) > button:nth-child(1)")).click();
		// Member 2
		driver.findElement(By.cssSelector(
				"div.col-md-6:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > select:nth-child(1)"))
				.sendKeys("Mrs");
		driver.findElement(By.xpath("(//input[contains(@id,'name')][@name='first_name'])[2]"))
				.sendKeys(genData.generateRandomString(6));
		driver.findElement(By.xpath("(//input[contains(@id,'name')][@name='last_name'])[2]"))
				.sendKeys(genData.generateRandomString(6));
		new Select(driver.findElement(By.xpath("(//select[contains(@id,'status')][@name='marital_status'])[2]")))
				.selectByVisibleText("Married");
		new Select(driver.findElement(By.xpath("(//select[contains(@id,'genderSelector')])[2]")))
				.selectByVisibleText("Female");
		Thread.sleep(1000);
		WebElement dob2 = driver.findElement(By.cssSelector(
				"div.col-md-6:nth-child(2) > div:nth-child(3) > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"));
		dob2.click();
		dob2.sendKeys(Keys.CONTROL + "a");
		dob2.sendKeys(Keys.DELETE);

		dob2.sendKeys("12/03/1972");

		dob2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// Occupation
		WebElement occupation2 = driver.findElement(By.cssSelector(".Select-placeholder"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(occupation2);
		actions2.click();

		actions2.sendKeys("Fashion Stylist");

		actions2.sendKeys(Keys.ENTER);
		actions2.build().perform();
		// Telephone

		WebElement tel2 = driver.findElement(By.xpath("(//input[contains(@id,'telephone')])[2]"));
		tel2.clear();
		tel2.sendKeys("078" + genData.generateRandomNumber(7));
		// Email
		WebElement email2 = driver.findElement(By.xpath("(//input[contains(@id,'email')])[2]"));
		email2.clear();
		email2.sendKeys(genData.generateEmail(15));
		// Height
		driver.findElement(By.xpath("(//input[contains(@placeholder,'ft')])[2]")).sendKeys("5");
		driver.findElement(By.xpath("(//input[contains(@placeholder,'st')])[2]")).sendKeys("50");
		driver.findElement(By.xpath("(//button[@type='button'][contains(.,'Yes')])[2]")).click();
		// postcode

		/***
		 * WebElement
		 * postcode2=driver.findElement(By.xpath("(//input[contains(@placeholder,'Address
		 * postcode')])[2]")); postcode2.clear(); postcode2.sendKeys("sn3 1aa");
		 * Thread.sleep(2000); driver.findElement(By.xpath("(//button[@class='btn
		 * btn-primary active'][contains(.,'Find Address')])[2]")).click(); WebElement
		 * chooseadd2=driver.findElement(By.cssSelector(".mb-5 > div:nth-child(2) >
		 * select:nth-child(1)")); chooseadd2.click();
		 * chooseadd2.sendKeys(Keys.ARROW_DOWN); chooseadd2.sendKeys(Keys.ENTER);
		 * Utility.scrollPageDown(driver);
		 ***/
		// save

		driver.findElement(By.cssSelector("div.text-center:nth-child(2) > button:nth-child(1)")).click();

		// next
		driver.findElement(By.xpath("//button[@class='btn btn-default'][contains(.,'Next')]")).click();

		// Health
		driver.findElement(By.xpath("(//textarea[contains(@name,'health_issues')])[1]"))
				.sendKeys(genData.generateRandomString(100));
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(
				"div.col-6:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > textarea:nth-child(2)"))
				.sendKeys(genData.generateRandomString(100));
		// save
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'][contains(.,'Save')])[2]")).click();
		// next
		driver.findElement(By.xpath("//button[@class='btn btn-default'][contains(.,'Next')]")).click();
		Thread.sleep(2000);
		// -----------------------------------------//
		// Mortgage
		driver.findElement(By.xpath("(//input[contains(@type,'radio')])[1]")).click();
		driver.findElement(By.xpath("(//input[contains(@id,'type3')])[1]")).click();
		driver.findElement(By.xpath("(//input[contains(@name,'outstanding_amount')])[1]")).sendKeys("278000");
		driver.findElement(By.xpath("(//input[contains(@name,'outstanding_term')])[1]")).sendKeys("24");
		driver.findElement(By.xpath("(//input[contains(@name,'monthly_repayment')])[1]")).sendKeys("950");
		// mortgagemem2

		driver.findElement(By.xpath("(//input[contains(@type,'radio')])[5]")).click();
		driver.findElement(By.xpath("(//input[contains(@id,'type3')])[2]")).click();
		driver.findElement(By.xpath("(//input[contains(@name,'outstanding_amount')])[2]")).sendKeys("278000");
		driver.findElement(By.xpath("(//input[contains(@name,'outstanding_term')])[2]")).sendKeys("24");
		driver.findElement(By.xpath("(//input[contains(@name,'monthly_repayment')])[2]")).sendKeys("950");

		// save
		driver.findElement(By.xpath("(//button[contains(@class,'btn btn-primary')])[5]")).click();
		// next
		driver.findElement(By.xpath("//button[@class='btn btn-default'][contains(.,'Next')]")).click();
		// ------------------------------------//
		// Occupation
		/****
		 * Thread.sleep(3000);
		 * driver.findElement(By.xpath("//a[contains(.,'occupation')]")).click();
		 ***/
		// member1
		// Employment status
		new Select(driver.findElement(By.cssSelector(
				"div.col-6:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > select:nth-child(2)")))
						.selectByVisibleText("Contractor");
		// Death-in-service
		new Select(driver.findElement(By.cssSelector(
				"div.col-6:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > select:nth-child(2)")))
						.selectByValue("15");
		// Full sick pay
		new Select(driver.findElement(By.cssSelector(
				"div.col-6:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > select:nth-child(2)")))
						.selectByVisibleText("3 months");
		// Half sick pay
		new Select(driver.findElement(By.cssSelector(
				"div.col-6:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > select:nth-child(2)")))
						.selectByVisibleText("6 months");
		// salary
		driver.findElement(By.cssSelector(
				"div.col-6:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > input:nth-child(2)"))
				.sendKeys("40000");
		// Bonus/commission
		driver.findElement(By.xpath("(//input[@name='bonus_commission'])[1]")).sendKeys("4");
		// Other income
		driver.findElement(By.xpath("(//input[@name='other_income'])[1]")).sendKeys("10000");
		// Retirement age:
		driver.findElement(By.xpath("(//input[@name='retirement_age'])[1]")).sendKeys("60");

		// member2
		// Employment status
		new Select(driver.findElement(By.cssSelector(
				"div.col-6:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > select:nth-child(2)")))
						.selectByVisibleText("Employed Part-time");
		// Death-in-servce
		new Select(driver.findElement(By.cssSelector(
				"div.col-6:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > select:nth-child(2)")))
						.selectByValue("15");
		// Full sick pay
		new Select(driver.findElement(By.cssSelector(
				"div.col-6:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > select:nth-child(2)")))
						.selectByVisibleText("3 months");
		// Half sick pay
		new Select(driver.findElement(By.cssSelector(
				"div.col-6:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > select:nth-child(2)")))
						.selectByVisibleText("6 months");
		// salary
		driver.findElement(By.cssSelector(
				"div.col-6:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > input:nth-child(2)"))
				.sendKeys("40000");
		// Bonus/commission
		driver.findElement(By.xpath("(//input[@name='bonus_commission'])[2]")).sendKeys("4");
		// Other income
		driver.findElement(By.xpath("(//input[@name='other_income'])[2]")).sendKeys("10000");
		// Retirement age:
		driver.findElement(By.xpath("(//input[@name='retirement_age'])[2]")).sendKeys("60");

		// save
		driver.findElement(By.cssSelector("div.text-center:nth-child(2) > button:nth-child(1)")).click();
		driver.navigate().refresh();
		// next

		driver.findElement(By.xpath("//button[@class='btn btn-default'][contains(.,'Next')]")).click();

		driver.findElement(By.xpath("(//textarea[contains(@name,'hazardous_pursuits_details')])[1]"))
				.sendKeys(genData.generateRandomString(100));
		// International Travel

		driver.findElement(By.xpath("(//input[contains(@name,'travel')])[1]")).click();
		driver.findElement(By.xpath("(//textarea[@name='international_travel_details'])[1]"))
				.sendKeys(genData.generateRandomString(100));

		// member2

		driver.findElement(By.xpath("(//input[contains(@name,'pursuits')])[3]")).click();
		driver.findElement(By.xpath("(//textarea[contains(@name,'hazardous_pursuits_details')])[2]"))
				.sendKeys(genData.generateRandomString(100));
		// International Travel

		driver.findElement(By.xpath("(//input[contains(@name,'travel')])[3]")).click();
		driver.findElement(By.xpath("(//textarea[@name='international_travel_details'])[2]"))
				.sendKeys(genData.generateRandomString(100));

		// save
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'][contains(.,'Save')])[2]")).click();
		// next
		driver.findElement(By.xpath("//button[@class='btn btn-default'][contains(.,'Next')]")).click();
		// OUTGOINgs
		// member1
		driver.findElement(By.xpath("(//input[@name='house_outgoings'])[1]")).sendKeys("2000");
		driver.findElement(By.xpath("(//input[@name='bills_outgoings'])[1]")).sendKeys("1000");
		driver.findElement(By.xpath("(//input[@name='car_outgoings'])[1]")).sendKeys("500");
		driver.findElement(By.xpath("(//input[@name='loan_outgoings'])[1]")).sendKeys("5000");
		driver.findElement(By.xpath("(//input[@name='savings_outgoings'])[1]")).sendKeys("1000");
		driver.findElement(By.xpath("(//input[@name='other_outgoings'])[1]")).sendKeys("500");
		driver.findElement(By.xpath("(//input[@name='total_outgoings'])[1]")).sendKeys("5000");
		driver.findElement(By.xpath("(//input[@name='budget_outgoings'])[1]")).sendKeys("100");
		// member2
		driver.findElement(By.xpath("(//input[@name='house_outgoings'])[2]")).sendKeys("2000");
		driver.findElement(By.xpath("(//input[@name='bills_outgoings'])[2]")).sendKeys("1000");
		driver.findElement(By.xpath("(//input[@name='car_outgoings'])[2]")).sendKeys("500");
		driver.findElement(By.xpath("(//input[@name='loan_outgoings'])[2]")).sendKeys("5000");
		driver.findElement(By.xpath("(//input[@name='savings_outgoings'])[2]")).sendKeys("1000");
		driver.findElement(By.xpath("(//input[@name='other_outgoings'])[2]")).sendKeys("500");
		driver.findElement(By.xpath("(//input[@name='total_outgoings'])[2]")).sendKeys("5000");
		driver.findElement(By.xpath("(//input[@name='budget_outgoings'])[2]")).sendKeys("100");
		// save
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'][contains(.,'Save')])[2]")).click();
		Thread.sleep(2000);

		// next
		WebDriverWait wait111 = new WebDriverWait(driver, 10);
		WebElement element111 = wait111.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='btn btn-default'][contains(.,'Next')]")));
		element111.click();

		// ADD Existing Policy
		new Select(driver.findElement(By.xpath("//select[contains(@name,'type')]"))).selectByVisibleText("PMI");
		driver.findElement(By.xpath("//input[contains(@name,'premium')]")).sendKeys("78");
		driver.findElement(By.xpath("//button[@type='button'][contains(.,'Yes')]")).click();
		driver.findElement(By.xpath("(//input[contains(@type,'checkbox')])[1]")).click();
		driver.findElement(By.xpath("(//input[contains(@type,'checkbox')])[2]")).click();
		driver.findElement(By.xpath("//input[@name='insurer']")).sendKeys("VitalityHealth");
		driver.findElement(By.xpath("//input[contains(@name,'sum_assured')]")).sendKeys("500000");
		driver.findElement(By.xpath("//input[contains(@name,'term')]")).sendKeys("30");
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(.,'Add Policy')]")).click();
		Thread.sleep(6000);
		Utility.captureScreenShot("Existingpolicy", driver);
		driver.findElement(By.xpath("//button[@class='btn btn-default'][contains(.,'Next')]")).click();
		// ADD CHIld
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(genData.generateRandomString(7));
		driver.findElement(By.xpath("//input[@name='age']")).sendKeys(genData.generateRandomNumber(1));
		driver.findElement(By.xpath("(//input[@name='parents[]'])[1]")).click();
		driver.findElement(By.xpath("(//input[@name='parents[]'])[2]")).click();
		// add child button

		driver.findElement(By.xpath("//button[contains(.,'Add Child')]")).click();
		Thread.sleep(6000);
		// next
		driver.findElement(By.xpath("//button[@class='btn btn-default'][contains(.,'Next')]")).click();

		// Quotes

		// Get a New quote

		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(.,'Get a new quote')]")).click();

		// product
		new Select(driver.findElement(
				By.cssSelector(".product-options > div:nth-child(1) > div:nth-child(1) > select:nth-child(2)")))
						.selectByVisibleText("Whole of Life");
		// Quote basis
		new Select(driver.findElement(By.cssSelector("div.col-md:nth-child(2) > select:nth-child(2)")))
				.selectByVisibleText("Benefit");
		// Initial commission
		WebElement Inicommission = driver.findElement(By.xpath("//input[contains(@value,'100')]"));
		Inicommission.clear();
		Inicommission.sendKeys("80");
		// Clients to quote for
		new Select(driver.findElement(By.cssSelector("div.col-md:nth-child(4) > select:nth-child(2)")))
				.selectByValue("1");
		// Lump sum amount
		WebElement lumpsumamount = driver.findElement(By.cssSelector("div.input-group > input:nth-child(2)"));
		lumpsumamount.clear();
		lumpsumamount.sendKeys("500000");
		// Submit
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(.,'Submit')]")).click();
		// Screenshot
		Thread.sleep(6000);
		Utility.captureScreenShot("Wholeoflife", driver);
		Utility.scrollPageDown(driver);

	}

	/***
	 * @AfterMethod public void teardown() { driver.quit(); }
	 **/
}
