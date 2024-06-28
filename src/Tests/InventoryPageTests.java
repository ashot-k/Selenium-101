package Tests;

import Pages.InventoryPage.InventoryPage;
import Pages.Login.LoginPage;
import Utils.Log;
import org.testng.annotations.Test;

public class InventoryPageTests extends TestBase {

    private String validUserName = "standard_user";
    private String validPassword = "secret_sauce";
    private String descNameOrderOption = "za";
    private String ascPriceOrderOption = "lohi";


    @Test
    public void TestDescendingNameOrderValidation(){
        Log.info("Start Test Case: TestDescSortingOfItems");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.ChangeSortOption(descNameOrderOption);
        inventoryPage.DescendingNameOrderCheck();
    }

    @Test
    public void TestAscendingPriceOrderValidation(){
        Log.info("Start Test Case: TestAscendingPriceOrderValidation");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.ChangeSortOption(ascPriceOrderOption);
        inventoryPage.AscendingPriceOrderCheck();
    }

    @Test
    public void TestCartBadgeNumberValidation(){
        int expectedNumber = 3;
        Log.info("Start Test Case: TestCartBadgeNumberValidation");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.AddBackpackToCart();
        inventoryPage.AddFleeceJacketToCart();
        inventoryPage.AddBikeLightToCart();
        inventoryPage.CartBadgeNumberCheck(3);
    }

}
