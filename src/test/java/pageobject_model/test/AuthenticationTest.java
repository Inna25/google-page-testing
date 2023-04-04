package pageobject_model.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AuthenticationTest extends BaseTest{
    private static final String CORRECT_LOGIN = "testingformula1@gmail.com";
    private static final String INCORRECT_LOGIN = "testingformula167@gmail.com";
    private static final String CORRECT_PASSWORD = "Zaq12wsx25";
    private static final String INCORRECT_PASSWORD = "Zaq12wsx125";

    private HomePage homePage;

    @BeforeMethod
    @Override
    public void setUp(){
        super.setUp();
        homePage = new HomePage(driver).openPage().closeBanner();
    }

    @Test(description = "User successfully logged in with correct login and password")
    public void oneCanLoginGoogleAccount(){
        String loggedInUserName = "";
        Boolean loggedIn = new HomePage(driver)
                .openPage()
                .goToAccountsPage()
                .enterLogin(CORRECT_LOGIN)
                .enterPassword(CORRECT_PASSWORD)
                .openGoogleAccountProfile();
        if (loggedIn) loggedInUserName = homePage.getLoggedInUserName();
        assertThat(loggedInUserName, is (equalTo(CORRECT_LOGIN)));
    }
    @Test(description = "An invented email was typed as a login, it is impossible to continue logging in")
    public void oneCanNotLoginWithIncorrectLogin(){
        Boolean loginIsIncorrect= new HomePage(driver)
                .openPage()
                .goToAccountsPage()
                .enterLogin(INCORRECT_LOGIN)
                .inputPasswordIsUnavailable();
        assertThat(true, is(loginIsIncorrect));
    }
    @Test(description = "Incorrect password was typed, authentication failed")
    public void oneCanNotLoginWithIncorrectPassword(){
        Boolean loggedIn= new HomePage(driver)
                .openPage()
                .goToAccountsPage()
                .enterLogin(CORRECT_LOGIN)
                .enterPassword(INCORRECT_PASSWORD)
                .openGoogleAccountProfile();
        assertThat(false, is(loggedIn));
    }
}
