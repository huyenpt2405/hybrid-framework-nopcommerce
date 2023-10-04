package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.GlobalConstants;

public class BaseTest {
	private WebDriver driver;
	protected String projectPath = GlobalConstants.PROJECT_PATH;
	protected final Logger log;
	
	protected BaseTest() {
		log = LogManager.getLogger(getClass());
	}
	
	protected WebDriver openMultiBrowser(String browserName) {
		// Coc coc - 5,6 version so voi chromedriver
		if (browserName.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("cococ")) {
			WebDriverManager.chromedriver().driverVersion("versionchrome - 6").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\");
			driver = new ChromeDriver(options);
		}  else if (browserName.equals("brave")) {
			WebDriverManager.chromedriver().driverVersion("versionChrome-4").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else {
			throw new RuntimeException("Cannot find browser");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(GlobalConstants.USER_PORTAL_URL);
		return driver;
	}
	
	protected WebDriver openMultiBrowser(String browserName, String appUrl) {
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("cococ")) {
			WebDriverManager.chromedriver().driverVersion("versionchrome - 6").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\");
			driver = new ChromeDriver(options);
		}  else if (browserName.equals("brave")) {
			WebDriverManager.chromedriver().driverVersion("versionChrome-4").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else {
			throw new RuntimeException("Cannot find browser");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}
	
	public WebDriver getWebdriver() {
		return this.driver;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info("------------------ PASS ------------------");
		} catch (Throwable e) {
			log.info("------------------ FAILED ------------------");
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("------------------ PASS ------------------");
		} catch (Throwable e) {
			log.info("------------------ FAILED ------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("------------------ PASS ------------------");
		} catch (Throwable e) {
			log.info("------------------ FAILED ------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	

	protected int generateFakeNumber() {
		Random random = new Random();
		return random.nextInt(99999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
