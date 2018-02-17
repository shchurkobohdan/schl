package schleuniger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import framework.pages.MyPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class Home extends Page{
	
	@FindBy(xpath="(//*[contains(@class, 'mainpage-section__title')])[1]")
	private WebElement featuredProductsTitle;
	
	@FindBy(xpath="//*[@title='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//*[@id='toolbar-item-administration-tray']")
	private WebElement adminMenu;
	
	@FindBy(xpath="//*[@id='toolbar-item-administration']")
	private WebElement manageBTNinMenu;
	
	@FindBy(xpath="(//ul[@class='toolbar-menu']/li)[1]")
	private WebElement contentBtn;
	
	@FindBy(xpath="//ul[@class='toolbar-menu']/li/a[@href='/dach/de-de/node/add']")
	private WebElement addContentBtn;
	
	Actions actions = new Actions(webDriver);
	
	public ProductFinder click_on_SearchBtn(){
		searchBtn.click();
		return MyPageFactory.initElements(webDriver, ProductFinder.class);
	}

	public Home(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isAdminMenuPresent(){
		if (adminMenu.getAttribute("class") == "toolbar-tray is-active toolbar-tray-horizontal"){
			return true;
		} else
		return false;
	}
	
	public void clickOnManageBtn (){
		manageBTNinMenu.click();
	}
	
	@Step ("Navigate to Content btn.")
	public void hoverContentBtn(){
		actions.moveToElement(contentBtn).perform();
		getWebDriverWait(5);
	}
	
	@Step("Click on Add content btn.")
	public AddContent clickAddContentBtn(){
		new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable(addContentBtn));
		actions.moveToElement(addContentBtn).perform();
		addContentBtn.click();
		return MyPageFactory.initElements(webDriver, AddContent.class);
	}
	
	@Step("Open Content page.")
	public AdminContentPg clickOnContentBtn (){
		contentBtn.click();
		return MyPageFactory.initElements(webDriver, AdminContentPg.class);
	}
	
	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(featuredProductsTitle);
	}

}
