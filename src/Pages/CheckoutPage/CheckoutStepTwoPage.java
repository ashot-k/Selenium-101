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

    @FindBy(xpath = "//div[@data-test='total-label']")
    private WebElement totalPrice;

    @FindBy(xpath = "//div[@data-test='tax-label']")
    private WebElement tax;


    public List<BigDecimal> getPrices(List<WebElement> items){
        List<BigDecimal> itemPrices = new ArrayList<>();
        for (WebElement item: items){
            WebElement itemPrice = item.findElement(By.xpath(".//div[@data-test='inventory-item-price']"));
            itemPrices.add(new BigDecimal(itemPrice.getText().substring(1)));
        }
        return itemPrices;
    }

    public void verifyTotalPrice(BigDecimal expectedTotal){
        List<BigDecimal> itemPrices = new ArrayList<>(getPrices(items));
        BigDecimal total = new BigDecimal("0");
        for (BigDecimal price: itemPrices){
            total = total.add(price);
        }
        BigDecimal taxPrice = new BigDecimal(tax.getText().substring(tax.getText().lastIndexOf("$") + 1));
        total = total.add(taxPrice);
        Assert.assertEquals(total, expectedTotal);
    }

    public void verifyTotalItems(int expectedNumberOfItems){
        Assert.assertEquals(items.size(), expectedNumberOfItems);
    }

    public void verifyProductPrices(BigDecimal expected1, BigDecimal expected2){
        BigDecimal price1 = new BigDecimal(items.get(0).findElement(By.xpath(".//div[@data-test='inventory-item-price']")).getText().substring(1));
        BigDecimal price2 = new BigDecimal(items.get(1).findElement(By.xpath(".//div[@data-test='inventory-item-price']")).getText().substring(1));

        Assert.assertEquals(price1, expected1);
        Assert.assertEquals(price2, expected2);
    }

}
