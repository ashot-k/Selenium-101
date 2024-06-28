package Tests;

import Pages.InventoryPage.InventoryPage;
import Pages.Login.LoginPage;
import Utils.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{
    private String validUserName = "standard_user";
    private String validPassword = "secret_sauce";
    private String invalidPassword = "invalidPassword";

    @Test
    public void TestSuccessfulLogin() {
        Log.info("Start Test Case: TestSuccessfulLogin");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        loginPage.VerifyCurrentUrl(inventoryPage.inventoryPageUrl);
    }

    @Test
    public void TestFailedLogin() {
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Log.info("Start Test Case: TestFailedLogin");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, invalidPassword);
        loginPage.ErrorMessageDisplayed();
        loginPage.VerifyErrorMessageText(expectedErrorMessage);
    }

    @Test
    public void TestCorrectTitle() {
        String expectedTitle = "Swag Labs";
        Log.info("Start Test Case: TestCorrectTitle");
        driver.get("https://saucedemo.com");
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void TestLogout() {
        Log.info("Start Test Case: TestLogout");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        loginPage.Logout();
        loginPage.VerifyCurrentUrl(loginPage.loginPageUrl);
    }

    @Test
    public void TestLogoutValidation() {
        String expectedErrorMessage = "Epic sadface: You can only access '/inventory.html' when you are logged in.";
        Log.info("Start Test Case: TestLogoutValidation");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        loginPage.Logout();
        driver.navigate().back();
        loginPage.VerifyCurrentUrl(loginPage.loginPageUrl);
        loginPage.ErrorMessageDisplayed();
        loginPage.VerifyErrorMessageText(expectedErrorMessage);
    }
}
