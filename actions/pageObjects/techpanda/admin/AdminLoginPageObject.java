package pageObjects.techpanda.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerTechPanda;
import pageUIs.techpanda.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTextboxByID(String textboxID, String value) {
		waitForElementVisible(driver, AdminLoginPageUI.TEXTBOX_BY_ID, textboxID);
		sendKeyToElement(driver, AdminLoginPageUI.TEXTBOX_BY_ID, value, textboxID);
	}

	public AdminCustomerPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManagerTechPanda.getAdminCustomerPage(driver);
	}
}
