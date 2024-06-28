package Pages.CheckoutPage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage {

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@data-test='complete-header']")
    private WebElement completeHeader;

    public void VerifyCompletionMessage(String expectedMessage){
        Assert.assertEquals(completeHeader.getText(), expectedMessage, "Order Completion Message does not match.");
    }
}
