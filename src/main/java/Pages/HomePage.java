package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private JavascriptExecutor jse = ((JavascriptExecutor) driver);
    private String baseURL = "https://www.automationpractice.com";


    public HomePage goToHomepage (){

        driver.get(baseURL);
        return this;
    }


}