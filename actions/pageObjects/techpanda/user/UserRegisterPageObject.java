package pageObjects.techpanda.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerTechPanda;
import pageUIs.techpanda.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTextbox(String elementID, String value) {
		waitForElementVisible(driver, UserRegisterPageUI.TEXTBOX_BY_ID, elementID);
		sendKeyToElement(driver, UserRegisterPageUI.TEXTBOX_BY_ID, value, elementID);
	}

	public UserMyAccountDashboardPageObject clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManagerTechPanda.getUserMyAccountDashboardPage(driver);
	}
}
