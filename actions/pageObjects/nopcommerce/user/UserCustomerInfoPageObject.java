package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isCustomerInfoPageDisplayed() {
		waitForElementVisible(UserCustomerInfoPageUI.CUSTOMER_INFO_TEXT);
		return isElementDisplayed(UserCustomerInfoPageUI.CUSTOMER_INFO_TEXT);
	}
	
}
