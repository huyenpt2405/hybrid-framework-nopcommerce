package commons;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.EnvironmentList;
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
	
	protected WebDriver openMultiBrowserByAppUrl(String browserName, String appUrl) {
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
	
	protected WebDriver openMultiBrowser(String browserName, String env) {
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
		driver.get(getEnvironmentUrl(env));
		return driver;
	}
	
	protected WebDriver openMultiBrowserGrid(String browserName, String env, String osName, String ipAddress, String portNumber) {
		DesiredCapabilities capability = null;
		Platform platform = null;

		if (osName.contains("windows")) {
			platform = Platform.WINDOWS;
		} else {
			platform = Platform.MAC;
		}

		switch (browserName) {
			case "firefox" :
				capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				capability.setPlatform(platform);

				FirefoxOptions fOptions = new FirefoxOptions();
				fOptions.merge(capability);
				break;
			case "chrome" :
					capability = DesiredCapabilities.chrome();
					capability.setBrowserName("chrome");
					capability.setPlatform(platform);

					ChromeOptions cOptions = new ChromeOptions();
					cOptions.merge(capability);
					break;
				case "edge" :
					capability = DesiredCapabilities.edge();
					capability.setBrowserName("edge");
					capability.setPlatform(platform);

					EdgeOptions eOptions = new EdgeOptions();
					eOptions.merge(capability);
					break;
				default :
					throw new RuntimeException("Browser is not valid!");
			}

			try {
				driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(getEnvironmentUrl(env));
		return driver;
	}
	
	public String getEnvironmentUrl(String env) {
		String envUrl;
		EnvironmentList enviroment = EnvironmentList.valueOf(env.toUpperCase());
		switch (enviroment) {
		case DEV:
			envUrl = "https://demo.nopcommerce.com/";
			break;
		case TEST:
			envUrl = "https://demo.nopcommerce.com/";
			break;
		case PRODUCTION:
			envUrl = "https://demo.nopcommerce.com/";
			break;
		case STAGING:
			envUrl = "https://demo.nopcommerce.com/";
			break;
		case PRE_PRODUCTION:
			envUrl = "https://demo.nopcommerce.com/";
			break;
		default:
			envUrl = null;
			break;
		}
		return envUrl;
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
	
	public long getRandomNumberByDateTime() {
		return Calendar.getInstance().getTimeInMillis() % 100000;
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
	
	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
