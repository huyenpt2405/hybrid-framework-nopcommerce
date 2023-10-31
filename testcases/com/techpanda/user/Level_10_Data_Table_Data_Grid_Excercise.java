package com.techpanda.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManagerTechPanda;
import pageObjects.techpanda.admin.AdminCustomerPageObject;
import pageObjects.techpanda.admin.AdminLoginPageObject;
import pageObjects.techpanda.user.UserHomePageObject;
import pageObjects.techpanda.user.UserLoginPageObject;
import pageObjects.techpanda.user.UserMyAccountDashboardPageObject;
import pageObjects.techpanda.user.UserRegisterPageObject;
import utilities.GlobalConstants;

public class Level_10_Data_Table_Data_Grid_Excercise extends BaseTest {
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = openMultiBrowser(browserName, appUrl);
		userHomePage = PageGeneratorManagerTechPanda.getUserHomePage(driver);
		userFirstName = "Huyen";
		userLastName = "Pham";
		userEmailAddress = "huyenpt" + generateFakeNumber() + "@gmail.com";
		userPassword = "123456";
		adminUserName = "user01";
		adminPassword = "guru99com";
	}
	
	@Test
	public void User_01_Register() {
		userHomePage.clickToFooterPageLink("My Account");
		userLoginPage = PageGeneratorManagerTechPanda.getUserLoginPage(driver);
		
		userRegisterPage = userLoginPage.clickToCreateAccountLink();
		
		userRegisterPage.enterToTextbox("firstname", userFirstName);
		userRegisterPage.enterToTextbox("lastname", userLastName);
		userRegisterPage.enterToTextbox("email_address", userEmailAddress);
		userRegisterPage.enterToTextbox("password", userPassword);
		userRegisterPage.enterToTextbox("confirmation", userPassword);
		
		userMyAccountDashboardPage = userRegisterPage.clickToRegisterButton();
		
		Assert.assertTrue(userMyAccountDashboardPage.isHasContactInfo(userFirstName + " " + userLastName));
		Assert.assertTrue(userMyAccountDashboardPage.isHasContactInfo(userEmailAddress));
	}
	
	@Test
	public void User_02_Swith_To_Admin() {
		adminLoginPage = PageGeneratorManagerTechPanda.getAdminLoginPage(driver);
		adminLoginPage.openPageUrl(GlobalConstants.TECHPANDA_ADMIN_URL);
		
		adminLoginPage.enterToTextboxByID("username", adminUserName);
		adminLoginPage.enterToTextboxByID("login", adminPassword);
		
		adminCustomerPage = adminLoginPage.clickToLoginButton();
		adminCustomerPage.closePopUp();
		
		adminCustomerPage.enterToHeaderFilterTextbox("customerGrid_filter_name", userFirstName + " " + userLastName);
		adminCustomerPage.enterToHeaderFilterTextbox("customerGrid_filter_email", userEmailAddress);
	}

	

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserMyAccountDashboardPageObject userMyAccountDashboardPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminCustomerPageObject adminCustomerPage;
	private String userFirstName, userLastName, userEmailAddress, userPassword, adminUserName, adminPassword;
}
