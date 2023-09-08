package com.nopcommerce.user;

public class Level_09_String_Format {
	public static String CUSTOMER_INFO_LINK = "xpath=//div[contains(@class, 'account-navigation')]//a[text()='Customer info']";
	public static String ADDRESS_LINK = "xpath=//div[contains(@class, 'account-navigation')]//a[text()='Addresses']";
	public static String REWARD_POINT_LINK = "xpath=//div[contains(@class, 'account-navigation')]//a[text()='Reward points']";
	public static String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class, 'account-navigation')]//a[text()='My product reviews']";
	public static String dynamicLocator = "xpath=//div[contains(@class, '%s')]//a[text()='%s']";
	public static void main(String[] args) {
		clickToLink(dynamicLocator, "account-navigation", "My product reviews");
	}
	
	private static void clickToLink(String dynamicLocator, String... params) {
		String str = String.format(dynamicLocator, (Object[]) params);
		System.out.println(str);
	}
}
