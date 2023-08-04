package pagesTests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RemoveItemsFromCartPageTests extends BaseTests {



    @Test( priority = 1)
    public void testSuccessfulLogin(){
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        assertTrue(homePage.getPageContext().contains("Products")
                ,"Login is incorrect" );


    }

    @Test(priority = 2)
    public void testFilterItems() {
        homePage = new HomePage(driver);
        String option = "Price (high to low)";
        homePage.selectFromDropDown(option);
        var selectedOptions = homePage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }
    @Test(priority = 3)
    public void testSelectedItemsFromHomePage(){
        homePage = new HomePage(driver);
        String item1 = "add-to-cart-sauce-labs-backpack";
        String item2 = "add-to-cart-sauce-labs-bolt-t-shirt";
        homePage.selectItemFromHomePage(item1);
        homePage.selectItemFromHomePage(item2);
        var selectedOptions = homePage.getNumberOfItemsInCart();
        assertEquals(2,2, selectedOptions, "Item is not added to cart");

    }

    @Test(priority = 4)
    public void testRemoveItemFromCartPagAndContinueShopping(){
       var cartPage= homePage.clickCartButton();
        String item = "remove-sauce-labs-backpack";
        cartPage.removeItemFromCartPage(item);
        var selectedOptions = cartPage.getNumberOfItemsInCart();
        HomePage homePage1 =cartPage.clickContinueShoppingButton();
        assertEquals(1, selectedOptions, "Item is not deleted from cart");

    }

}
