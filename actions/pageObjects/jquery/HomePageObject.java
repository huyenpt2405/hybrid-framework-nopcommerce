package pageObjects.jquery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByPageNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_BY_PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_BY_PAGE_NUMBER, pageNumber);
	}

	public boolean isPageByPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.ACTIVE_PAGE_BY_PAGE_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.ACTIVE_PAGE_BY_PAGE_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.NEXT_PAGE_LINK);
		List<String> allRowValuesAtAllPage = new ArrayList<String>();
		
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_BY_INDEX, String.valueOf(index));
			sleepInSecond(1);
			
			List<WebElement> allRowElementsEachPage = getWebElements(driver, HomePageUI.DATA_ROW_EACH_PAGE);
			for (WebElement webElement : allRowElementsEachPage) {
				allRowValuesAtAllPage.add(webElement.getText());
			}
		}
		
		for (String string : allRowValuesAtAllPage) {
			System.out.println(string);
		}
		
		return allRowValuesAtAllPage;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementVisible(driver, HomePageUI.ROW_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		sendKeyToElement(driver, HomePageUI.ROW_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, value, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.ROW_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.ROW_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, valueSelect, rowNumber, String.valueOf(columnIndex));
	}
	
	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.ROW_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultRadioCheckbox(driver, HomePageUI.ROW_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.ROW_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.ROW_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
	}
	
	public void clickToLoadMoreButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_MORE_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_MORE_BUTTON);
	}

	public void clickToButtonByRowIndexAndTitle(String rowNumber, String buttonTitle) {
		waitForElementClickable(driver, HomePageUI.BUTTON_BY_ROW_INDEX_AND_TITLE, rowNumber, buttonTitle);
		clickToElement(driver, HomePageUI.BUTTON_BY_ROW_INDEX_AND_TITLE, rowNumber, buttonTitle);
	}
}
