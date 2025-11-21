import dto.Contact;
import dto.User;
import manager.ApplicationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.ContactFactory;
import utils.HeaderMenuItem;

public class AddNewContactsTests extends ApplicationManager {
    @FindBy(xpath = "//div[@class=\"contact-page_leftdiv__yhyke\"]/div/div[last()]/h2")
    WebElement lastElementList;
    @FindBy(xpath = "//div[contains(@class,'contact-item-detailed_card')]")
    WebElement itemDetailedCard;
    int numberOfContacts;
    @BeforeMethod
    public void login(){
        new HomePage(getDriver()).clickBtnLoginHeader();
        User user = new User("brakerilya123@gmail.com","Password123!");
        new LoginPage(getDriver()).typeLoginFormWithUser(user);
        numberOfContacts=new ContactsPage(getDriver()).getNumberOfContacts();
        AddPage addPage=BasePage.clickButtonHeader(HeaderMenuItem.ADD);
    }
    @Test
    public  void addNewContactPositiveTest(){
        AddPage addPage = new AddPage(getDriver());
        addPage.typeContactForm(ContactFactory.positiveContact());
        int numberOfContactsAfterAdd=new ContactsPage(getDriver()).getNumberOfContacts();
        Assert.assertEquals(numberOfContactsAfterAdd,numberOfContacts+1);
    }
    @Test
    public  void addNewContactPositiveWithScrollValidateTest(){
        Contact contact=ContactFactory.positiveContact();
        AddPage addPage = new AddPage(getDriver());
        addPage.typeContactForm(contact);
        new ContactsPage(getDriver()).scrollToLastElementList();
        String text = new ContactsPage(getDriver()).getElementText();
        Assert.assertEquals(text,contact.getName());
    }
}
