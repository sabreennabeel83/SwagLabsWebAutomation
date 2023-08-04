package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {
    private WebDriver driver;
    private By firstnameFeild =By.id("first-name");
    private By lastnameFeild =By.id("last-name");
    private By zipcodeFeild =By.id("postal-code");




    public CheckoutYourInformationPage(WebDriver driver){
        this.driver=driver;
    }
    public void setFirstname(String username){
        driver.findElement(firstnameFeild).sendKeys(username);
    }
    public void setLastname(String username){
        driver.findElement(lastnameFeild).sendKeys(username);
    }
    public void setZipcode(String username){
        driver.findElement(zipcodeFeild).sendKeys(username);
    }

    public OverviewPage clickContinueButton(){
        driver.findElement(By.id("continue")).click();
        return new OverviewPage(driver);
    }






}
