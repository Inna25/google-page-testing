package pageobject_model.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPage extends BasePage{
    public static final String INPUT_PASSWORD = "//*[@id='password']//input";

    @FindBy(id = "identifierId")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id='identifierNext']//button")
    private WebElement emailNextButton;

    @FindBy(xpath = INPUT_PASSWORD)
    private WebElement inputPassword;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextButton;

    public AccountsPage(WebDriver driver){
        super(driver);
    }

    public AccountsPage enterLogin(String userEmail){
        inputEmail.sendKeys(userEmail);
        emailNextButton.click();
        return this;
    }
    public HomePage enterPassword(String password){

        inputPassword.sendKeys(password);
        passwordNextButton.click();
        return new HomePage(driver);
    }

    public Boolean inputPasswordIsUnavailable(){
        try {
            inputPassword.isEnabled();
        } catch (NoSuchElementException e){
            return true;
        }
        return false;
    }
}
