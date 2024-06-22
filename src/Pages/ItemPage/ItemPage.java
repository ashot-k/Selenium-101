package Pages.ItemPage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//img[@data-test='item-sauce-labs-backpack-img']")
    private WebElement backPackImg;

    public void checkIfBackPackImgMatchesInventory(String inventoryBackPackImgSrc){
        Assert.assertEquals(backPackImg.getAttribute("src"), inventoryBackPackImgSrc);
    }
}
