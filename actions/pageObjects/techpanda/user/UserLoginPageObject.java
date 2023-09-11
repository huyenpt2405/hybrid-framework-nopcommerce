package pageObjects.techpanda.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerTechPanda;
import pageUIs.techpanda.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToCreateAccountLink() {
		waitForElementClickable(driver, UserLoginPageUI.CREATE_ACCOUNT_LINK);
		clickToElement(driver, UserLoginPageUI.CREATE_ACCOUNT_LINK);
		return PageGeneratorManagerTechPanda.getUserRegisterPage(driver);
	}
}
