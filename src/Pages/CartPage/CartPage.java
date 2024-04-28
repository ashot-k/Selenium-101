package Pages.CartPage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String cartPageUrl = "https://www.saucedemo.com/cart.html";

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    public void goToCheckout(){
        checkoutButton.click();
    }
}
