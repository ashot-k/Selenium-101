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
    public void TestInventoryPageItemImgMatchesItemPageImg(){
        Log.info("Start Test Case: TestInventoryPageItemImageMatchesItemPageImage");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        String img = inventoryPage.GetBackPackImg();
        inventoryPage.GoToBackpackItemPage();
        ItemPage itemPage = new ItemPage(driver);
        itemPage.CheckIfItemPageImgMatchesInventoryPageImg(img);
    }

    @Test
    public void TestItemAdditionToCart(){
        String expectedItemName = "Test.allTheThings() T-Shirt (Red)";
        Log.info("Start Test Case: TestItemAdditionToCart");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.GoToShirtPage();
        ItemPage itemPage = new ItemPage(driver);
        itemPage.AddItemToCart();
        itemPage.GoToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.ValidateItemInCart(expectedItemName);
    }
    @Test
    public void TestItemRemovalFromCart(){
        Log.info("Start Test Case: TestItemRemovalFromCart");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.GoToShirtPage();
        ItemPage itemPage = new ItemPage(driver);
        itemPage.AddItemToCart();
        itemPage.RemoveItemFromCart();
        itemPage.GoToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.ValidateEmptyCart();
    }
}
