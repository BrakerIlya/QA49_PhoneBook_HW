package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);

    }
    @FindBy(xpath = "//a[@href='/contacts']")
    WebElement btnContactsHeader;
    @FindBy(xpath = "//div[@class='contact-page_message__2qafk']")
    WebElement divTextNoContacts;
    @FindBy(className = "contact-item_card__2SOIM")
    List<WebElement> contactList;
    @FindBy(xpath = "//div[@class=\"contact-page_leftdiv__yhyke\"]/div/div[last()]/h2")
    WebElement lastElementList;
    @FindBy(xpath = "//a[text()='ADD']")
    WebElement btnAddHeader;
    @FindBy(xpath = "//h1[text()=\" No Contacts here!\"]")
    WebElement noContactsHere;

    
    public boolean isTextContactsPresent(String text) {
        return isTextInElementPresent(btnContactsHeader,text);
    }
    public boolean isTextAddPresent(String text) {
        return isTextInElementPresent(btnAddHeader,text);
    }
    public boolean isNoContactsHerePresent() {
        return isElementDisplayed(noContactsHere);
    }

}
