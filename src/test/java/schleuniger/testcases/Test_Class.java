package schleuniger.testcases;

import org.testng.annotations.Test;

import framework.pages.MyPageFactory;
import framework.utility.LogFactory;
import framework.utility.TestResultListener;
import framework.utility.WebDriverListener;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.testng.Assert;

import schleuniger.pages.AddContent;
import schleuniger.pages.AdminContentPg;
import schleuniger.pages.DeletePage;
import schleuniger.pages.Home;
import schleuniger.pages.ProductPageUI;
import schleuniger.pages.ProductTemplate;

public class Test_Class extends TestCaseBaseForLoggedInUser {
	private static final Logger LOG = LogFactory.getLogger(WebDriverListener.class);
	@Test (priority=1) //(enabled=false)
	public void createProduct() throws InterruptedException{
		webDriver.navigate().to("https://schleuniger.rolique.space/dach/de-de");
		home = MyPageFactory.initElements(webDriver, Home.class);
		
		if (home.isAdminMenuPresent()){
			home.clickOnManageBtn();
		}
		
		home.hoverContentBtn();
		AddContent addContent = home.clickAddContentBtn();
		ProductTemplate productTemplate =  addContent.clickOnProductContType();
		productTemplate.typeTitle("Test Product");
		productTemplate.typeSubitle("Subtitle");
		productTemplate.selectLang("de-de");
		productTemplate.chooseCategory("Strip");
		productTemplate.chooseCategory("Koaxialkabel");
		//productTemplate.chooseSubcategory("Konventionelle Kabel");
		productTemplate.chooseIndustry("Automotive");
		productTemplate.chooseValueChain("Wire Harness");
		productTemplate.clickOnOverviewTabAndSetValue("test test test");
		productTemplate.openTechDataNamesTabAndChooseTDN("Weight");
		productTemplate.setTDvalueAndclickCreateLineBtn("123 TEST");
		productTemplate.openSliderTab();
		productTemplate.setMediaNameFieldAndPicture("Test slide");
		ProductPageUI productPageUI = productTemplate.clickSaveAndPublish();
		
		Assert.assertTrue(productPageUI.getTitle().contains("Test Product"));
		TestResultListener testResultListener = new TestResultListener();
		testResultListener.testScreenshotOnFinish();
		}
	
	@Test (priority=2)
	public void editProduct() throws InterruptedException{
		webDriver.navigate().to("https://schleuniger.rolique.space/dach/de-de");
		home = MyPageFactory.initElements(webDriver, Home.class);
		AdminContentPg adminContentPg = home.clickOnContentBtn();
		adminContentPg.typeTitleField("Test Product");
		adminContentPg.clickFilterBtn();
		ProductTemplate productTemplate = adminContentPg.searchForNodeAndEdit("Test Product");
		productTemplate.typeTitle("Test Product (edited)");
		ProductPageUI productPageUI = productTemplate.clickSaveAndKeepPublished();
		
		Assert.assertTrue(productPageUI.getTitle().contains("Test Product"));
		TestResultListener testResultListener = new TestResultListener();
		testResultListener.testScreenshotOnFinish();
		
	}
	
	@Test (priority=3)
	public void deleteProduct() throws InterruptedException{
		webDriver.navigate().to("https://schleuniger.rolique.space/dach/de-de");
		home = MyPageFactory.initElements(webDriver, Home.class);
		AdminContentPg adminContentPg = home.clickOnContentBtn();
		adminContentPg.typeTitleField("Test Product (edited)");
		adminContentPg.clickFilterBtn();
		DeletePage deletePage = adminContentPg.searchForNodeAndDelete("Test Product (edited)");
		deletePage.clickDeleteBtn();
		
		
		Assert.assertTrue(home.isElementPresent(webDriver.findElement(By.xpath("//div[@aria-label='Status message']"))));
		TestResultListener testResultListener = new TestResultListener();
		testResultListener.testScreenshotOnFinish();
	}
}
