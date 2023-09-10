package utilities;

import java.io.File;

public class GlobalConstants {
	public static final String USER_PORTAL_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_URL = "https://admin-demo.nopcommerce.com/";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILES_PATH = PROJECT_PATH + File.separator + "uploadFiles";
	public static final String DOWNLOAD_FILES_PATH = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG_PATH = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_PATH = PROJECT_PATH + File.separator + "dragDropHTML5";
	
	// Database Account/ User/ Pass/ Port
	public static final String DB_DEV_URL = "192.146.54.32:8080";
	public static final String DB_DEV_USER = "huyenpt";
	public static final String DB_DEV_PASS = "P@ssw0rd!";
	
	public static final String DB_TEST_URL = "192.146.54.33:8080";
	public static final String DB_TEST_USER = "huyenpt";
	public static final String DB_TEST_PASS = "P@ssw0rd!";
	
	public static final long LONG_TIMEOUT = 10;
	public static final long SHORT_TIMEOUT = 5;
	public static final long RETRY_TEST_FAIL = 5;
}
