import Pages.ContactPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckContactFormValidations extends BaseTest {


    @Test
    public void verifyValidEmailAddress() {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.log("Verifying valid email address validation...");
        contactPage.goToContactPage();
        contactPage.fillAllFieldsWithValidValues();
        contactPage.enterEmail("test@mail.com");
        contactPage.send();
        Assert.assertTrue(contactPage.verifySuccess());
    }

    @Test
    public void verifyInvalidEmailAddress() {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.log("Verifying invalid email address validation...");
        contactPage.goToContactPage();
        contactPage.fillAllFieldsWithValidValues();
        contactPage.enterEmail("test@@.com");
        contactPage.send();
        Assert.assertTrue(contactPage.verifyEmailFailure());
    }

    @Test
    public void verifyValidOrderReference() {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.log("Verifying valid Order reference validation...");
        contactPage.goToContactPage();
        contactPage.fillAllFieldsWithValidValues();
        // valid Order reference field filled in previous line
        contactPage.send();
        Assert.assertTrue(contactPage.verifySuccess());
    }

    @Test
    public void verifyInvalidOrderReference() {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.log("Verifying invalid Order reference validation...");
        contactPage.goToContactPage();
        contactPage.fillAllFieldsWithValidValues();
        contactPage.enterOrderReference("/*#$#\"$&(()#\"&/#\"$)&#/$\"(/(#$\"&)(/)(/;..2.32.,3.2,.-.-.,.-.-.,");
        contactPage.send();
        Assert.assertTrue(contactPage.verifyOrderReferenceFailure());
    }


}