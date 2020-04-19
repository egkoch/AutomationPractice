package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    private String baseURL = "http://automationpractice.com/index.php?controller=contact";

    private By email = By.id("email");
    private By orderReference = By.id("id_order");
    private By messageBox = By.id("message");
    private By sendButton = By.id("submitMessage");
    private By invalidEmailError = By.xpath("//div[@class='alert alert-danger']//*[contains(text(),'Invalid email address.')]");
    private By successMessage = By.xpath("//p[@class='alert alert-success'][contains(text(),'Your message has been successfully sent to our team.')]");
    private By invalidOrderReferenceError = By.xpath("//*[contains(text(),'Invalid Order reference.')]");

    public ContactPage goToContactPage (){
        driver.get(baseURL);
        return this;
    }

    public void fillAllFieldsWithValidValues() {
        Select subjectHeading = new Select(driver.findElement(By.id("id_contact")));
        subjectHeading.selectByIndex(1);
        writeText(email, "default@default.com");
        writeText(orderReference, "somevalue" + RandomStringUtils.randomAlphanumeric(10));
        writeText(messageBox, "This is a default text.");
    }

    public void enterEmail(String s) {
        writeText(email, s);
    }

    public void send() {
        click(sendButton);
    }

    public boolean verifySuccess() {
        return elementExists(successMessage);
    }

    public boolean verifyEmailFailure() {
        return elementExists(invalidEmailError);
    }

    public void enterOrderReference(String s) {
        writeText(orderReference, s);
    }

    public boolean verifyOrderReferenceFailure() {
        return elementExists(invalidOrderReferenceError);
    }
}
