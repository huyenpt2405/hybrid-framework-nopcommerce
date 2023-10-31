package pageObjects.sauceLab.sortData;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.sauceLab.sortData.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String username) {
		waitForElementVisible(LoginPageUI.USERNAME_TEXTBOX);
		sendKeyToElement(LoginPageUI.USERNAME_TEXTBOX, username);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public ProductPageObject clickToLoginButton() {
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getProductPage(driver);
	}
}
