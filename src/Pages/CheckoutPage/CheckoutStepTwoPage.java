package Pages.CheckoutPage;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.List;

import static java.lang.Math.round;

public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }
    public String checkoutStepTwoUrl = "https://www.saucedemo.com/checkout-step-two.html";

    @FindBy(className = "inventory_item_price")
    public List<WebElement> elements;

    @FindBy(xpath = "//div[@data-test='total-label']")
    private WebElement totalPrice;

    public void verifyTotalPrice(double expectedTotal){
        double total = Double.parseDouble(totalPrice.getText().substring((8)));

       /* double total = 0f;
        double tax = Double.parseDouble(taxPrice.getText().substring(6));
        for(WebElement price: elements){
            System.out.println(price.getText());
            total += Double.parseDouble(price.getText().substring(1));
        }
        total += tax;*/

        Assert.assertEquals(total, expectedTotal);
    }

    public void verifyProductPrices(double expected1, double expected2){
        double price1 = Double.parseDouble(elements.get(0).getText().substring(1));
        double price2 = Double.parseDouble(elements.get(1).getText().substring(1));

        Assert.assertEquals(price1, expected1);
        Assert.assertEquals(price2,expected2);
    }

}
