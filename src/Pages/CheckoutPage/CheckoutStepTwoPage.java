package Pages.CheckoutPage;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }
    public String checkoutStepTwoUrl = "https://www.saucedemo.com/checkout-step-two.html";

    @FindBy(className = "cart_item")
    public List<WebElement> items;

    @FindBy(xpath= "//div[@data-test='inventory-item-price']")
    public List<WebElement> prices;
    @FindBy(xpath = "//div[@data-test='total-label']")
    private WebElement totalPrice;

    @FindBy(xpath = "//div[@data-test='tax-label']")
    private WebElement tax;
    @FindBy(xpath = "//button[@data-test='finish']")
    private WebElement finishBtn;

    public List<BigDecimal> GetPrices(List<WebElement> items){
        List<BigDecimal> itemPrices = new ArrayList<>();
        for (WebElement item: items){
            WebElement itemPrice = item.findElement(By.xpath(".//div[@data-test='inventory-item-price']"));
            itemPrices.add(new BigDecimal(itemPrice.getText().substring(1)));
        }
        return itemPrices;
    }

    public void VerifyTotalPrice(BigDecimal expectedTotal){
        List<BigDecimal> itemPrices = new ArrayList<>(GetPrices(items));
        BigDecimal total = new BigDecimal("0");
        for (BigDecimal price: itemPrices){
            total = total.add(price);
        }
        BigDecimal taxPrice = new BigDecimal(tax.getText().substring(tax.getText().lastIndexOf("$") + 1));
        total = total.add(taxPrice);
        Assert.assertEquals(total, expectedTotal, "Total price is incorrect.");
    }

    public void VerifyTotalItems(int expectedNumberOfItems){
        Assert.assertEquals(items.size(), expectedNumberOfItems);
    }

    public void VerifyProductPrices(BigDecimal expected1, BigDecimal expected2){
        BigDecimal price1 = new BigDecimal(prices.get(0).getText().substring(1));
        BigDecimal price2 = new BigDecimal(prices.get(1).getText().substring(1));

        Assert.assertEquals(price1, expected1, "Price of first item is incorrect.");
        Assert.assertEquals(price2, expected2, "Price of second item is incorrect.");
    }

    public void GoToCheckoutComplete(){
        finishBtn.click();
    }

}
