package pageObjects.techpanda.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerTechPanda;
import pageUIs.techpanda.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserRegisterPageObject clickToCreateAccountLink() {
		waitForElementClickable(UserLoginPageUI.CREATE_ACCOUNT_LINK);
		clickToElement(UserLoginPageUI.CREATE_ACCOUNT_LINK);
		return PageGeneratorManagerTechPanda.getUserRegisterPage(driver);
	}
}
