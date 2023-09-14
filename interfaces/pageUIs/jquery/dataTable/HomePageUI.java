package pageUIs.jquery.dataTable;

public class HomePageUI {
	public static final String PAGINATION_BY_PAGE_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String ACTIVE_PAGE_BY_PAGE_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String NEXT_PAGE_LINK = "xpath=//li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_BY_INDEX = "xpath=//li[@class='qgrd-pagination-page'][%s]/a";
	public static final String DATA_ROW_EACH_PAGE = "xpath=//table[@class='qgrd']//tr";
	public static final String ROW_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]//td[%s]/input";
	public static final String ROW_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]//td[%s]//select";
	public static final String ROW_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]//td[%s]//input[@type='checkbox']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//th[text()='%s']/preceding-sibling::th";
	public static final String BUTTON_BY_ROW_INDEX_AND_TITLE = "xpath=//tr[%s]//td//button[@title='%s']";
	public static final String LOAD_MORE_BUTTON = "id=load";
	
}
