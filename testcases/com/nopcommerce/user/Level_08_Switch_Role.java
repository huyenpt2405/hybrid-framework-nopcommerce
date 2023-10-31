package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.admin.AdminHomePageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import utilities.GlobalConstants;

public class Level_08_Switch_Role extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName = "FC";
		userPassword = "123456";
		userEmailAddress = "automationfc" + generateFakeNumber() + "@gmail.com";
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";
		
		userRegisterPage = userHomePage.openRegisterPage();
		
		userRegisterPage.inputToFirstNameTextBox(firstName);
		userRegisterPage.inputToLastNameTextBox(lastName);
		userRegisterPage.inputToEmailTextBox(userEmailAddress);
		userRegisterPage.inputToPasswordTextBox(userPassword);
		userRegisterPage.inputToConfirmPasswordTextBox(userPassword);
		
 		userRegisterPage.clickToRegisterButton();
// 		try {
//			homePage = registerPage.clickToLogoutLink();
//		} catch (Exception exception) {
//			System.out.println(exception);
//		}
	}

	@Test
	public void Login_01_User_Switch_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();
		userLoginPage.loginAsUser(userEmailAddress, userPassword);
		
		adminHomePage = PageGeneratorManager.getAdminHomePage(driver);
		adminHomePage.openPageUrl(GlobalConstants.ADMIN_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
		verifyTrue(adminHomePage.isHeaderDisplayed());
	}
	
	
	@Test
	public void Login_02_Admin_Switch_To_Admin() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private AdminHomePageObject adminHomePage;
	private AdminLoginPageObject adminLoginPage;
	private String firstName, lastName, userPassword, userEmailAddress, adminEmail, adminPassword;
}
