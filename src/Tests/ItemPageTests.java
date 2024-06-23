package Tests;

import Pages.CartPage.CartPage;
import Pages.InventoryPage.InventoryPage;
import Pages.ItemPage.ItemPage;
import Pages.Login.LoginPage;
import Utils.Log;
import org.testng.annotations.Test;

public class ItemPageTests extends TestBase{
    private String validUserName = "standard_user";
    private String validPassword = "secret_sauce";

    @Test
    public void TestInventoryPageItemImageMatchesItemPageImage(){
        Log.info("Start Test Case: TestInventoryPageItemImageMatchesItemPageImage");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        String img = inventoryPage.getBackPackImg();
        inventoryPage.goToBackpackItemPage();
        ItemPage itemPage = new ItemPage(driver);
        itemPage.checkIfItemPageImgMatchesInventoryPageImg(img);
    }

    @Test
    public void TestItemAdditionToCart(){
        String expectedItemName = "Test.allTheThings() T-Shirt (Red)";
        Log.info("Start Test Case: TestItemAdditionToCart");

        LoginPage loginPage =  new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.goToTShirtPage();
        ItemPage itemPage = new ItemPage(driver);
        itemPage.addItemToCart();
        itemPage.goToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.validateItemInCart(expectedItemName);
    }
    @Test
    public void TestItemRemovalFromCart(){
        Log.info("Start Test Case: TestItemRemovalFromCart");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.goToTShirtPage();
        ItemPage itemPage = new ItemPage(driver);
        itemPage.addItemToCart();
        itemPage.removeItemFromCart();
        itemPage.goToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.validateEmptyCart();
    }
}
