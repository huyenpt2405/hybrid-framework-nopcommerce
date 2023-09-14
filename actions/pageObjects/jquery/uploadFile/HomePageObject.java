package pageObjects.jquery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getWebElements(driver, HomePageUI.START_BUTTON);
		for (WebElement button : startButtons) {
			button.click();
		}
	}

	public boolean isLoadedFileNameDisplayed(String fileName) {
		waitForElementVisible(driver, HomePageUI.LOADED_FILE_NAME, fileName);
		return isElementDisplayed(driver, HomePageUI.LOADED_FILE_NAME, fileName);
	}

	public boolean isUploadedFileNameDisplayed(String fileName) {
		waitForElementVisible(driver, HomePageUI.UPLOADED_FILE_NAME, fileName);
		return isElementDisplayed(driver, HomePageUI.UPLOADED_FILE_NAME, fileName);
	}

	public boolean isUploadedImageDisplayed(String fileName) {
		waitForElementVisible(driver, HomePageUI.UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUI.UPLOADED_IMAGE, fileName);
	}
	
	
	
}
