package life4ctest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import life4ctests.GenerateData;

public class GetQuotes {
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
		// Quotes--level term
		driver.findElement(By.xpath("//a[contains(.,'Quotes')]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(.,'Get a new quote')]")).click();
		Select product = new Select(driver.findElement(
				By.cssSelector(".product-options > div:nth-child(1) > div:nth-child(1) > select:nth-child(2)")));
		product.selectByVisibleText("Level Term");
		Select Quotebasis = new Select(driver.findElement(
				By.cssSelector(".product-options > div:nth-child(1) > div:nth-child(2) > select:nth-child(2)")));
		Quotebasis.selectByVisibleText("Benefit");
		WebElement comm = driver.findElement(By.cssSelector("span.input-group > input:nth-child(2)"));
		comm.clear();
		comm.sendKeys("90");
		Select clientstoquotefor = new Select(
				driver.findElement(By.cssSelector("div.col-md:nth-child(4) > select:nth-child(2)")));
		clientstoquotefor.selectByValue("0");
		// term
		WebElement term = driver.findElement(By.cssSelector("input.form-control:nth-child(3)"));
		term.clear();
		term.sendKeys("60");
		// lifecover amount
		driver.findElement(
				By.cssSelector("div.row:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)"))
				.sendKeys("600000");
		// critical illness cover
		driver.findElement(
				By.cssSelector("div.row:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)"))
				.sendKeys("200000");
		// Accelerated
		Select accelerated = new Select(
				driver.findElement(By.cssSelector("div.row:nth-child(4) > div:nth-child(1) > select:nth-child(2)")));
		accelerated.selectByVisibleText("No");
		// submit
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(.,'Submit')]")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(.,'Get a new quote')]")).click();
		// Decreasing term
		product.selectByVisibleText("Decreasing Term");
		Quotebasis.selectByVisibleText("Benefit");
		comm.clear();
		comm.sendKeys("90");
		clientstoquotefor.selectByValue("1");
		WebElement term1 = driver.findElement(By.cssSelector("input.form-control:nth-child(3)"));
		term1.clear();
		term1.sendKeys("60");
		driver.findElement(
				By.cssSelector("div.row:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)"))
				.sendKeys("600000");
		// critical illness cover
		driver.findElement(
				By.cssSelector("div.row:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)"))
				.sendKeys("200000");
		Select accelerated1 = new Select(
				driver.findElement(By.cssSelector("div.row:nth-child(4) > div:nth-child(1) > select:nth-child(2)")));
		accelerated1.selectByVisibleText("No");
		WebElement loanamount = driver.findElement(
				By.cssSelector("div.row:nth-child(5) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)"));
		loanamount.clear();
		loanamount.sendKeys("270000");
		WebElement intrate = driver.findElement(
				By.cssSelector("div.row:nth-child(5) > div:nth-child(2) > div:nth-child(2) > input:nth-child(2)"));
		intrate.clear();
		intrate.sendKeys("2.09");
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][contains(.,'Submit')]")).click();

	}
}
