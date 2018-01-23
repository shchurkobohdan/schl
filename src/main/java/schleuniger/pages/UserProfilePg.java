package schleuniger.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.Page;

public class UserProfilePg extends Page{
	
	@FindBy(xpath="//*[@class='tabs primary drupal-tabs-custom']")
	private WebElement primaryTabs;
	
	public UserProfilePg(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(primaryTabs);
	}

}
