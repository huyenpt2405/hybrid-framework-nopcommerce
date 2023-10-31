package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import utilities.DataHelper;

public class Level_20_Fake_Data_P2_Internal_File extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = UserData.Register.EMAIL_ADDRESS + getRandomNumberByDateTime() + "@gmail.com";
	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();
		
		registerPage.inputToTextboxByID(driver, UserData.Register.FIRSTNAME, "FirstName");
		registerPage.inputToTextboxByID(driver, UserData.Register.LASTNAME, "LastName");
		registerPage.inputToTextboxByID(driver, emailAddress, "Email");
		registerPage.inputToTextboxByID(driver, UserData.Register.PASSWORD, "Password");
		registerPage.inputToTextboxByID(driver, UserData.Register.PASSWORD, "ConfirmPassword");
		
 		registerPage.clickToButtonByText(driver, "Register");
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
}
