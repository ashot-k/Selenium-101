package Tests;

import Pages.CartPage.CartPage;
import Pages.CheckoutPage.CheckoutCompletePage;
import Pages.CheckoutPage.CheckoutStepOnePage;
import Pages.CheckoutPage.CheckoutStepTwoPage;
import Pages.InventoryPage.InventoryPage;
import Pages.Login.LoginPage;
import Utils.Log;
import org.testng.annotations.Test;

public class CheckoutCompletePageTests extends TestBase{
    private String validUserName = "standard_user";
    private String validPassword = "secret_sauce";
    private String name = "john";
    private String lastName = "jones";
    private String postalCode = "54321";
    private String checkoutCompletionMessage = "Thank you for your order!";

    @Test
    public void TestCompleteMessage(){
        Log.info("Start Test Case: TestCompleteMessage");
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
        checkoutStepTwoPage.GoToCheckoutComplete();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.VerifyCompletionMessage(checkoutCompletionMessage);
    }
}
