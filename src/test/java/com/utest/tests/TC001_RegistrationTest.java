package com.utest.tests;

import java.io.File;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.utest.pages.RegistrationPage;
import com.utest.testBase.Base;

import net.bytebuddy.jar.asm.commons.Method;

public class TC001_RegistrationTest extends Base {

	RegistrationPage regPage = null;
	
	String userName = null;
	String password = null;
	
	@Test
	public void registrationTest() throws InterruptedException {

		try {
			regPage = new RegistrationPage(driver);

			regPage.tellUsAboutYourself();
			regPage.addYourAddress();
			regPage.tellAboutDevices();
			regPage.lastStep();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
