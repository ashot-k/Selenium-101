package Tests;

import Pages.CartPage.CartPage;
import Pages.CheckoutPage.CheckoutStepOnePage;
import Pages.CheckoutPage.CheckoutStepTwoPage;
import Pages.InventoryPage.InventoryPage;
import Pages.Login.LoginPage;
import Utils.Log;
import org.testng.annotations.Test;

public class CheckoutStepTwoPageTests extends TestBase{
    private String validUserName = "standard_user";
    private String validPassword = "secret_sauce";
    private String name = "john";
    private String lastName = "jones";

    private String postalCode = "54321";

    private double expectedTotalPrice = 86.38;

    private double expectedPrice1 = 29.99;
    private double expectedPrice2 = 49.99;
    @Test
    public void checkoutStepTwoValidateProductPrices(){
        Log.info("Start Test Case: checkoutStepTwoValidateProductPrices");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.addFleeceJacketToCart();
        inventoryPage.goToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckout();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterInfoAndContinue(name, lastName, postalCode);
        checkoutStepOnePage.goToStepTwo();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.verifyProductPrices(expectedPrice1, expectedPrice2);
    }
    @Test
    public void checkoutStepTwoValidateTotalPrice(){
        Log.info("Start Test Case: checkoutStepTwoValidateTotalPrice");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.addFleeceJacketToCart();
        inventoryPage.goToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckout();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterInfoAndContinue(name, lastName, postalCode);
        checkoutStepOnePage.goToStepTwo();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.verifyTotalPrice(expectedTotalPrice);
    }
}
