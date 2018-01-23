package schleuniger.testcases;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;

import framework.pages.MyPageFactory;
import framework.utility.LogFactory;
import framework.webdriver.WebDriverFactory;
import schleuniger.pages.Home;

/*
 * Base class for all the test classes
 * 
 * @author Taras Lytvyn
 */
/*
public class TestCasesBase {

	private static final Logger LOG = LogFactory.getLogger(TestCasesBase.class);

	protected WebDriver webDriver;

	protected Home homePage;

	@BeforeMethod
	public void setup() {
		//String browserName = System.getProperty("browser");
		webDriver = WebDriverFactory.getInstance("chrome");

		LOG.info("Navigating to test url");
		webDriver.get("https://prod.schleuniger.rolique.space/global/en");
		homePage = MyPageFactory.initElements(webDriver, Home.class);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			LOG.info("Killing web driver");
			WebDriverFactory.killDriverInstance();
		}
	}

}
*/