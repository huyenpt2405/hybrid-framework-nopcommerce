package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointPageObject;

public class Level_15_ReportNG_Screenshot extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		existingEmail = "automationfc" + generateFakeNumber() + "@gmail.com";
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Open Register Page");
		registerPage = homePage.openRegisterPage();
		
		log.info("Register - Step 02: Input data to 'First name' textbox: " + firstName);
		registerPage.inputToFirstNameTextBox(firstName);
		
		log.info("Register - Step 03: Input data to 'Lastname' textbox: " + lastName);
		registerPage.inputToLastNameTextBox(lastName);
		
		log.info("Register - Step 04: Input data to 'Email' textbox: " + existingEmail);
		registerPage.inputToEmailTextBox(existingEmail);
		
		log.info("Register - Step 05: Input data to 'Password' textbox: " + password);
		registerPage.inputToPasswordTextBox(password);
		
		log.info("Register - Step 06: Input data to 'Confirm password' textbox: " + password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
		log.info("Register - Step 07: click to Register button");
 		registerPage.clickToRegisterButton();
// 		try {
//			homePage = registerPage.clickToLogoutLink();
//		} catch (Exception exception) {
//			System.out.println(exception);
//		}
	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: open login page");
		loginPage = homePage.openLoginPage();
		
		log.info("Login - Step 02: Input data to 'Email' textbox: " + existingEmail);
		loginPage.inputToEmailTextBox(existingEmail);
		
		log.info("Login - Step 03: Input data to 'Password' textbox: " + password);
		loginPage.inputToPasswordTextBox(password);
		
		log.info("Login - Step 04: Click to Login Button");
		homePage = loginPage.clickToLoginButton();
	}
	
	@Test
	public void User_03_Customer_Info() throws InterruptedException {
		log.info("Customer Info - Step 01: Open 'My Account' page");
		customerInfoPage = homePage.openMyAccountPage();
		
		log.info("Customer Info - Step 02: Verify 'My Account' page displayed");
//		verifyFalse(customerInfoPage.isCustomerInfoPageDisplayed());
		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
	}
	
	@Test
	public void User_04_Switch_Page() {
		log.info("Switch Page - Step 01: Open 'Address' page");
		addressPage = customerInfoPage.openAddressPage();
		
		log.info("Switch Page - Step 02: Verify 'Address' page displayed");
		Assert.assertFalse(addressPage.isAddressPageDisplayed());
		
		log.info("Switch Page - Step 03: Open 'Reward Point' page");
		rewardPointPage = addressPage.openRewardPointPage();
		
		log.info("Switch Page - Step 04: Open 'My Product Review' page");
		myProductReviewPage = rewardPointPage.openMyProductReviewPage();
		
		log.info("Switch Page - Step 05: Open 'Address' page");
		addressPage = myProductReviewPage.openAddressPage();
		
		log.info("Switch Page - Step 06: Verify 'Address' page displayed");
		Assert.assertFalse(addressPage.isAddressPageDisplayed());
		
		log.info("Switch Page - Step 07: Open 'Customer Info' page");
		customerInfoPage = addressPage.openCustomerInfoPage();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private String firstName, lastName, password, existingEmail;
}
