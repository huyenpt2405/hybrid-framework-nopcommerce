package pageObjects.techpanda.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToFooterPageLink(String linkTitle) {
		waitForElementClickable(driver, UserHomePageUI.FOOTER_PAGE_LINK, linkTitle);
		clickToElement(driver, UserHomePageUI.FOOTER_PAGE_LINK, linkTitle);
	}
}
