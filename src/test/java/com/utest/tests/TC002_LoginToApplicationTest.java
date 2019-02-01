package com.utest.tests;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.utest.pages.LoginPage;
import com.utest.pages.RegistrationPage;
import com.utest.testBase.Base;

public class TC002_LoginToApplicationTest extends Base {

	LoginPage login = null;
	String userName = null;
	String password = null;

	@Test
	public void LoginToApplication() throws InterruptedException {

		try {
			userName = getCellDataFromExcell("TestData.xlsx", "LoginTestData", "userName", 2);
			password = getCellDataFromExcell("TestData.xlsx", "LoginTestData", "Password", 2);

			login = new LoginPage(driver);

			login.logInCredentials(userName, password);
			login.rememberMe();
			login.forgotPassword();
			login.logIn();
			login.logOut();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
