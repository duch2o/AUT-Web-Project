package tests;

import core.BaseTest;
import core.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CategoriesPage;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.ProductsPage;

public class TC02 extends BaseTest {
    @Test(dataProvider = "testData")
    public void testCase02(String userName,String password){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.navigateToLoginPage();
        loginPage.inputLogginInfo(userName,password);
        loginPage.clickToLogin();
        DashBoardPage dashBoardPage=new DashBoardPage(getDriver());
        Assert.assertTrue(dashBoardPage.verifyMenu());
        dashBoardPage.cliokToCatalog();
        dashBoardPage.cliokToProducts();
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.verifyProductssPage();
        productsPage.clickToAddNew();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }
    @DataProvider(name = "testData")
    public Object[][] gettestData(){
        return ExcelUtil.getTableArray("D:\\TestDataFinalExam.xlsx","TC02",0,2);
    }
}
