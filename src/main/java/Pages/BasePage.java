package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public WebDriverWait shortWait;

    public BasePage(WebDriver driver){

        this.driver = driver;
        wait = new WebDriverWait(driver,15);
        shortWait = new WebDriverWait(driver,3);
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

    public boolean elementExists(By elem){
        return (driver.findElements(elem)).size()!=0;
    }

    public void justWaitSeconds(int n) throws InterruptedException {
        Thread.sleep(n * 1000);
    }

    public void waitFor(By elem) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        while (!(jse.executeScript("return document.readyState").toString().equals("complete")))
            {
                log("Waiting for page to finish loading...");
                try {
                    justWaitSeconds(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
        wait.until(ExpectedConditions.elementToBeClickable(elem));
    }

}
