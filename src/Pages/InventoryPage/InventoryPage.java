package Pages.InventoryPage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String inventoryPageUrl = "https://www.saucedemo.com/inventory.html";

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBackPack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToCartBikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addToCartFleeceJacket;

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    private WebElement shoppingCartLink;

    public void addBikeLightToCart() {
        addToCartBikeLight.click();
    }
    public void addBackpackToCart(){
        addToCartBackPack.click();
    }
    public void addFleeceJacketToCart(){
        addToCartFleeceJacket.click();
    }
    public void goToCartPage() {
        shoppingCartLink.click();
    }

}
