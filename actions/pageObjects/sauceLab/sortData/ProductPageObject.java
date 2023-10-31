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
		super(driver);
		this.driver = driver;
	}

	public boolean isProductNameSortedAscending() {
		return isDataStringSortedAscending(ProductPageUI.PRODUCT_NAME_TEXT);
	}
	
	public boolean isProductNameSortedDescending() {
		return isDataStringSortedDescending(ProductPageUI.PRODUCT_NAME_TEXT);
	}
	
	public boolean isProductPriceSortedAscending() {
		return isDataFloatSortedAscending(ProductPageUI.PRODUCT_PRICE_TEXT);
	}
	

	public boolean isProductPriceSortedDescending() {
		return isDataFloatSortedDescending(ProductPageUI.PRODUCT_PRICE_TEXT);
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementClickable(ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);
	}

	public boolean isProductNameSortedHighToLow() {
		// TODO Auto-generated method stub
		return false;
	}
}
