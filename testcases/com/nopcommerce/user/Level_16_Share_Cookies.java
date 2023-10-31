package com.nopcommerce.user;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_02_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;

public class Level_16_Share_Cookies extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		cookies = Common_02_Register_Cookie.cookies;
		homePage.setCookies(cookies);
		homePage.refreshCurrentPage();
	}


	@Test
	public void User_01() {
		// To do
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private UserHomePageObject homePage;
	private Set<Cookie> cookies;
}
