package com.jquery.dataTable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.dataTable.HomePageObject;
import pageObjects.jquery.dataTable.PageGeneratorManager;

public class Level_10_Data_Table extends BaseTest {
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = openMultiBrowser(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void Table_01_Paging() {
		homePage.openPageByPageNumber("10");
		Assert.assertTrue(homePage.isPageByPageNumberActived("10"));
		
		homePage.openPageByPageNumber("20");
		Assert.assertTrue(homePage.isPageByPageNumberActived("20"));
		
		homePage.openPageByPageNumber("18");
		Assert.assertTrue(homePage.isPageByPageNumberActived("18"));
	}

	@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage();
		
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
	}
	
	@Test
	public void Table_03_Get_All_Row_Values() {
		homePage.refreshCurrentPage();
		
		homePage.getValueEachRowAtAllPage();
	}
	

	@Test
	public void Table_04_Enter_To_Texbox_By_Column_Name() {
		homePage.openPageUrl(null);;
		
		homePage.getValueEachRowAtAllPage();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private HomePageObject homePage;
}
