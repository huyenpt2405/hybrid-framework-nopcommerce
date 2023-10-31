package pageObjects.nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.admin.AdminHomePageUI;

public class AdminHomePageObject extends BasePage {
	private WebDriver driver;

	public AdminHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isHeaderDisplayed() {
		waitForElementVisible(AdminHomePageUI.ADMIN_HOME_PAGE_HEADER);
		return isElementDisplayed(AdminHomePageUI.ADMIN_HOME_PAGE_HEADER);
	}
}
