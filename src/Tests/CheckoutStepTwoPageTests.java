package Tests;

import Pages.CartPage.CartPage;
import Pages.CheckoutPage.CheckoutStepOnePage;
import Pages.CheckoutPage.CheckoutStepTwoPage;
import Pages.InventoryPage.InventoryPage;
import Pages.Login.LoginPage;
import Utils.Log;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CheckoutStepTwoPageTests extends TestBase {
    private String validUserName = "standard_user";
    private String validPassword = "secret_sauce";
    private String name = "john";
    private String lastName = "jones";
    private String postalCode = "54321";

    @Test
    public void TestVerifyTotalItems() {
        int expectedNumberOfItems = 3;
        Log.info("Start Test Case: TestVerifyTotalItems");
        System.out.println();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.AddBackpackToCart();
        inventoryPage.AddFleeceJacketToCart();
        inventoryPage.AddBikeLightToCart();
        inventoryPage.GoToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.GoToCheckout();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.EnterInfo(name, lastName, postalCode);
        checkoutStepOnePage.GoToStepTwo();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.VerifyTotalItems(expectedNumberOfItems);
    }

    @Test
    public void TestValidateProductPrices() {
        BigDecimal expectedPrice1 = new BigDecimal("29.99");
        BigDecimal expectedPrice2 = new BigDecimal("49.99");
        Log.info("Start Test Case: TestValidateProductPrices");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.AddBackpackToCart();
        inventoryPage.AddFleeceJacketToCart();
        inventoryPage.GoToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.GoToCheckout();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.EnterInfo(name, lastName, postalCode);
        checkoutStepOnePage.GoToStepTwo();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.VerifyProductPrices(expectedPrice1, expectedPrice2);
    }

    @Test
    public void TestValidateTotalPrice() {
        BigDecimal expectedTotalPrice = new BigDecimal("86.38");
        Log.info("Start Test Case: TestValidateTotalPrice");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.AddBackpackToCart();
        inventoryPage.AddFleeceJacketToCart();
        inventoryPage.GoToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.GoToCheckout();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.EnterInfo(name, lastName, postalCode);
        checkoutStepOnePage.GoToStepTwo();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.VerifyTotalPrice(expectedTotalPrice);
    }
}
