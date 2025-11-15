import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import static utils.User_Factory.*;

public class LoginTests extends ApplicationManager {
    @BeforeMethod
    public void goToLoginPage(){
        new HomePage(getDriver()).clickBtnLoginHeader();

    }
    @Test
    public void positiveLoginTest(){
        User user = new User("brakerilya123@gmail.com","Password123!");
        new LoginPage(getDriver()).typeLoginFormWithUser(user);
        Assert.assertTrue(new ContactPage(getDriver()).isTextAddPresent("ADD"));
    }
}
