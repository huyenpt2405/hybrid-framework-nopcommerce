package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_03_Login_Apply_POM{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String firstName, lastName, password, existingEmail, notFoundEmail, invalidEmail, incorrectPassword;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new UserHomePageObject(driver);
		
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		incorrectPassword = "12345678";
		invalidEmail = "automation@.123098@gmail.com";
		notFoundEmail = "aut" + generateFakeNumber() + "@gmial.com";
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

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.openLoginPage();
		
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextBox(notFoundEmail);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.openLoginPage();
		
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextBox(existingEmail);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.openLoginPage();
		
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextBox(existingEmail);
		loginPage.inputToPasswordTextBox(incorrectPassword);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Success() {
		homePage.openLoginPage();
		
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextBox(existingEmail);
		loginPage.inputToPasswordTextBox(password);
		
		loginPage.clickToLoginButton();
		
		homePage = new UserHomePageObject(driver);
		Assert.assertEquals(homePage.isMyAccountLinkDisplay(), true);
		Assert.assertEquals(homePage.isLogoutLinkDisplay(), true);
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
