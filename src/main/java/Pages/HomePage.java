package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private JavascriptExecutor jse = ((JavascriptExecutor) driver);
    private String baseURL = "http://automationpractice.com/index.php";

    private By searchBox = By.name("search_query");
    private By searchButton = By.name("submit_search");
    private By listView = By.xpath("//a[@title='List']");
    private By searchResults = By.xpath("//ul[@class='product_list row list']//p");


    public HomePage goToHomepage (){

        driver.get(baseURL);
        return this;
    }

    public boolean searchResultsRelatesTo(String keyword) {
            log("Checking Search results relates to keyword '" + keyword + "' ... ");
            boolean itRelates = false;

            waitFor(listView);
            click(listView);

            waitFor(searchResults);
            List<WebElement> allElements = driver.findElements(searchResults);

            for (WebElement element: allElements) {
                if ((element.getText()).contains(keyword)) {
                   itRelates = true;
                }
                else {
                    itRelates = false;
                    log("Error: "+ keyword + " keyword not found in search result description text: " + element.getText());
                    break;
                }
            }
        return itRelates;
    }


    public void searchFor(String keyword) {
        writeText(searchBox, keyword);
        click(searchButton);
        log("Searching for " + keyword + "... ");
    }
}