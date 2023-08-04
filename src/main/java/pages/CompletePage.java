package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {
    private WebDriver driver;
    private By chickComplet= By.cssSelector(".title");

    public CompletePage(WebDriver driver){
        this.driver=driver;
    }

    public String getPageContext(){
        return driver.findElement(chickComplet).getText();

    }


    public HomePage clickBackHomeButton(){
        driver.findElement(By.id("back-to-products")).click();
        return new HomePage(driver);

    }
}
