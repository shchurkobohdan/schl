package schleuniger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.MyPageFactory;
import framework.pages.Page;

public class Login extends Page{
	public Login(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@id='edit-name']")
	private WebElement login;
	
	@FindBy(xpath="//input[@id='edit-pass']")
	private WebElement passw;
	
	@FindBy(xpath="//input[@id='edit-submit']")
	private WebElement loginBtn;
	
	public void typeLogin(){
		login.sendKeys("admin");
	}
	
	public void typePassw(){
		//passw.sendKeys("IkmjysuthGfhjkm");
		passw.sendKeys("IkmjysuthGfhjkm");
	}
	
	public UserProfilePg clickLoginBtn(){
		loginBtn.click();
		return MyPageFactory.initElements(webDriver, UserProfilePg.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(loginBtn);
	}
}
