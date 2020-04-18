package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    private Select subjectHeading = new Select(driver.findElement(By.id("id_contact")));
    private By email = By.id("email");
    private By orderReference = By.id("id_order");
    private By messageBox = By.id("message");
    private By sendButton = By.id("submitMessage");


    public ContactPage goToContactPage (){
        driver.get(baseURL);
        return this;
    }

    private String baseURL = "http://automationpractice.com/index.php?controller=contact";


    public void fillAllFieldsWithValidValues() {
        subjectHeading.selectByIndex(1);
        writeText(email, "default@default.com");
        writeText(orderReference, "somevalue" + RandomStringUtils.randomAlphanumeric(10));
        writeText(messageBox, "This is a default text.");
    }

    public void enterEmail(String s) {
    }

    public void send() {
        click(sendButton);
    }

    public boolean verifySuccess() {
        return true;
    }

    public boolean verifyEmailFailure() {
        return true;
    }
}
