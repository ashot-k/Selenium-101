package Pages.CartPage;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String cartPageUrl = "https://www.saucedemo.com/cart.html";

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    public WebElement tshirtName;

    @FindBy(xpath = "//div[@data-test='inventory-item']")
    public List<WebElement> cartItems;

    public void goToCheckout(){
        checkoutButton.click();
    }

    public void validateItemInCart(String expectedItemName){
        Assert.assertEquals(tshirtName.getText(), expectedItemName);
    }
    public void validateEmptyCart(){
        Assert.assertTrue(cartItems.isEmpty());
    }
}
