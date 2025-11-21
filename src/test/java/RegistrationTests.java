import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;


import static utils.User_Factory.*;

public class RegistrationTests extends ApplicationManager {
    @BeforeMethod
    public void goToLoginPage(){
        new HomePage(getDriver()).clickBtnLoginHeader();
    }
    @Test
    public void positiveRegTest(){
        User user = positiveUser();
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.typeRegFormWithUser(user);
        Assert.assertTrue(new ContactsPage(getDriver()).isNoContactsHerePresent());
    }
    @Test
    public void NegativeRegTestWrongEmail(){
        User user = positiveUser();
        user.setUsername("111");
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.typeRegFormWithUser(user);
        Assert.assertTrue(loginPage.closeAlertReturnText().contains("Wrong email or password format"));
    }
    @Test
    public void NegativeRegTestWrongPassword(){
        User user = positiveUser();
        user.setPassword("111");
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.typeRegFormWithUser(user);
        Assert.assertTrue(loginPage.closeAlertReturnText().contains("Wrong email or password format"));
    }


}
