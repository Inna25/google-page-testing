package pageobject_model.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;

public class SearchFunctionTest extends BaseTest{
    private HomePage homePage;
    private static final String KEYWORDS = "Selenium";

    @BeforeMethod
    @Override
    public void setUp(){
        super.setUp();
        homePage = new HomePage(driver).openPage().closeBanner();
    }

    @Test(description = "Some articles contained keywords in the name were found while using the Enter button")
    public void searchProductResultsNotEmptyUsingKeyboardTest() {
        int searchResultsNumber = homePage
                .searchForTermUsingKeyboard(KEYWORDS)
                .countSearchResults();
        Assert.assertTrue(searchResultsNumber > 0, "Search result is empty!");
    }
}
