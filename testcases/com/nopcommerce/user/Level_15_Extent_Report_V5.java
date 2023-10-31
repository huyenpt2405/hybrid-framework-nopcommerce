package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointPageObject;
import reportConfig.ExtentTestManager;

public class Level_15_Extent_Report_V5 extends BaseTest {
	
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
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_01_Register");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Open Register Page");
		registerPage = homePage.openRegisterPage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Input data to 'First name' textbox: " + firstName);
		registerPage.inputToFirstNameTextBox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Input data to 'Lastname' textbox: " + lastName);
		registerPage.inputToLastNameTextBox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Input data to 'Email' textbox: " + existingEmail);
		registerPage.inputToEmailTextBox(existingEmail);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Input data to 'Password' textbox: " + password);
		registerPage.inputToPasswordTextBox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Input data to 'Confirm password' textbox: " + password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: click to Register button");
 		registerPage.clickToRegisterButton();
	}

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login");
		
// 		try {
//			homePage = registerPage.clickToLogoutLink();
//		} catch (Exception exception) {
//			System.out.println(exception);
//		}
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: open login page");
		loginPage = homePage.openLoginPage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input data to 'Email' textbox: " + existingEmail);
		loginPage.inputToEmailTextBox(existingEmail);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Input data to 'Password' textbox: " + password);
		loginPage.inputToPasswordTextBox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login Button");
		homePage = loginPage.clickToLoginButton();
	}
	
	@Test
	public void User_03_Customer_Info(Method method){
		ExtentTestManager.startTest(method.getName(), "User_02_Login");
		
		ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 01: Open 'My Account' page");
		customerInfoPage = homePage.openMyAccountPage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Customer Info - Step 02: Verify 'My Account' page displayed");
		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
	}
	
	@Test
	public void User_04_Switch_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login");
		
		ExtentTestManager.getTest().log(Status.INFO, "Switch Page - Step 01: Open 'Address' page");
		addressPage = customerInfoPage.openAddressPage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Switch Page - Step 02: Verify 'Address' page displayed");
		Assert.assertFalse(addressPage.isAddressPageDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Switch Page - Step 03: Open 'Reward Point' page");
		rewardPointPage = addressPage.openRewardPointPage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Switch Page - Step 04: Open 'My Product Review' page");
		myProductReviewPage = rewardPointPage.openMyProductReviewPage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Switch Page - Step 05: Open 'Address' page");
		addressPage = myProductReviewPage.openAddressPage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Switch Page - Step 06: Verify 'Address' page displayed");
		Assert.assertFalse(addressPage.isAddressPageDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Switch Page - Step 07: Open 'Customer Info' page");
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
