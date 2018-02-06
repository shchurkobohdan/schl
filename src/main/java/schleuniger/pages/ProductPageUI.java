package schleuniger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.Page;

public class ProductPageUI extends Page {

	@FindBy(xpath="//div[@class='product-page']/h1")
	private WebElement title;
	
	@FindBy(xpath="//div[@class='slider-wrap js-slider-wrap']")
	private WebElement slider;

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(slider);
	}
	
	
	public ProductPageUI(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

}
