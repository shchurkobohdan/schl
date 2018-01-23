package schleuniger.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;

import com.google.common.base.Function;

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
	
	ArrayList<WebElement> categories = new ArrayList<WebElement> (webDriver.findElements(By.xpath("//div[@id='edit_field_category_chosen']/div/ul/li")));
	
	@FindBy(xpath="//div[@id='edit_field_industry_chosen']")
	private WebElement industryField;
	
	ArrayList<WebElement> industries = new ArrayList<WebElement> (webDriver.findElements(By.xpath("//div[@id='edit_field_industry_chosen']/div/ul/li")));
	
	@FindBy(xpath="//div[@id='edit-field-short-description-wrapper']//iframe")
	private WebElement shortDesciption;
	
	@FindBy(xpath="//details[@id='edit-group-overview']")
	private WebElement overviewTab;
	
	@FindBy(xpath="//details[@id='edit-group-overview//iframe']")
	private WebElement overviewFrame;
	
	@FindBy(xpath="//details[@id='edit-group-technical-data']")
	private WebElement technicalDataTab;
	
	@FindBy(xpath="//span[contains(text(),'Select a value')]")
	private WebElement technicalDataNameDrop;
	
    ArrayList <WebElement> technicalDataNameList = new ArrayList<WebElement> (webDriver.findElements(By.xpath("//div[@id='edit_field_technical_data_values_0_subform_field_line_form_inline_entity_form_field_name_chosen']//ul/li")));
	
    @FindBy(xpath="//input[@id='edit-field-technical-data-values-0-subform-field-line-form-inline-entity-"
    		+ "form-actions-ief-add-save--nYzfmFImXBw']")
	private WebElement createTechnicalDataRowBtn;
    
    @FindBy(xpath="//details[@id='edit-group-slider']//a[@href='#edit-group-slider']")
	private WebElement sliderTab;

    @FindBy(xpath="//div[@id='edit-field-slider-form-inline-entity-form-name-wrapper']/div/input")
	private WebElement mediaNameField;
    
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
	
	public void chooseCategory(String category){
		categoryField.click();
		for (int i = 0; i <= categories.size(); i++){
			if (categories.get(i).getText() == category){
				categories.get(i).click();
			}
		}
		
		
		/*for (WebElement i: categories){
			if(i.getText() == category){
				i.click();
			}
		}*/
	}
	
	public boolean isElemDisplayed(){
		if(title.isDisplayed() && title.isEnabled()){
			return true;
		}return false;
	}
	
	public void clickSaveAndPublish(){
		saveAndPublishBtn.click();
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
