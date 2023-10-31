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

public class Level_07_Switch_Page extends BaseTest {
	
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

		registerPage = homePage.openRegisterPage();
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(existingEmail);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
 		registerPage.clickToRegisterButton();
// 		try {
//			homePage = registerPage.clickToLogoutLink();
//		} catch (Exception exception) {
//			System.out.println(exception);
//		}
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();
		
		loginPage.inputToEmailTextBox(existingEmail);
		loginPage.inputToPasswordTextBox(password);
		
		homePage = loginPage.clickToLoginButton();
	}
	
	@Test
	public void User_03_Customer_Info() throws InterruptedException {
		customerInfoPage = homePage.openMyAccountPage();
		
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}
	
	@Test
	public void User_04_Switch_Page() {
		// Switch to Address Page
		addressPage = customerInfoPage.openAddressPage();
		
		// switch to Reward Point Page
		rewardPointPage = addressPage.openRewardPointPage();
		
		// Switch to My product review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage();
		
		// Switch to address page
		addressPage = myProductReviewPage.openAddressPage();
		
		// switch to customer info page
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
