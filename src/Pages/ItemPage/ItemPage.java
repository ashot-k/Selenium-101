package Pages.ItemPage;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//img[@data-test='item-sauce-labs-backpack-img']")
    private WebElement itemImg;

    @FindBy(xpath = "//button[@data-test='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@data-test='remove']")
    private WebElement removeFromCartButton;

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    private WebElement shoppingCartLink;
    public void checkIfItemPageImgMatchesInventoryPageImg(String inventoryImgSrc){
        Assert.assertEquals(itemImg.getAttribute("src"), inventoryImgSrc);
    }

    public void addItemToCart(){
        addToCartButton.click();
    }
    public void removeItemFromCart(){
        removeFromCartButton.click();
    }

    public void goToCartPage() {
        shoppingCartLink.click();
    }

}
