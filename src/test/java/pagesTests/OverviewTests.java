package pagesTests;

import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OverviewTests extends BaseTests
{





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
        String item = "add-to-cart-sauce-labs-backpack";
        homePage.selectItemFromHomePage(item);
        var selectedOptions = homePage.getNumberOfItemsInCart();
        //var cartPage= homePage.clickCartButton();
        assertEquals(1, selectedOptions, "Item is not added to cart");

    }
    @Test(priority = 4)
    public void testCheckout(){
        var cartPage= homePage.clickCartButton();
        CheckoutYourInformationPage checkoutYourInformationPage=cartPage.clickCheckoutButton();
        checkoutYourInformationPage.setFirstname("Sabreen");
        checkoutYourInformationPage.setLastname("Nabeel");
        checkoutYourInformationPage.setZipcode("123456");
        OverviewPage overviewPage= checkoutYourInformationPage.clickContinueButton();
        assertTrue(overviewPage.getPageContext().contains("Overview")
                ,"Information is incorrect" );

    }

    @Test(priority = 5)
    public void testOverviewAndCompleteShopping(){
        overviewPage=new OverviewPage(driver);
        CompletePage completePage = overviewPage.clickFinishButton();
        assertTrue(completePage.getPageContext().contains("Complete!")
                ," Shopping not completed" );



    }



}
