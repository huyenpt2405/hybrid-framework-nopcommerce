package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserAddressPageUI;
import pageUIs.nopcommerce.user.UserBasePageUI;

public class UserAddressPageObject extends BasePage {
	private WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAddressPageDisplayed() {
		waitForElementVisible(driver, UserAddressPageUI.ADDRESSES_PAGE_HEADER);
		return isElementDisplayed(driver, UserAddressPageUI.ADDRESSES_PAGE_HEADER);
	}
}
