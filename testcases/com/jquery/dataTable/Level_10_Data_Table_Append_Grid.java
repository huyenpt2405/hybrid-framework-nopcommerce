package com.jquery.dataTable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.dataTable.HomePageObject;
import pageObjects.jquery.dataTable.PageGeneratorManager;

public class Level_10_Data_Table_Append_Grid extends BaseTest {
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = openMultiBrowser(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void Table_04_Action_To_Texbox_By_Column_Name() {
		homePage.clickToLoadMoreButton();
		homePage.sleepInSecond(2);
//		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "1", "NashTech");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "1", "Huan Nguyen");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "1", "HN");
//		
//		homePage.selectDropdownByColumnNameAtRowNumber("Country", "1", "Hong Kong");
//		homePage.sleepInSecond(2);
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
//		homePage.sleepInSecond(2);
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "1");
//		homePage.sleepInSecond(2);
		
		homePage.clickToButtonByRowIndexAndTitle("1", "Insert Row Above");
		homePage.sleepInSecond(2);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private HomePageObject homePage;
}
