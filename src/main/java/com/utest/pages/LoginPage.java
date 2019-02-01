package com.utest.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.utest.testBase.Base;

public class LoginPage {

	public WebDriver driver;

	public static final Logger log = Logger.getLogger(LoginPage.class.getName());

	SoftAssert assertion = null;

	Base base = new Base();

	@FindBy(xpath = ".//a[contains(text(),'Sign in')]")
	private WebElement clickSignIn;

	@FindBy(xpath = ".//input[@id='username']")
	private WebElement userName;

	@FindBy(xpath = ".//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = ".//button[contains(text(),'Sign in')]")
	private WebElement clickOnLogin;

	@FindBy(xpath = ".//input[@id='rememberMe']")
	private WebElement rememberMe;

	@FindBy(xpath = ".//a[contains(text(),'Forgot Password?')]")
	private WebElement forgotPassword;

	@FindBy(xpath = ".//a[@href='/logout']")
	private WebElement logOut;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		assertion = new SoftAssert();
		PageFactory.initElements(driver, this);
	}

	public void logInCredentials(String userEmail, String userPassword) {

		base.waitUntilElementToBeVisible(driver, clickSignIn);
		if (clickSignIn.isDisplayed()) {
			clickSignIn.click();
			log.info("Clicked on sign in button from home page\n");
		} else {
			log.info("Element is not available\n");
		}

		userName.sendKeys(userEmail);
		log.info("Passed UserName  : " + userEmail);

		password.sendKeys(userPassword);
		log.info("Passed User Password  : " + userPassword + "\n");
	}

	public void rememberMe() {
		boolean rememberCheckBox = rememberMe.isDisplayed();
		if (rememberCheckBox) {
			String remeberMeText = rememberMe.getText();
			assertion.assertEquals(rememberCheckBox, true, remeberMeText + " check box is not displayed on login page");
			rememberMe.click();
			assertion.assertAll();
			log.info("rememberCheckBox is displayed and clicked.\n");
		} else {
			log.info("rememberCheckBox Checkbox is not enabled.\n");
		}
	}

	public void forgotPassword() {
		boolean forgotPassLink = forgotPassword.isDisplayed();
		if (forgotPassLink) {
			String forgotPasswordText = forgotPassword.getText();
			assertion.assertEquals(forgotPassLink, true,
					forgotPasswordText + "Link Text is not displayed properly on login page");
			assertion.assertAll();
			log.info(forgotPasswordText + "Link is visible \n");
		}
	}

	public void logIn() {

		clickOnLogin.click();
		log.info("Clicked On SingIn Button from the home page\n");
	}

	public void logOut() {

		base.waitUntilElementToBeVisible(driver, logOut);
		if (logOut.isDisplayed()) {
			log.info("Successfully Logged In");
		}
	}
}
