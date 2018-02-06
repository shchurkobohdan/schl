package schleuniger.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;

import com.google.common.base.Function;

import framework.pages.MyPageFactory;
import framework.pages.Page;
import framework.utility.LogFactory;
import framework.utility.WebDriverListener;

public class ProductTemplate extends Page{
	private static final Logger LOG = LogFactory.getLogger(WebDriverListener.class);
	
	@FindBy(xpath="//div[@class='layout-node-form clearfix']")
	private WebElement pageContent;
	
	@FindBy(xpath=".//*[@id='edit-title-0-value']")
	private WebElement title;
	
	@FindBy(xpath="//input[@id='edit-field-sub-ti-0-value']")
	private WebElement subTitle;
	
	Select select = new Select(webDriver.findElement(By.xpath("//select[@id='edit-langcode-0-value']")));
	
	@FindBy(xpath="//*[@id='edit_field_category_chosen']/ul/li/input")
	private WebElement categoryField; 	
	
	//ArrayList<WebElement> categories = new ArrayList<WebElement>(webDriver.findElements(By.xpath("//div[@id='edit_field_category_chosen']/div/ul/li")));
	
	@FindBy(xpath="//div[@id='edit_field_industry_chosen']")
	private WebElement industryField;
	
	//ArrayList<WebElement> industries = new ArrayList<WebElement> (webDriver.findElements(By.xpath("//div[@id='edit_field_industry_chosen']/div/ul/li")));
	
	@FindBy(xpath="//div[@id='edit-field-short-description-wrapper']//iframe")
	private WebElement shortDesciption;
	
	@FindBy(xpath="//details[@id='edit-group-overview']")
	private WebElement overviewTab;
	
	@FindBy(xpath="(//iframe)[2]")
	//details[@id='edit-group-overview//iframe']
	private WebElement overviewFrame;
	
	@FindBy(xpath="//details[@id='edit-group-technical-data']")
	private WebElement technicalDataTab;
	
	@FindBy(xpath="//span[contains(text(),'Select a value')]")
	private WebElement technicalDataNameDrop;
	
    //ArrayList <WebElement> technicalDataNameList = new ArrayList<WebElement> (webDriver.findElements(By.xpath("//div[@id='edit_field_technical_data_values_0_subform_field_line_form_inline_entity_form_field_name_chosen']//ul/li")));
	
	@FindBy(xpath="(//iframe)[4]")
	private WebElement TDValueFrame;
	
    @FindBy(xpath="//input[@value='Create line']")
	private WebElement createTechnicalDataLineBtn;
    
    @FindBy(xpath="//details[@id='edit-group-slider']")//a[@href='#edit-group-slider']
	private WebElement sliderTab;

    @FindBy(xpath="//div[@id='edit-field-slider-form-inline-entity-form-name-wrapper']/div/input")
	private WebElement mediaNameField;
    
    @FindBy(xpath="(//div/a[contains(@href,'/global/en/imce/s3?sendto')])[1]")
    WebElement openFileBrowserBtn;
    
    @FindBy(xpath="//*[@id='edit-field-slider-form-inline-entity-form-field-video-from-vimeo-value']")
   	private WebElement vimeoVideoCheckbox;
    
    @FindBy(xpath="//input[@id='edit-field-slider-form-inline-entity-form-field-vimeo-0-value']")
   	private WebElement vimeoVideoLinkField;
    
    @FindBy(xpath="//input[@id='edit-field-slider-form-inline-entity-form-actions-ief-add-save']")
   	private WebElement createSlideBtn;
    
    @FindBy(xpath="//input[@value='Save and publish']")
   	private WebElement saveAndPublishBtn;
    
    //Actions action = new Actions(webDriver);
    
    public void typeTitle(String txt){
    	//getJSExecutor().executeScript("document.getElementById('edit-title-0-value').value=\"test\";", title);
    	title.click();
    	title.sendKeys(txt);
    }
    
    public void typeSubitle(String txt){
    	subTitle.sendKeys(txt);
    }
    
    
	public void selectLang(String value){
		select.selectByValue(value);
	}
	
	public void chooseCategory(String categ){
		categoryField.click();
	    getWebDriverWait(10).until(ExpectedConditions.attributeContains(webDriver.findElement(By.
	    		xpath("//div[@id='edit_field_category_chosen']")), "class", "chosen-container-active"));
	    ArrayList<WebElement> categories = new ArrayList<WebElement>(webDriver.findElements(By.xpath("//div[@id='edit_field_category_chosen']/div/ul/li")));
		for (int i = 0; i < categories.size(); i++){
			if (categories.get(i).getText().contains(categ)){
				getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(categories.get(i)));
				new Actions(webDriver).moveToElement(categories.get(i)).perform();
				categories.get(i).click();
				break;
			}
		}
	}
	
	public void chooseIndustry(String industry){
		industryField.click();
	    getWebDriverWait(10).until(ExpectedConditions.attributeContains(webDriver.findElement(By.
	    		xpath("//div[@id='edit_field_industry_chosen']")), "class", "chosen-container-active"));
	    ArrayList<WebElement> industries = new ArrayList<WebElement> (webDriver.findElements(By.xpath("//div[@id='edit_field_industry_chosen']/div/ul/li")));
		for (int i = 0; i < industries.size(); i++){
			if (industries.get(i).getText().contains(industry)){
				getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(industries.get(i)));
				new Actions(webDriver).moveToElement(industries.get(i)).perform();
				industries.get(i).click();			
			}		
		}
	}
	
	public void chooseValueChain(String valueChain){
		industryField.click();
	    getWebDriverWait(10).until(ExpectedConditions.attributeContains(webDriver.findElement(By.
	    		xpath("//div[@id='edit_field_industry_chosen']")), "class", "chosen-container-active"));
	    ArrayList<WebElement> industries = new ArrayList<WebElement> (webDriver.findElements(By.xpath("//div[@id='edit_field_industry_chosen']/div/ul/li")));
		for (int i = 0; i < industries.size(); i++){
			
			  if (industries.get(i).getText().contains(valueChain)){
				getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(industries.get(i)));
				new Actions(webDriver).moveToElement(industries.get(i)).click().build().perform();
				//industries.get(i).click();	
			}
		}
	}
	
	public void clickOnOverviewTabAndSetValue(String txt){
		overviewTab.click();
		getWebDriverWait(5).until(ExpectedConditions.elementToBeClickable(By.xpath("(//iframe)[2]")));
		//return webDriver.findElement(By.xpath("(//*[@class='cke_wysiwyg_frame cke_reset'])[2]"));
		webDriver.switchTo().frame(overviewFrame);
		getJSExecutor().executeScript("arguments[0].innerText='TEST TEST TEST'", webDriver.findElement(By.xpath("//body/p")));
		//webDriver.findElement(By.xpath("//body/p")).sendKeys(txt);
		webDriver.switchTo().defaultContent();
		
	}
	
	public void openTechDataNamesTabAndChooseTDN(String TDN){
		technicalDataTab.click();
		getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(technicalDataNameDrop));
		technicalDataNameDrop.click();
		getWebDriverWait(10).until(ExpectedConditions.attributeContains(webDriver.findElement(By.
	    		xpath("//*[@id='edit_field_technical_data_values_0_subform_field_line_form_inline_entity_form_field_name_chosen']")),
				"class", "chosen-container-active"));
		ArrayList <WebElement> technicalDataNameList = new ArrayList<WebElement> (webDriver.findElements(By.xpath("//div[@id='edit_field_technical_data_values_"
				+ "0_subform_field_line_form_inline_entity_form_field_name_chosen']//ul/li")));
		for (int i = 0; i < technicalDataNameList.size(); i++){
			
			  if (technicalDataNameList.get(i).getText().contains(TDN)){
				getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(technicalDataNameList.get(i)));
				new Actions(webDriver).moveToElement(technicalDataNameList.get(i)).click().build().perform();
				//industries.get(i).click();	
			}
		}			
	}
	
	public void setTDvalueAndclickCreateLineBtn(String TDValue){
		webDriver.switchTo().frame(TDValueFrame);
		getJSExecutor().executeScript("arguments[0].innerText='123 Value'", webDriver.findElement(By.xpath("//body/p")));
		//webDriver.findElement(By.xpath("//body/p")).sendKeys(txt);
		webDriver.switchTo().defaultContent();
		createTechnicalDataLineBtn.click();
		getWebDriverWait(4000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//fieldset/div[@class='fieldset-wrapper'])[1]")));
	}
	
	public void openSliderTab(){
		getWebDriverWait(5000).until(ExpectedConditions.elementToBeClickable(sliderTab));
		sliderTab.click();
		getWebDriverWait(10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//fieldset[@id='edit-field-slider-form']")));
	}
	
	public void setMediaNameFieldAndPicture(String mediaName){
		mediaNameField.sendKeys(mediaName);
		
		String primaryWindow = webDriver.getWindowHandle();
		openFileBrowserBtn.click();
		for(String winHandle : webDriver.getWindowHandles()){
		    webDriver.switchTo().window(winHandle);
		}
		getWebDriverWait(10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='imce-folder-content clearfix']/*")));
		new Actions(webDriver).moveToElement(webDriver.findElement(By.xpath("//div[contains(text(),'adam-kool-11868.jpg')]/.."))).doubleClick().build().perform();
		//webDriver.close();
		webDriver.switchTo().window(primaryWindow);
		getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div/span/a[contains(@type,'image/jpeg')]")));
		createSlideBtn.click();
		getWebDriverWait(3000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//fieldset/div[@class='fieldset-wrapper'])[4]")));
	}
	
	public boolean isElemDisplayed(){
		if(title.isDisplayed() && title.isEnabled()){
			return true;
		}else 
			return false;
	}
	
	public ProductPageUI clickSaveAndPublish(){
		getWebDriverWait(5000);
		saveAndPublishBtn.click();
		return MyPageFactory.initElements(webDriver, ProductPageUI.class);
	}
	
	public ProductTemplate(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		// TODO Auto-generated method stub
		return ExpectedConditions.urlToBe("https://schleuniger.rolique.space/global/en/node/add/product");
	}

}
