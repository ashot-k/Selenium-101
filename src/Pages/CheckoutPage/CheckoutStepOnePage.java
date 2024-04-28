package Pages.CheckoutPage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutStepOnePage extends BasePage {
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "first-name")
    private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;
    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;
    @FindBy(id = "continue")
    private WebElement continueButton;
    public String checkoutStepOneUrl = "https://www.saucedemo.com/checkout-step-one.html";

    public void enterInfoAndContinue(String name, String LastName, String postalCode){
        firstNameInput.sendKeys(name);
        lastNameInput.sendKeys(LastName);
        postalCodeInput.sendKeys(postalCode);
        continueButton.click();
    }

    public void goToStepTwo(){

    }

    public void ErrorMessageDisplayed(){
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed on the page.");
        VerifyCurrentUrl(checkoutStepOneUrl);
    }

}
