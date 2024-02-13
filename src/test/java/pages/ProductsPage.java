package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Add new']")
    private WebElement addNew;

    @FindBy(xpath = "//button[normalize-space()='Export']")
    private WebElement exportBtn;

    @FindBy(xpath = "//button[@name='importexcel']")
    private WebElement importBtn;
    @FindBy(id = "delete-selected")
    private WebElement deleteBtn;
    @FindBy(id = "SearchProductName")
    private WebElement searchProductNameInpput;

    @FindBy(id = "SearchWarehouseId")
    private WebElement wareSlect;

    @FindBy(id = "SearchCategoryId")
    private WebElement categorySelect;

    @FindBy(id = "SearchProductTypeId")
    private WebElement productTypeSelect;

    @FindBy(xpath = "//div[@class='row search-row']")
    private WebElement search;
    //div[@class='search-body closed']
    @FindBy(xpath = "//div[@id='product-info']//div[@class='card-header with-border clearfix']")
    private WebElement productInfo;

    @FindBy(xpath = "//div[@id='product-price']//div[@class='card-header with-border clearfix']")
    private WebElement productPrice;

    @FindBy(id = "Name")
    private WebElement nameInput;

    @FindBy(id = "ShortDescription")
    private WebElement descInput;

    @FindBy(id = "Sku")
    private WebElement skuInput;
    @FindBy(xpath = "//div[@class='form-group row']//div[@role='listbox']")
    private WebElement categoInput;

    @FindBy(xpath = "//div[@id='product-price-area']//span//input")
    private WebElement priceInput;
    //div[@id='product-price-area']//span//input

    public boolean verifyProductssPage(){
//        getDirverWait().until(ExpectedConditions.visibilityOf(search));
//        search.click();
        getDirverWait().until(ExpectedConditions.visibilityOf(addNew));
//        System.out.println(searchCategoryNameInpput.isDisplayed());
//        System.out.println(publishedInpput.isDisplayed());
        return addNew.isDisplayed() & exportBtn.isDisplayed() &importBtn.isDisplayed() & deleteBtn.isDisplayed() & searchProductNameInpput.isDisplayed() & wareSlect.isDisplayed() &categorySelect.isDisplayed() & productTypeSelect.isDisplayed();
    }

    public void clickToAddNew(){
        getDirverWait().until(ExpectedConditions.visibilityOf(addNew));
        addNew.click();
    }

    public void inputInfo(String name, String desc,String sku,String cate,String price){
        getDirverWait().until(ExpectedConditions.visibilityOf(productInfo));
        productInfo.click();
        getDirverWait().until(ExpectedConditions.visibilityOf(productPrice));
        productPrice.click();

    }


}
