package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_Apply_BasePage_III extends BasePage {
	public Level_02_Register_Apply_BasePage_III(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		emailAddress = "automation" + generateFakeNumber() + "@gmail.com";
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		waitForElementClickable("//a[@class='ico-register']");
		clickToElement("//a[@class='ico-register']");
		
		waitForElementClickable("//button[@id='register-button']");
		clickToElement("//button[@id='register-button']");
		
		Assert.assertEquals(getElementText("//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText("//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText("//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText("//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText("//span[@id='ConfirmPassword-error']"), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		waitForElementClickable("//a[@class='ico-register']");
		clickToElement("//a[@class='ico-register']");
		
		sendKeyToElement("//input[@id='FirstName']", "Automation");
		sendKeyToElement("//input[@id='LastName']", "Test");
		sendKeyToElement("//input[@id='Email']", "invalid.email");
		sendKeyToElement("//input[@id='Password']", "123456");
		sendKeyToElement("//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable("//button[@id='register-button']");
		clickToElement("//button[@id='register-button']");
		
		Assert.assertEquals(getElementText("//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		waitForElementClickable("//a[@class='ico-register']");
		clickToElement("//a[@class='ico-register']");
		
		sendKeyToElement("//input[@id='FirstName']", "Automation");
		sendKeyToElement("//input[@id='LastName']", "Test");
		sendKeyToElement("//input[@id='Email']", emailAddress);
		sendKeyToElement("//input[@id='Password']", "123456");
		sendKeyToElement("//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable("//button[@id='register-button']");
		clickToElement("//button[@id='register-button']");
		
		Assert.assertEquals(getElementText("//div[@class='result']"), "Your registration completed");
		
//		waitForElementClickable("//a[@class='ico-logout']");
//		clickToElement("//a[@class='ico-logout']");
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		waitForElementClickable("//a[@class='ico-register']");
		clickToElement("//a[@class='ico-register']");

		sendKeyToElement("//input[@id='FirstName']", "Automation");
		sendKeyToElement("//input[@id='LastName']", "Test");
		sendKeyToElement("//input[@id='Email']", emailAddress);
		sendKeyToElement("//input[@id='Password']", "123456");
		sendKeyToElement("//input[@id='ConfirmPassword']", "123456");
				
		waitForElementClickable("//button[@id='register-button']");
		clickToElement("//button[@id='register-button']");
		
		Assert.assertEquals(getElementText("//div[contains(@class, 'message-error')]//li"), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		waitForElementClickable("//a[@class='ico-register']");
		clickToElement("//a[@class='ico-register']");
		
		sendKeyToElement("//input[@id='FirstName']", "Automation");
		sendKeyToElement("//input[@id='LastName']", "Test");
		sendKeyToElement("//input[@id='Email']", emailAddress);
		sendKeyToElement("//input[@id='Password']", "1234");
		sendKeyToElement("//input[@id='ConfirmPassword']", "1234");
				
		waitForElementClickable("//button[@id='register-button']");
		clickToElement("//button[@id='register-button']");
		
		Assert.assertEquals(getElementText("//span[@id='Password-error']"), "Password must meet the following rules:\n"
				+ "must have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		waitForElementClickable("//button[@id='register-button']");
		clickToElement("//button[@id='register-button']");
		
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
		driver.findElement(By.id("LastName")).sendKeys("Test");
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123455");
		
		driver.findElement(By.id("register-button")).click();
		
		Assert.assertEquals(getElementText("//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public int generateFakeNumber() {
		Random random = new Random();
		return random.nextInt(99999);
	}

}
