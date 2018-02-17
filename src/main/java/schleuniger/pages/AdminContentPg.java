package schleuniger.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.MyPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class AdminContentPg extends Page{
	
	@FindBy(xpath="//div[@class='view-content']/div/form/table[contains(@class,'views-table')]/tbody")
	private WebElement tableOfContent;
	
	@FindBy(xpath="//input[@id='edit-title']")
	private WebElement titleField;
	
	@FindBy(xpath="//input[@id='edit-submit-content']")
	private WebElement filterBtn;
	
	@Step("Typing Title field.")	
	public void typeTitleField(String title){
		titleField.clear();
		titleField.sendKeys(title);
	}
	
	@Step("Click Filter btn.")
	public void clickFilterBtn(){
		filterBtn.click();
	}
	
	@Step("Search for product and click Edit btn.")
	public ProductTemplate searchForNodeAndEdit(String name){
		ArrayList<WebElement>contentItems = new ArrayList<WebElement>(webDriver.findElements(By.xpath("//div[@class='view-content']/div/form/"
				+ "table[contains(@class,'views-table')]/tbody/tr"))); //td[contains(@class,'title')]/a
		for (int i = 0; i < contentItems.size(); i++){
			if (contentItems.get(i).findElement(By.xpath("./td[contains(@class,'title')]/a")).getText().contains(name)){
				contentItems.get(i).findElement(By.xpath(".//ul/li[contains(@class,'edit')]/a")).click();
				getWebDriverWait(5);
			}
		}return MyPageFactory.initElements(webDriver, ProductTemplate.class);
	}
	
	@Step("Search for product and click Delete btn.")
	public DeletePage searchForNodeAndDelete(String name){
		ArrayList<WebElement>contentItems = new ArrayList<WebElement>(webDriver.findElements(By.xpath("//div[@class='view-content']/div/form/"
				+ "table[contains(@class,'views-table')]/tbody/tr"))); //td[contains(@class,'title')]/a
		for (int i = 0; i < contentItems.size(); i++){
			if (contentItems.get(i).findElement(By.xpath("./td[contains(@class,'title')]/a")).getText().contains(name)){
				contentItems.get(i).findElement(By.xpath(".//ul/li/button[@type='button']")).click();
				contentItems.get(i).findElement(By.xpath(".//ul/li[contains(@class, 'delete')]/a")).click();
				getWebDriverWait(5);
			}
		}return MyPageFactory.initElements(webDriver, DeletePage.class);
	}
	  
	public AdminContentPg(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(tableOfContent);
	}
}
