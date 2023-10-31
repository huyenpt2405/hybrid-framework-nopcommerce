package pageObjects.jquery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getWebElements(HomePageUI.START_BUTTON);
		for (WebElement button : startButtons) {
			button.click();
		}
	}

	public boolean isLoadedFileNameDisplayed(String fileName) {
		waitForElementVisible(HomePageUI.LOADED_FILE_NAME, fileName);
		return isElementDisplayed(HomePageUI.LOADED_FILE_NAME, fileName);
	}

	public boolean isUploadedFileNameDisplayed(String fileName) {
		waitForElementVisible(HomePageUI.UPLOADED_FILE_NAME, fileName);
		return isElementDisplayed(HomePageUI.UPLOADED_FILE_NAME, fileName);
	}

	public boolean isUploadedImageDisplayed(String fileName) {
		waitForElementVisible(HomePageUI.UPLOADED_IMAGE, fileName);
		return isImageLoaded(HomePageUI.UPLOADED_IMAGE, fileName);
	}
	
	
	
}
