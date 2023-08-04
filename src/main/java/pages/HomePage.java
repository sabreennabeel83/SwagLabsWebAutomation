package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {

    private WebDriver driver;
    private By chickLogin = By.cssSelector(".title");
    private By dropdown = By.cssSelector(".product_sort_container");
    private By cart = By.id("shopping_cart_container");



    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public String getPageContext(){
        return driver.findElement(chickLogin).getText();
    }


    public void selectFromDropDown(String option){
        findDropDownElement().selectByVisibleText(option);
    }
    public List<String> getSelectedOptions(){
       List<WebElement> selectedElements=
               findDropDownElement().getAllSelectedOptions();
       return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
      }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }


    public void selectItemFromHomePage(String item){
        selectItemAddToCart(item);
    }
    private void selectItemAddToCart(String item){
        driver.findElement(By.id(item)).click();
    }
    public int getNumberOfItemsInCart() {
        WebElement cartElement = driver.findElement(cart);
        List<WebElement> cartItems = cartElement.findElements(By.cssSelector(".shopping_cart_badge"));
        return cartItems.size();
    }

   public SelectedItemPage selectedItem(String item){
          selectItem(item);
          return new SelectedItemPage(driver);
    }
    private void selectItem(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }


    public CartPage clickCartButton(){
        driver.findElement(cart).click();
        return new CartPage(driver);

    }
}
