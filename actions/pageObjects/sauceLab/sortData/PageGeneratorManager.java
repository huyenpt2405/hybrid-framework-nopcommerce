package pageObjects.sauceLab.sortData;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static final ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}
	
	public static final LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
}
