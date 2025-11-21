import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends ApplicationManager {
    @BeforeMethod
    public void goToLoginPage(){
        new HomePage(getDriver()).clickBtnLoginHeader();

    }
    @Test
    public void positiveLoginTest(){
        User user = new User("brakerilya123@gmail.com","Password123!");
        new LoginPage(getDriver()).typeLoginFormWithUser(user);
        Assert.assertTrue(new ContactsPage(getDriver()).isTextAddPresent("ADD"));
    }
}
