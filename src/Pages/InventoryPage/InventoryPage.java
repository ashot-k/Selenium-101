package Pages.InventoryPage;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.math.BigDecimal;
import java.util.List;

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

    @FindBy(id = "item_4_img_link")
    private WebElement backPackLink;

    @FindBy(xpath = "//a[@data-test='item-3-title-link']/div[@data-test='inventory-item-name']")
    private WebElement tshirtLink;

    @FindBy(xpath = "//img[@data-test='inventory-item-sauce-labs-backpack-img']")
    private WebElement backPackImg;

    @FindBy(xpath = "//div[@data-test='inventory-list']//div[@data-test='inventory-item']")
    private List<WebElement> items;

    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    private WebElement sortOptionSelect;

    @FindBy(xpath = "//span[@data-test='shopping-cart-badge']")
    private WebElement cartBadge;

    public void changeSortOption(String option) {
        sortOptionSelect.click();
        WebElement optionElement = sortOptionSelect.findElement(By.xpath(".//option[@value='" + option + "']"));
        optionElement.click();
    }

    public void ascendingNameOrderCheck() {
        WebElement prevItem = null;
        for (WebElement item : items) {
            if (prevItem != null) {
                String currentText = item.findElement(By.xpath(".//div[@data-test='inventory-item-name']")).getText();
                String prevText = prevItem.findElement(By.xpath(".//div[@data-test='inventory-item-name']")).getText();
                Assert.assertTrue(currentText.compareToIgnoreCase(prevText) >= 0, "Names are not sorted");
            }
            prevItem = item;
        }
    }

    public void descendingNameOrderCheck() {
        WebElement prevItem = null;
        for (WebElement item : items) {
            if (prevItem != null) {
                String currentText = item.findElement(By.xpath(".//div[@data-test='inventory-item-name']")).getText();
                String prevText = prevItem.findElement(By.xpath(".//div[@data-test='inventory-item-name']")).getText();
                Assert.assertTrue(currentText.compareToIgnoreCase(prevText) <= 0, "Names are not sorted");
            }
            prevItem = item;
        }
    }

    public void descendingPriceOrderCheck(){
        WebElement prevItem = null;
        for (WebElement item : items) {
            if (prevItem != null) {
                BigDecimal currentPrice = new BigDecimal(item.findElement(By.xpath(".//div[@data-test='inventory-item-price']")).getText().substring(1));
                BigDecimal prevPrice = new BigDecimal(prevItem.findElement(By.xpath(".//div[@data-test='inventory-item-price']")).getText().substring(1));
                Assert.assertTrue(currentPrice.compareTo(prevPrice) < 0 || currentPrice.equals(prevPrice), "Prices are not sorted");
            }
            prevItem = item;
        }
    }

    public void ascendingPriceOrderCheck(){
        WebElement prevItem = null;
        for (WebElement item : items) {
            if (prevItem != null) {
                BigDecimal currentPrice = new BigDecimal(item.findElement(By.xpath(".//div[@data-test='inventory-item-price']")).getText().substring(1));
                BigDecimal prevPrice = new BigDecimal(prevItem.findElement(By.xpath(".//div[@data-test='inventory-item-price']")).getText().substring(1));
                Assert.assertTrue(currentPrice.compareTo(prevPrice) > 0 || currentPrice.equals(prevPrice), "Prices are not sorted");
            }
            prevItem = item;
        }
    }

    public void cartBadgeNumberCheck(int expectedNumber){
       int cartBadgeNumber =  Integer.parseInt(cartBadge.getText());
        Assert.assertEquals(cartBadgeNumber, expectedNumber);
    }

    public void addBikeLightToCart() {
        addToCartBikeLight.click();
    }

    public void addBackpackToCart() {
        addToCartBackPack.click();
    }

    public void addFleeceJacketToCart() {
        addToCartFleeceJacket.click();
    }

    public void goToCartPage() {
        shoppingCartLink.click();
    }

    public void goToBackpackItemPage() {
        backPackLink.click();
    }
    public void goToTShirtPage(){
        tshirtLink.click();
    }

    public String getBackPackImg() {
        return backPackImg.getAttribute("src");
    }

}
