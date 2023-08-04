package pagesTests;


import pagesTests.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTests {


@Test
    public void testSuccessfulLogin(){
    loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
   assertTrue(homePage.getPageContext().contains("Products")
           ,"Login is incorrect" );


    }
}

