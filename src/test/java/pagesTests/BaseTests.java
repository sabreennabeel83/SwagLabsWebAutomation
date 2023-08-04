package pagesTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

public class BaseTests {
    protected WebDriver driver;
    protected CartPage cartPage;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected CheckoutYourInformationPage checkoutYourInformationPage;
    protected OverviewPage overviewPage;
    protected SelectedItemPage selectedItemPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();


    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
