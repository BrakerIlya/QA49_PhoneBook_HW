package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    static WebDriver driver;
    public static void setDriver(WebDriver wd){
        driver=wd;

    }
    public boolean isTextInElementPresent(WebElement element, String text) {
        return  element.getText().contains(text);
    }
    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }
}
