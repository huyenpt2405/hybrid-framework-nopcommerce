package com.jquery.uploadFile;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.uploadFile.HomePageObject;
import pageObjects.jquery.uploadFile.PageGeneratorManager;

public class Level_11_JQuery_Upload_File extends BaseTest {
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = openMultiBrowser(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		javaFileName = "java.jpg";
		pythonFileName = "python.jpg";
	}
	
	@Test
	public void Upload_File_01_Single_File() {
		homePage.uploadMultipleFiles(javaFileName);
		Assert.assertTrue(homePage.isLoadedFileNameDisplayed(javaFileName));
		
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isUploadedFileNameDisplayed(javaFileName));
		Assert.assertTrue(homePage.isUploadedImageDisplayed(javaFileName));
	}
	

	@Test
	public void Upload_File_02_Multiple_File() {
		homePage.refreshCurrentPage();
		homePage.uploadMultipleFiles(javaFileName, pythonFileName);
		Assert.assertTrue(homePage.isLoadedFileNameDisplayed(javaFileName));
		Assert.assertTrue(homePage.isLoadedFileNameDisplayed(pythonFileName));
		
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isUploadedFileNameDisplayed(javaFileName));
		Assert.assertTrue(homePage.isUploadedFileNameDisplayed(pythonFileName));
		Assert.assertTrue(homePage.isUploadedImageDisplayed(javaFileName));
		Assert.assertTrue(homePage.isUploadedImageDisplayed(pythonFileName));
	}

	private WebDriver driver;
	private HomePageObject homePage;
	private String javaFileName, pythonFileName;
}
