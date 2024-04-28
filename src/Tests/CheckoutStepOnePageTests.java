package Tests;

import Pages.CartPage.CartPage;
import Pages.CheckoutPage.CheckoutStepOnePage;
import Pages.InventoryPage.InventoryPage;
import Pages.Login.LoginPage;
import Utils.Log;
import org.testng.annotations.Test;

public class CheckoutStepOnePageTests extends TestBase{
    private String validUserName = "standard_user";
    private String validPassword = "secret_sauce";
    private String name = "john";
    private String lastName = "jones";

    private String emptyPostalCode = "";
    @Test
    public void checkoutStepOneErrorValidationTest(){
        Log.info("Start Test Case: checkoutStepOneErrorValidation");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBikeLightToCart();
        inventoryPage.goToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckout();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterInfoAndContinue(name, lastName, emptyPostalCode);
        checkoutStepOnePage.ErrorMessageDisplayed();
    }
}
