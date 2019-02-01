package com.utest.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.utest.testBase.Base;

public class RegistrationPage {

	public WebDriver driver;

	public static final Logger log = Logger.getLogger(RegistrationPage.class.getName());

	SoftAssert assertion = new SoftAssert();

	Base base = new Base();

	@FindBy(xpath = ".//a[contains(text(),'Sign Up For Free')]")
	private WebElement signUp;

	@FindBy(xpath = ".//input[@name='firstName']")
	private WebElement firstName;

	@FindBy(xpath = ".//input[@name='lastName']")
	private WebElement lastName;

	@FindBy(xpath = ".//input[@name='email']")
	private WebElement emailID;

	@FindBy(xpath = ".//span[contains(text(),'Email already registered')]")
	private WebElement emailExist;

	@FindBy(xpath = ".//span[contains(text(),'Month')]")
	private WebElement clickOnMonth;

	@FindBy(xpath = ".//ul//li//div//div")
	private List<WebElement> selectMonth;

	@FindBy(xpath = ".//span[contains(text(),'Day')]")
	private WebElement clickOnDay;

	@FindBy(xpath = ".//ul//li//div//div")
	private List<WebElement> selectDay;

	@FindBy(xpath = ".//span[contains(text(),'Year')]")
	private WebElement clickOnYear;

	@FindBy(xpath = ".//ul//li//div//div")
	private List<WebElement> selectYear;

	@FindBy(xpath = ".//span[contains(text(),'Select a gender')]")
	private WebElement clickOnGender;

	@FindBy(xpath = ".//ul//li//div//div")
	private List<WebElement> selectGender;

	/*
	 * @FindBy(xpath =
	 * ".//label[contains(text(),'Languages (spoken):')]//following::input[@type='search']"
	 * ) WebElement clickOnLanguage;
	 */
	/*
	 * @FindBy(xpath = ".//ul//li//div//div") List<WebElement> selectLanguage;
	 */

	@FindBy(xpath = ".//span[contains(text(),'Next: Location')]")
	private WebElement clickNext;

	@FindBy(xpath = ".//input[@placeholder='Enter a location']")
	WebElement enterLocation;

	@FindBy(xpath = ".//input[@id='zip']")
	WebElement enterZip;

	@FindBy(xpath = ".//span[contains(text(),'Select a country')]")
	WebElement clickOnContry;

	@FindBy(xpath = ".//ul//li//div//div")
	List<WebElement> selectCountry;

	@FindBy(xpath = ".//span[contains(text(),'Step 2: ')]")
	private WebElement step2;

	@FindBy(xpath = ".//span[contains(text(),'Next: Devices')]")
	private WebElement clickOnNextDevice;

	@FindBy(xpath = ".//span[contains(text(),'Next: Last Step')]")
	private WebElement clickOnLastStep;

	@FindBy(xpath = ".//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = ".//input[@name='confirmPassword']")
	private WebElement confirmPassword;

	@FindBy(xpath = ".//preceding::span[@class='checkmark signup-consent__checkbox']")
	private WebElement uTestTermsUseCheck;

	@FindBy(xpath = ".//preceding::span[@class='checkmark signup-consent__checkbox error']")
	private WebElement privacyAndSecurity;

	@FindBy(xpath = ".//span[contains(text(),'Complete Setup')]")
	private WebElement completeSetUp;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void tellUsAboutYourself() {

		base.waitUntilElementToBeVisible(driver, signUp);
		signUp.click();
		log.info("Clicked on Signup button from the home page\n");

		base.waitUntilElementToBeVisible(driver, firstName);
		firstName.sendKeys("Bahubali");
		log.info("Entered User Name : " + firstName);

		base.waitUntilElementToBeVisible(driver, lastName);
		lastName.sendKeys("Jain");
		log.info("Entered Last Name : " + lastName);

		base.waitUntilElementToBeVisible(driver, emailID);
		emailID.sendKeys("bahubalipr.cse009@gmail.com");
		log.info("Entered Email Address : " + emailID + "\n");

		/*
		 * String emailText = emailExist.getText();
		 * 
		 * if (emailExist.isDisplayed()) { assertion.assertNotEquals(emailText,
		 * "Email already registered",
		 * "The Entered Email ID is aleady registered by other user.");
		 * 
		 * }
		 */

		base.waitUntilElementToBeVisible(driver, clickOnMonth);
		clickOnMonth.click();
		selectMonth.get(3).click();
		log.info("Selected Month");

		base.waitUntilElementToBeVisible(driver, clickOnDay);
		clickOnDay.click();
		selectDay.get(24).click();
		log.info("Selected Day");

		base.waitUntilElementToBeVisible(driver, clickOnYear);
		clickOnYear.click();
		selectYear.get(10).click();
		log.info("Selected Year\n");

		base.waitUntilElementToBeVisible(driver, clickOnGender);
		clickOnGender.click();
		selectGender.get(1).click();
		log.info("Selected Gender\n");

		base.waitUntilElementToBeVisible(driver, clickNext);
		clickNext.click();
		log.info("Clicked On Next Location Button\n");

		/*
		 * Thread.sleep(1000); clickOnLanguage.click();
		 * selectLanguage.get(9).click();
		 * 
		 */
	}

	public void addYourAddress() throws InterruptedException {

		Thread.sleep(5000);
		// base.waitUntilElementToBeVisible(driver, enterLocation);
		enterLocation.clear();
		enterLocation.sendKeys("Bengaluru");
		log.info("Entered Location.");

		base.waitUntilElementToBeVisible(driver, enterZip);
		enterZip.clear();
		enterZip.sendKeys("560066");
		log.info("Entered Zip.");

		/*
		 * base.waitUntilElementToBeVisible(driver, clickOnContry);
		 * clickOnContry.click(); log.info("Clicked on country drop box.");
		 * 
		 * selectCountry.get(96).click(); log.info(
		 * "Country Has Been Selected : "+ selectCountry.get(96));
		 */

		//base.waitUntilElementToBeVisible(driver, clickOnNextDevice);
		clickOnNextDevice.click();
		log.info("Clicked On Next Device Button.\n");

	}

	public void tellAboutDevices() {
		 base.waitUntilElementToBeVisible(driver, clickOnLastStep);
		clickOnLastStep.click();
		log.info("Clicked On Last Step Button.\n");
	}

	public void lastStep() {

		password.sendKeys("Bahubali@1111");
		log.info("Entered Password");
		confirmPassword.sendKeys("Bahubali@1111");
		log.info("Entered Confirm Password");

		if (!(uTestTermsUseCheck.isSelected())) {
			uTestTermsUseCheck.click();
			log.info("uTestTermsUseCheck has been selected");
		} else {
			log.info("uTest Tesrms Of Use Checkbox Not selected");
		}

		if (!(privacyAndSecurity.isSelected())) {
			privacyAndSecurity.click();
			log.info("privacyAndSecurity has been selected");
		} else {
			log.info("Privacy And Security Checkbox Not selected");
		}

		completeSetUp.click();
		log.info("Clicked On Complete SetUp Button");
	}
}
