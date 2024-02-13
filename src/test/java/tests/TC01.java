package tests;

import core.BaseTest;
import core.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CategoriesPage;
import pages.DashBoardPage;
import pages.LoginPage;

public class TC01 extends BaseTest {
    @Test(dataProvider = "testData")
    public void testCase01(String userName,String password,String name,String mes){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.navigateToLoginPage();
        loginPage.inputLogginInfo(userName,password);
        loginPage.clickToLogin();
        DashBoardPage dashBoardPage=new DashBoardPage(getDriver());
        Assert.assertTrue(dashBoardPage.verifyMenu());
        dashBoardPage.cliokToCatalog();
        dashBoardPage.cliokToCategories();
        CategoriesPage categoriesPage = new CategoriesPage(getDriver());
        Assert.assertTrue(categoriesPage.verifyCategoriesPage());
        categoriesPage.clickToAddNew();
        categoriesPage.clickToCategoryInfo();
        categoriesPage.inputInfoCategoryName(name);
        categoriesPage.clickToSaveButton();
        categoriesPage.verifyDisplayMessage(mes);
        dashBoardPage.clickToLogOut();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }
    @DataProvider(name = "testData")
    public Object[][] gettestData(){
        return ExcelUtil.getTableArray("D:\\TestDataFinalExam.xlsx","TC01",0,4);
    }
}
