package pageObjects.jquery.dataTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void openPageByPageNumber(String pageNumber) {
		waitForElementVisible(HomePageUI.PAGINATION_BY_PAGE_NUMBER, pageNumber);
		clickToElement(HomePageUI.PAGINATION_BY_PAGE_NUMBER, pageNumber);
	}

	public boolean isPageByPageNumberActived(String pageNumber) {
		waitForElementVisible(HomePageUI.ACTIVE_PAGE_BY_PAGE_NUMBER, pageNumber);
		return isElementDisplayed(HomePageUI.ACTIVE_PAGE_BY_PAGE_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendKeyToElement(HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(HomePageUI.NEXT_PAGE_LINK);
		List<String> allRowValuesAtAllPage = new ArrayList<String>();
		
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(HomePageUI.PAGINATION_BY_INDEX, String.valueOf(index));
			sleepInSecond(1);
			
			List<WebElement> allRowElementsEachPage = getWebElements(HomePageUI.DATA_ROW_EACH_PAGE);
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
		int columnIndex = getElementSize(HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementVisible(HomePageUI.ROW_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		sendKeyToElement(HomePageUI.ROW_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, value, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueSelect) {
		int columnIndex = getElementSize(HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementClickable(HomePageUI.ROW_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(HomePageUI.ROW_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, valueSelect, rowNumber, String.valueOf(columnIndex));
	}
	
	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementClickable(HomePageUI.ROW_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultRadioCheckbox(HomePageUI.ROW_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementClickable(HomePageUI.ROW_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(HomePageUI.ROW_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
	}
	
	public void clickToLoadMoreButton() {
		waitForElementClickable(HomePageUI.LOAD_MORE_BUTTON);
		clickToElement(HomePageUI.LOAD_MORE_BUTTON);
	}

	public void clickToButtonByRowIndexAndTitle(String rowNumber, String buttonTitle) {
		waitForElementClickable(HomePageUI.BUTTON_BY_ROW_INDEX_AND_TITLE, rowNumber, buttonTitle);
		clickToElement(HomePageUI.BUTTON_BY_ROW_INDEX_AND_TITLE, rowNumber, buttonTitle);
	}
}
