package pageObjects.techpanda.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerTechPanda;
import pageUIs.techpanda.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToTextboxByID(String textboxID, String value) {
		waitForElementVisible(AdminLoginPageUI.TEXTBOX_BY_ID, textboxID);
		sendKeyToElement(AdminLoginPageUI.TEXTBOX_BY_ID, value, textboxID);
	}

	public AdminCustomerPageObject clickToLoginButton() {
		waitForElementClickable(AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManagerTechPanda.getAdminCustomerPage(driver);
	}
}
