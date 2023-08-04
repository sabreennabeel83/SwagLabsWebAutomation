package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By cart = By.id("shopping_cart_container");
    private By backToHomePage = By.id("continue-shopping");
    private By checkoutbutton =By.id("checkout");



    public CartPage(WebDriver driver){
        this.driver=driver;
    }

    private void removeItem(String item){
        driver.findElement(By.id(item)).click();
    }

    public void removeItemFromCartPage(String item){
        removeItem(item);
    }

    public int getNumberOfItemsInCart() {
        WebElement cartElement = driver.findElement(cart);
        List<WebElement> cartItems = cartElement.findElements(By.cssSelector(".shopping_cart_badge"));
        return cartItems.size();
    }

    public HomePage clickContinueShoppingButton(){
        driver.findElement(backToHomePage).click();
        return new HomePage(driver);

    }

    public CheckoutYourInformationPage clickCheckoutButton(){
        driver.findElement(checkoutbutton).click();
        return new CheckoutYourInformationPage(driver);

    }
}
