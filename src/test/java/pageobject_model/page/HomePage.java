package pageobject_model.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    private static final String HOMEPAGE_URL = "https://www.google.com/";
    public static final String FRAME = "//iframe[@name='account']";
    private static final String BANNER_CLOSE_BUTTON_ID = "W0wltc";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    @FindBy(id = BANNER_CLOSE_BUTTON_ID)
    private WebElement bannerCloseButton;

    @FindBy(xpath = "//span[@class='gb_Rd']")
    private WebElement loginService;

    @FindBy(xpath = "//*[@id='gb']//img")
    private WebElement googleAccount;

    @FindBy(xpath = "//div[@class='q6rarf']//div[contains(text(),'@gmail.com')]")
    private WebElement loggedInUserName;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        return this;
    }

    public SearchByTermsResultsPage searchForTermUsingKeyboard(String term){
        searchInput.sendKeys(term);
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.RETURN).build().perform();
       // WebDriverUtils.waitForElementClickableBy(driver, By.id(BANNER_CLOSE_BUTTON_ID));
        return new SearchByTermsResultsPage(driver);
    }
    public HomePage closeBanner() {
            bannerCloseButton.click();
        return this;
    }
    public AccountsPage goToAccountsPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loginService.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new AccountsPage(driver);
    }

    public Boolean openGoogleAccountProfile(){
        try {
            googleAccount.click();
        } catch (NoSuchElementException e){
            return false;
        }
        return true;
    }
    public String getLoggedInUserName(){
        driver.switchTo().frame(driver.findElement(By.xpath(FRAME)));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String email = loggedInUserName.getText();
        return email;
    }
}
