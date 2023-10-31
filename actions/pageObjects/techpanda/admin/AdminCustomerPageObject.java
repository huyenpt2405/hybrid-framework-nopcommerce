package pageObjects.techpanda.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.admin.AdminCustomerPageUI;

public class AdminCustomerPageObject extends BasePage {
	WebDriver driver;

	public AdminCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void closePopUp() {
		waitForElementClickable(AdminCustomerPageUI.CLOSE_POPUP_BUTTON);
		clickToElement(AdminCustomerPageUI.CLOSE_POPUP_BUTTON);
	}

	public void enterToHeaderFilterTextbox(String textboxID, String value) {
		waitForElementVisible(AdminCustomerPageUI.HEADER_FILTER_TEXTBOX, textboxID);
		sendKeyToElement(AdminCustomerPageUI.HEADER_FILTER_TEXTBOX, value, textboxID);
		pressKeyToElement(AdminCustomerPageUI.HEADER_FILTER_TEXTBOX, Keys.ENTER, textboxID);
	}
}
