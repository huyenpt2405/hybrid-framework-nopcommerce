package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	
	private WebDriver driver;
	

	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(UserHomePageUI.REGISTER_LINK);
		clickToElement(UserHomePageUI.REGISTER_LINK);
//		return new RegisterPageObject(driver);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(UserHomePageUI.LOGIN_LINK);
		clickToElement(UserHomePageUI.LOGIN_LINK);
//		return new LoginPageObject(driver);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public Object isMyAccountLinkDisplay() {
		waitForElementVisible(UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public Object isLogoutLinkDisplay() {
		waitForElementVisible(UserHomePageUI.LOGOUT_LINK);
		return isElementDisplayed(UserHomePageUI.LOGOUT_LINK);
	}

	public UserCustomerInfoPageObject openMyAccountPage() {
		waitForElementClickable(UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

}
