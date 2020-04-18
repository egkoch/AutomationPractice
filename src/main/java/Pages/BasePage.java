package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public WebDriverWait shortWait;

    public BasePage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver,15);
        this.shortWait = new WebDriverWait(driver,3);
    }

    public void click (By elementBy) {

        driver.findElement(elementBy).click();
    }


    public void writeText (By elementBy, String text) {

        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }


    public String readText (By elementBy) {

        return driver.findElement(elementBy).getText();
    }


    public void log (String text) {

        System.out.println(text);
    }


    public void waitFor(By elem) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
    }

}
