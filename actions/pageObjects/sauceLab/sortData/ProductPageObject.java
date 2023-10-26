package pageObjects.sauceLab.sortData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.sauceLab.sortData.ProductPageUI;

public class ProductPageObject extends BasePage {
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductNameSortedAscending() {
		return isDataStringSortedAscending(driver, ProductPageUI.PRODUCT_NAME_TEXT);
	}
	
	public boolean isProductNameSortedDescending() {
		return isDataStringSortedDescending(driver, ProductPageUI.PRODUCT_NAME_TEXT);
	}
	
	public boolean isProductPriceSortedAscending() {
		return isDataFloatSortedAscending(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
	}
	

	public boolean isProductPriceSortedDescending() {
		return isDataFloatSortedDescending(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);
	}

	public boolean isProductNameSortedHighToLow() {
		// TODO Auto-generated method stub
		return false;
	}
}
