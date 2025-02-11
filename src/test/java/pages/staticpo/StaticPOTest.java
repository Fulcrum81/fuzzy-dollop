package pages.staticpo;

import org.testng.annotations.Test;

public class StaticPOTest extends TestBase {
    private String loginSuccessMessage = "You are now logged in as %s.";
    private String regularUserEmail = "vadim.zubovich@gmail.com";
    private String regularUserPassword = "Test1234!";
    private String regularUserName = "Vadim Zubovich";

    @Test
    public void loginTest() {
        LoginPage.login(regularUserEmail, regularUserPassword);
        LoginMessagePage.validateMessage(String.format(loginSuccessMessage, regularUserName));
    }

}
