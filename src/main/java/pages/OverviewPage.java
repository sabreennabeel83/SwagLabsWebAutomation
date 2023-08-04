package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    private WebDriver driver;
    private By chickCheckout= By.cssSelector(".title");
    private By finishbutton =By.id("finish");
    public OverviewPage(WebDriver driver){
        this.driver=driver;
    }

    public String getPageContext(){
        return driver.findElement(chickCheckout).getText();

    }

    public CompletePage clickFinishButton(){
        driver.findElement(finishbutton).click();
        return new CompletePage(driver);
    }
}
