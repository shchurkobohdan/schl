package schleuniger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.MyPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class AddContent extends Page{
	
	@FindBy(xpath="//ul[@class='admin-list']")
	private WebElement listOfContentTypes;
	
	@FindBy(xpath="//ul[@class='admin-list']/li/a/span[contains(text(),'Product')]")
	private WebElement productContentType;
	
	@Step("Click on Product content type.")
	public ProductTemplate clickOnProductContType(){
		productContentType.click();
		return MyPageFactory.initElements(webDriver, ProductTemplate.class);
	}

	public AddContent(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(listOfContentTypes);
	}

}
