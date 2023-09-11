package pageUIs.jquery;

public class HomePageUI {
	public static final String PAGINATION_BY_PAGE_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String ACTIVE_PAGE_BY_PAGE_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String NEXT_PAGE_LINK = "xpath=//li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_BY_INDEX = "xpath=//li[@class='qgrd-pagination-page'][%s]/a";
	public static final String DATA_ROW_EACH_PAGE = "xpath=//table[@class='qgrd']//tr";
	
}
