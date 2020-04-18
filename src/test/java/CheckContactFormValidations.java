import Pages.ContactPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckContactFormValidations extends BaseTest {
    //HomePage homePage = new HomePage(driver);
    ContactPage contactPage = new ContactPage(driver);

    @Test
    public void verifyEmailAddressFieldValidation() {
        contactPage.goToContactPage();
        contactPage.fillAllFieldsWithValidValues();
        contactPage.enterEmail("test@mail.com");
        contactPage.send();
        Assert.assertTrue(contactPage.verifySuccess());

        contactPage.goToContactPage();
        contactPage.fillAllFieldsWithValidValues();
        contactPage.enterEmail("test@@.com");
        contactPage.send();
        Assert.assertTrue(contactPage.verifyEmailFailure());

    }

   /* @Test
    public void verifyOrderReferenceFieldValidation()  {

    }
*/


}