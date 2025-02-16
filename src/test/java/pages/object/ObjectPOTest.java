package pages.object;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Authentication implementation")
@Feature("User login with credentials")
public class ObjectPOTest extends TestBase {

    private final String loginSuccessMessage = "You are now logged in as %s!.";
    private final String loginErrorMessage = "Wrong password or the account is disabled, or does not exist";
    private final String regularUserEmail = "vadim.zubovich@gmail.com";
    private final String regularUserPassword = "Test1234!";
    private final String incorrectPassword = "sdljkfhsjghfwig";
    private final String emptyPassword = "";
    private final String regularUserName = "Vadim Zubovich";

    @Description("Attempt to login with correct credentials: success message should appear")
    @Test(description = "Login test")
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        LoginMessagePage loginMessagePage = new LoginMessagePage();

        loginPage.login(regularUserEmail, regularUserPassword);
        loginMessagePage.validateMessage(String.format(loginSuccessMessage, regularUserName));
    }

    @Description("Attempt to login with incorrect credentials: success message should appear")
    @Test(description = "Incorrect login test")
    public void incorrectLoginTest() {
        LoginPage loginPage = new LoginPage();
        LoginMessagePage loginMessagePage = new LoginMessagePage();

        loginPage.login(regularUserEmail, incorrectPassword);
        loginMessagePage.validateMessage(loginErrorMessage);
    }

    @Story("Redirect to user home page upon login with correct credentials")
    @Description("When user enters correct credentials and clicks login button the user home page appears")
    @Test(description = "Login with correct credentials")
    public void loginWithCorrectCredentialsTest() {

    }

}
