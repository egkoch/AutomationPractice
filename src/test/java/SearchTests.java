import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test
    public void verifySearchResults() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomepage();
        homePage.searchFor("hat");
        Assert.assertTrue(homePage.searchResultsRelatesTo("hat"));
    }
}
