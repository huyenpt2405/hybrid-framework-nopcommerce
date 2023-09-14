package pageObjects.jquery.uploadFile;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static final HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
