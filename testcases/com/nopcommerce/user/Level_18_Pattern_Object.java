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

public class Level_18_Pattern_Object extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		emailAddress = "automationfc" + generateFakeNumber() + "@gmail.com";
	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();
		
		registerPage.inputToTextboxByID(driver, firstName, "FirstName");
		registerPage.inputToTextboxByID(driver, lastName, "LastName");
		registerPage.inputToTextboxByID(driver, emailAddress, "Email");
		registerPage.inputToTextboxByID(driver, password, "Password");
		registerPage.inputToTextboxByID(driver, password, "ConfirmPassword");
		
 		registerPage.clickToButtonByText(driver, "Register");
// 		try {
//			homePage = registerPage.clickToLogoutLink();
//		} catch (Exception exception) {
//			System.out.println(exception);
//		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String firstName, lastName, password, emailAddress;
}
