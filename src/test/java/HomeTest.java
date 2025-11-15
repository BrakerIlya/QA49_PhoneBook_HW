import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends ApplicationManager {
    @Test
    public void firstTest(){
        new HomePage(getDriver());
    }

}
