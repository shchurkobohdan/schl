package schleuniger.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.base.Preconditions;

import framework.pages.MyPageFactory;
import framework.utility.LogFactory;
import framework.utility.TestResultListener;
import framework.webdriver.WebDriverFactory;
import schleuniger.pages.Home;
import schleuniger.pages.Login;
import schleuniger.pages.UserProfilePg;

public class TestCaseBaseForLoggedInUser {
	private static final Logger LOG = LogFactory.getLogger(TestCaseBaseForLoggedInUser.class);

	protected WebDriver webDriver;

	protected Login login;
	protected UserProfilePg userProfilePg;
	protected Home home;


	@BeforeMethod
	public void setup() {
		String browserName = System.getProperty("browser");
		webDriver = WebDriverFactory.getInstance(browserName);
		
		LOG.info("Navigating to test url");
		webDriver.get("https://schleuniger.rolique.space/global/en/user");
		login = MyPageFactory.initElements(webDriver, Login.class);
		login.typeLogin();
		login.typePassw();
		login.getWebDriverWait(5);
		userProfilePg = login.clickLoginBtn();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			LOG.info("Killing web driver");
			WebDriverFactory.killDriverInstance();
		}
	}

}
