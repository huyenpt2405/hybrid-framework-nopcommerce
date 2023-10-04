package utilities;

import java.io.File;

public class GlobalConstants {
	public static final String USER_PORTAL_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_URL = "https://admin-demo.nopcommerce.com/";
	
	public static final String TECHPANDA_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin/customer/";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILES_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILES_PATH = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG_PATH = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_PATH = PROJECT_PATH + File.separator + "dragDropHTML5" + File.separator;
	public static final String TESTNG_SCREENSHOT_PATH = PROJECT_PATH + File.separator + "ReportNGScreenShots" + File.separator;
	public static final String EXTENT_REPORT_V2_PATH = PROJECT_PATH + File.separator + "ExtentReportV2" + File.separator + "ExtentReport.html";
	
	// Database Account/ User/ Pass/ Port
	public static final String DB_DEV_URL = "192.146.54.32:8080";
	public static final String DB_DEV_USER = "huyenpt";
	public static final String DB_DEV_PASS = "P@ssw0rd!";
	
	public static final String DB_TEST_URL = "192.146.54.33:8080";
	public static final String DB_TEST_USER = "huyenpt";
	public static final String DB_TEST_PASS = "P@ssw0rd!";
	
	public static final long LONG_TIMEOUT = 30;
	public static final long SHORT_TIMEOUT = 5;
	public static final long RETRY_TEST_FAIL = 5;
	public static final String EXTENT_PATH = PROJECT_PATH + "File.separator";
	public static final String JAVA_VERSION = System.getProperty("java.version");
}
