package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.techpanda.admin.AdminCustomerPageObject;
import pageObjects.techpanda.admin.AdminLoginPageObject;
import pageObjects.techpanda.user.UserHomePageObject;
import pageObjects.techpanda.user.UserLoginPageObject;
import pageObjects.techpanda.user.UserMyAccountDashboardPageObject;
import pageObjects.techpanda.user.UserRegisterPageObject;

public class PageGeneratorManagerTechPanda {
	public static final AdminCustomerPageObject getAdminCustomerPage(WebDriver driver) {
		return new AdminCustomerPageObject(driver);
	}
	
	public static final AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static final UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static final UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static final UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static final UserMyAccountDashboardPageObject getUserMyAccountDashboardPage(WebDriver driver) {
		return new UserMyAccountDashboardPageObject(driver);
	}
	
}
