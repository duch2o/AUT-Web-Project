package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeTest
    @Parameters({"browser"})
    public void beforeTest(String browser) throws MalformedURLException {
        if(browser.equals("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("lang=en-GB");
            chromeOptions.setCapability("platformName","Windows");

//            chromeOptions.addArguments("--headless=new");
//        chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe ");
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),chromeOptions);
            driver.manage().window().maximize();
        }
        if(browser.equals("firefox")){
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("intl.accept_languages", "en-GB");
            FirefoxOptions firefoxOptions=new FirefoxOptions();
            firefoxOptions.setProfile(profile);
            firefoxOptions.setCapability("platformName","Windows");
//            firefoxOptions.setHeadless(true);
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),firefoxOptions);
            driver.manage().window().maximize();
        }

    }
    @AfterTest
    public void after(){
        driver.close();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
