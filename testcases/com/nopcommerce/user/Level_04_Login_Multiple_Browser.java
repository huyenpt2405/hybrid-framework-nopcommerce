package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_04_Login_Multiple_Browser extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String firstName, lastName, password, existingEmail, invalidEmail;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = new UserHomePageObject(driver);
		
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		invalidEmail = "automation@.123098@gmail.com";
		existingEmail = "automationfc" + generateFakeNumber() + "@gmail.com";
		
		homePage.openRegisterPage();
		registerPage = new UserRegisterPageObject(driver);
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(existingEmail);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
 		registerPage.clickToRegisterButton();
		try {
			registerPage.clickToLogoutLink();
			homePage = new UserHomePageObject(driver);
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.openLoginPage();
		
		loginPage = new UserLoginPageObject(driver);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.openLoginPage();
		
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextBox(invalidEmail);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Wrong email");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public int generateFakeNumber() {
		Random random = new Random();
		return random.nextInt(99999);
	}
}
