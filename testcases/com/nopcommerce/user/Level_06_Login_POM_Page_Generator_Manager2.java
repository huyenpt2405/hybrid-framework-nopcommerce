package com.nopcommerce.user;

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

public class Level_06_Login_POM_Page_Generator_Manager2 extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String firstName, lastName, password, existingEmail, notFoundEmail, invalidEmail, incorrectPassword;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = new UserHomePageObject(driver);
		
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		incorrectPassword = "12345678";
		invalidEmail = "automation@.123098@gmail.com";
		notFoundEmail = "aut" + generateFakeNumber() + "@gmial.com";
		existingEmail = "automationfc" + generateFakeNumber() + "@gmail.com";
		
		registerPage = homePage.openRegisterPage();
//		registerPage = new RegisterPageObject(driver);
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(existingEmail);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
 		registerPage.clickToRegisterButton();
		try {
			homePage = registerPage.clickToLogoutLink();
//			homePage = new HomePageObject(driver);
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}

	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.openLoginPage();
//		loginPage = new LoginPageObject(driver);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.openLoginPage();
		
//		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox(invalidEmail);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Wrong email");
	}
	
	@Test
	public void Login_03_Email_Not_Found() {
		loginPage = homePage.openLoginPage();
		
//		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox(notFoundEmail);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		loginPage = homePage.openLoginPage();
		
//		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox(existingEmail);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		loginPage = homePage.openLoginPage();
		//		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextBox(existingEmail);
		loginPage.inputToPasswordTextBox(incorrectPassword);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Success() {
		loginPage = homePage.openLoginPage();
		
//		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox(existingEmail);
		loginPage.inputToPasswordTextBox(password);
		
		homePage = loginPage.clickToLoginButton();
		
//		homePage = new HomePageObject(driver);
		Assert.assertEquals(homePage.isMyAccountLinkDisplay(), true);
		Assert.assertEquals(homePage.isLogoutLinkDisplay(), true);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
