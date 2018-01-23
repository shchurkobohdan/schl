package schleuniger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.Page;

public class ProductFinder extends Page{
	
	@FindBy(xpath="//h1[contains(text(), 'Product Finder')]")
	private WebElement str;
	
	
	
	public ProductFinder(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(str);
	}
}
