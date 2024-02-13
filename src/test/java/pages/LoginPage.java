package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    private WebElement userNameInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    private WebElement loginButton;



    public void navigateToLoginPage(){
        getDriver().get("https://admin-demo.nopcommerce.com/login");
        getDriver().manage().window().maximize();
    }


    public void inputLogginInfo(String e, String p){
        getDirverWait().until(ExpectedConditions.visibilityOf(userNameInput));
        userNameInput.clear();
        userNameInput.sendKeys(e);
        passwordInput.clear();
        passwordInput.sendKeys(p);
    }

    public void clickToLogin(){
        getDirverWait().until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public void verifyLoginPage(){
        getDirverWait().until(ExpectedConditions.visibilityOf(userNameInput));
        Assert.assertTrue(userNameInput.isDisplayed());
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
    }

    public void loginDefault(){
        getDirverWait().until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }
}
