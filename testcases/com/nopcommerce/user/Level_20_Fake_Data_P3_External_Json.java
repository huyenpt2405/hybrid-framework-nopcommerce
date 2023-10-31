package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;
import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import utilities.DataHelper;

public class Level_20_Fake_Data_P3_External_Json extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapper.getUserData();
		
		emailAddress = userData.getEmailAddress() + getRandomNumberByDateTime() + "@gmail.com";
	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();
		
		registerPage.inputToTextboxByID(userData.getFirstName(), "FirstName");
		registerPage.inputToTextboxByID(userData.getLastName(), "LastName");
		registerPage.inputToTextboxByID(emailAddress, "Email");
		registerPage.inputToTextboxByID(userData.getPassword(), "Password");
		registerPage.inputToTextboxByID(userData.getPassword(), "ConfirmPassword");
		
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
	private String emailAddress;
	private UserDataMapper userData;
}
