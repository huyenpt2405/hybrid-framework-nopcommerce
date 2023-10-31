package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import utilities.DataHelper;

public class Level_20_Fake_Data_P1_Faker extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		dataHelper = DataHelper.getDataHelper();
		
		firstName = dataHelper.getFirstName();
		lastName = dataHelper.getLastName();
		password = dataHelper.getPassword();
		emailAddress = dataHelper.getEmailAddress();
	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();
		
		registerPage.inputToTextboxByID(firstName, "FirstName");
		registerPage.inputToTextboxByID(lastName, "LastName");
		registerPage.inputToTextboxByID(emailAddress, "Email");
		registerPage.inputToTextboxByID(password, "Password");
		registerPage.inputToTextboxByID(password, "ConfirmPassword");
		
 		registerPage.clickToButtonByText("Register");
// 		try {
//			homePage = registerPage.clickToLogoutLink();
//		} catch (Exception exception) {
//			System.out.println(exception);
//		}
	}
	
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String firstName, lastName, password, emailAddress;
	private DataHelper dataHelper;
}
