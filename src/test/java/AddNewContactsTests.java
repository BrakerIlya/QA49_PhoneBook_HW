import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.ContactFactory;
import utils.HeaderMenuItem;

public class AddNewContactsTests extends ApplicationManager {
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
}
