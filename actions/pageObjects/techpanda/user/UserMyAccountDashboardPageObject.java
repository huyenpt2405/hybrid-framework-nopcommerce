package pageObjects.techpanda.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.user.UserMyAccountDashboardPageUI;

public class UserMyAccountDashboardPageObject extends BasePage {
	WebDriver driver;

	public UserMyAccountDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getContactInfo() {
		waitForElementVisible(driver, UserMyAccountDashboardPageUI.CONTACT_INFO_TEXT);
		return getElementText(driver, UserMyAccountDashboardPageUI.CONTACT_INFO_TEXT);
	}
	
	public boolean isHasContactInfo(String contactInfo) {
		waitForElementVisible(driver, UserMyAccountDashboardPageUI.CONTACT_INFO_TEXT);
		return getElementText(driver, UserMyAccountDashboardPageUI.CONTACT_INFO_TEXT).contains(contactInfo);
	}
}
