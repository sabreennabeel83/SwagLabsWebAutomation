package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SelectedItemPage {
    private WebDriver driver;
    private By addToCartButton = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");
    private By cart = By.id("shopping_cart_container");
    private By backToHomePage = By.id("back-to-products");
    public SelectedItemPage(WebDriver driver){
        this.driver =driver;
    }

    public void addToCart(){
        driver.findElement(addToCartButton).click();
    }

    public int getNumberOfItemsInCart() {
        WebElement cartElement = driver.findElement(cart);
        List<WebElement> cartItems = cartElement.findElements(By.cssSelector(".shopping_cart_badge"));
        return cartItems.size();
    }

    public HomePage clickBackToProductsButton(){
        driver.findElement(backToHomePage).click();
        return new HomePage(driver);

    }
}
