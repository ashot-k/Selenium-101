package Tests;

import Pages.InventoryPage.InventoryPage;
import Pages.Login.LoginPage;
import Utils.Log;
import org.testng.annotations.Test;

public class InventoryPageTests extends TestBase {

    private String validUserName = "standard_user";
    private String validPassword = "secret_sauce";
    private String descNameOrderOption = "za";
    private String ascNameOrderOption = "az";
    private String descPriceOrderOption = "hilo";
    private String ascPriceOrderOption = "lohi";

    @Test
    public void TestAscendingNameOrderValidation(){
        Log.info("Start Test Case: TestAscendingNameOrderValidation");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.ascendingNameOrderCheck();
    }

    @Test
    public void TestDescendingNameOrderValidation(){
        Log.info("Start Test Case: TestDescSortingOfItems");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.changeSortOption(descNameOrderOption);
        inventoryPage.descendingNameOrderCheck();
    }

    @Test
    public void TestDescendingPriceOrderValidation(){
        Log.info("Start Test Case: TestDescendingPriceOrderValidation");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.changeSortOption(descPriceOrderOption);
        inventoryPage.descendingPriceOrderCheck();
    }

    @Test
    public void TestAscendingPriceOrderValidation(){
        Log.info("Start Test Case: TestAscendingPriceOrderValidation");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.changeSortOption(ascPriceOrderOption);
        inventoryPage.ascendingPriceOrderCheck();
    }

    @Test
    public void TestCartBadgeNumberValidation(){
        int expectedNumber = 3;
        Log.info("Start Test Case: TestCartBadgeNumberValidation");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.addFleeceJacketToCart();
        inventoryPage.addBikeLightToCart();
        inventoryPage.cartBadgeNumberCheck(3);
    }

}
