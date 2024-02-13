package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashBoardPage extends BasePage {
    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']")
    private WebElement menu;

    @FindBy(xpath = "//p[contains(text(), 'Catalog')]//parent::a")
    private WebElement catalog;

    @FindBy(xpath = "//p[contains(text(), 'Categories')]//parent::a")
    private WebElement categories;

    @FindBy(xpath = "//p[contains(text(), 'Products')]//parent::a")
    private WebElement products;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutBtn;
    //a[normalize-space()='Logout']


    public boolean verifyMenu(){
        getDirverWait().until(ExpectedConditions.visibilityOf(menu));
        return menu.isDisplayed();
    }
    public void cliokToCatalog(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getDirverWait().until(ExpectedConditions.visibilityOf(catalog));
        catalog.click();
    }

    public void cliokToCategories(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        getDirverWait().until(ExpectedConditions.elementToBeClickable(categories));
        getDirverWait().until(ExpectedConditions.visibilityOf(categories));
        categories.click();
    }

    public void cliokToProducts(){
        getDirverWait().until(ExpectedConditions.visibilityOf(products));
        products.click();
    }

    public void clickToLogOut(){
        getDirverWait().until(ExpectedConditions.visibilityOf(logoutBtn));
        logoutBtn.click();
    }
}
