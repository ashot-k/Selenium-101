package Tests;

import Pages.InventoryPage.InventoryPage;
import Pages.ItemPage.ItemPage;
import Pages.Login.LoginPage;
import Utils.Log;
import org.testng.annotations.Test;

public class ItemPageTests extends TestBase{
    private String validUserName = "standard_user";
    private String validPassword = "secret_sauce";

    @Test
    public void TestInventoryPageItemImageMatchesItemPageImage(){
        Log.info("Start Test Case: TestInventoryPageItemImageMatchesItemPageImage");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        String img = inventoryPage.getBackPackImg();
        inventoryPage.goToBackpackItemPage();
        ItemPage itemPage = new ItemPage(driver);
        itemPage.checkIfBackPackImgMatchesInventory(img);
    }

}
