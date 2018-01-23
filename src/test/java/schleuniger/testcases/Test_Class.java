package schleuniger.testcases;

import org.testng.annotations.Test;

import framework.pages.MyPageFactory;
import framework.utility.LogFactory;
import framework.utility.WebDriverListener;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.slf4j.Logger;
import org.testng.Assert;

import schleuniger.pages.AddContent;
import schleuniger.pages.Home;
import schleuniger.pages.ProductFinder;
import schleuniger.pages.ProductTemplate;

public class Test_Class extends TestCaseBaseForLoggedInUser{
	private static final Logger LOG = LogFactory.getLogger(WebDriverListener.class);
	@Test
	public void createProduct(){
		
		webDriver.navigate().to("https://schleuniger.rolique.space/global/en");
		home = MyPageFactory.initElements(webDriver, Home.class);
		
		if (home.isAdminMenuPresent()){
			home.clickOnManageBtn();
		}
		
		home.hoverContentBtn();
		home.getWebDriverWait(5);
		AddContent addContent = home.clickAddContentBtn();
		ProductTemplate productTemplate =  addContent.clickOnProductContType();
		productTemplate.getWebDriverWait(5);
		productTemplate.typeTitle("Test Product");
		productTemplate.getWebDriverWait(10);
		productTemplate.typeSubitle("Subtitle");
		productTemplate.getWebDriverWait(10);
		productTemplate.selectLang("de-de");
		productTemplate.getWebDriverWait(10);
		productTemplate.chooseCategory("Strip");
		productTemplate.clickSaveAndPublish();
		
		
		
		
		//productTemplate.selectLang("de");
		//productTemplate.chooseCategory("Cut");
		

		
	}
}
