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

public class DeletePage extends Page{
	
	@FindBy(xpath="//form[@id='node-product-delete-form']")
	private WebElement deleteForm;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteBtn;
	
	@Step("Click Delete btn to confirm.")
	public Home clickDeleteBtn(){
		deleteBtn.click();
	return MyPageFactory.initElements(webDriver, Home.class);
	}
	
	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(deleteForm);
	}

	public DeletePage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
}
