package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoriesPage extends BasePage {
    public CategoriesPage(WebDriver driver) {
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
    @FindBy(id = "SearchCategoryName")
    private WebElement searchCategoryNameInpput;

    @FindBy(id = "SearchPublishedId")
    private WebElement publishedInpput;

    @FindBy(xpath = "//i[@class='fas fa-info']")
    private WebElement categoryInfo;

    @FindBy(id = "Name")
    private WebElement categoryNameInput;
    //i[@class='fas fa-info']
    @FindBy(xpath = "//div[@id='category-info']//div[@class='card-body']")
    private WebElement categoryInfoDisplay;

    @FindBy(xpath = "//button[@name='save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    private WebElement message;

    @FindBy(xpath = "//div[@class='search-body closed']")
    private WebElement search;
    //div[@class='search-body closed']

    public boolean verifyCategoriesPage(){
//        getDirverWait().until(ExpectedConditions.visibilityOf(search));
//        if(search.getAttribute("style").equals("display: none;")){
//            search.click();
//        }
        getDirverWait().until(ExpectedConditions.visibilityOf(addNew));
//        System.out.println(searchCategoryNameInpput.isDisplayed());
//        System.out.println(publishedInpput.isDisplayed());
        return addNew.isDisplayed() & exportBtn.isDisplayed() &importBtn.isDisplayed() & deleteBtn.isDisplayed() & searchCategoryNameInpput.isDisplayed() & publishedInpput.isDisplayed();
    }

    public void clickToAddNew(){
        getDirverWait().until(ExpectedConditions.visibilityOf(addNew));
        addNew.click();
    }

    public void clickToCategoryInfo(){
        getDirverWait().until(ExpectedConditions.visibilityOf(categoryInfo));
        if(categoryInfoDisplay.getAttribute("style").equals("none")){
            categoryInfo.click();
        }
    }

    public void inputInfoCategoryName(String name){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getDirverWait().until(ExpectedConditions.visibilityOf(categoryNameInput));
        categoryNameInput.sendKeys(name);
    }

    public void clickToSaveButton(){
        getDirverWait().until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();
    }

    public boolean verifyDisplayMessage(String mes){
        getDirverWait().until(ExpectedConditions.visibilityOf(message));
        String text = message.getText();
        System.out.println(text);
        if(text.contains(mes)){
            return true;
        }
        return false;
    }
}
