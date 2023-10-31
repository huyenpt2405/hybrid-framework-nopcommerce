package pageObjects.techpanda.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToFooterPageLink(String linkTitle) {
		waitForElementClickable(UserHomePageUI.FOOTER_PAGE_LINK, linkTitle);
		clickToElement(UserHomePageUI.FOOTER_PAGE_LINK, linkTitle);
	}
}
