package com.sauceLab.sortData;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObjects.sauceLab.sortData.LoginPageObject;
import pageObjects.sauceLab.sortData.PageGeneratorManager;
import pageObjects.sauceLab.sortData.ProductPageObject;
import reportConfig.ExtentTestManager;

public class Level_19_Sort_Asc_Desc extends BaseTest {
	private WebDriver driver;
	private String username, password;
	private LoginPageObject loginPage;
	private ProductPageObject productPage;
	
	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = openMultiBrowser(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		username = "standard_user";
		password = "secret_sauce";
	}
	
	@Test
	public void TC_01_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Login");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Enter text to Username textbox: " + username);
		loginPage.enterToUsernameTextbox(username);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter text to Password textbox: " + password);
		loginPage.enterToPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: click to login button");
		productPage = loginPage.clickToLoginButton();
	}
	
	@Test
	public void TC_02_Sort_By_Product_Name(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Sort_By_Product_Name");
		ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 01: Select sort ASC name option");
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 02: Verify product name ASC sorted correctly");
		Assert.assertTrue(productPage.isProductNameSortedAscending());
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 03: Select sort DESC name option");
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 04: Verify product name ASC sorted correctly");
		Assert.assertTrue(productPage.isProductNameSortedDescending());
	}
	
	@Test
	public void TC_03_Sort_By_Product_Price(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Sort_By_Product_Price");
		ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 01: Select sort low to high price option");
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 02: Verify product price (low to high) sorted correctly");
		Assert.assertTrue(productPage.isProductPriceSortedAscending());
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 03: Select sort high to low price option");
		productPage.selectItemInProductSortDropdown("Price (high to low)");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort - Step 04: Verify product price (high to low) sorted correctly");
		Assert.assertTrue(productPage.isProductPriceSortedDescending());
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
