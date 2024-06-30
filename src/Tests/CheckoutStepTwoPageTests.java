package Tests;

import Pages.CartPage.CartPage;
import Pages.CheckoutPage.CheckoutStepOnePage;
import Pages.CheckoutPage.CheckoutStepTwoPage;
import Pages.InventoryPage.InventoryPage;
import Pages.Login.LoginPage;
import Utils.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CheckoutStepTwoPageTests extends TestBase {
    private String validUserName = "standard_user";
    private String validPassword = "secret_sauce";
    private String name = "john";
    private String lastName = "jones";
    private String postalCode = "54321";

    @BeforeMethod
    public void setUp() {
        Log.info("Logging in and navigating to checkout step one page");
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
    }

    @Test
    public void TestVerifyTotalItems() {
        int expectedNumberOfItems = 2;
        Log.info("Start Test Case: TestVerifyTotalItems");
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.VerifyTotalItems(expectedNumberOfItems);
    }

    @Test
    public void TestValidateProductAndTotalPrices() {
        BigDecimal expectedTotalPrice = new BigDecimal("86.38");
        BigDecimal expectedPrice1 = new BigDecimal("29.99");
        BigDecimal expectedPrice2 = new BigDecimal("49.99");
        Log.info("Start Test Case: TestValidateProductAndTotalPrices");
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.VerifyProductPrices(expectedPrice1, expectedPrice2);
        checkoutStepTwoPage.VerifyTotalPrice(expectedTotalPrice);
    }

}
