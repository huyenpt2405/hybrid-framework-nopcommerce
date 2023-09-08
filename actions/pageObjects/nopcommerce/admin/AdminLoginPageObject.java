package pageObjects.nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void inputToPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX, adminPassword);
	}

	public void inputToEmailTextbox(String adminEmail) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX);
		sendKeyToElement(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX, adminEmail);
	}

	public AdminHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		return new AdminHomePageObject(driver);
	}
	
	public void loginAsAdmin(String adminEmail, String adminPassword) {
		inputToEmailTextbox(adminEmail);
		inputToPasswordTextbox(adminPassword);
		clickToLoginButton();
	}
}
