package pages.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.object.helpers.Locators;

import static pages.object.helpers.Locators.getLocator;

public class LoginPage extends PageBase {

    public HeaderMenu headerMenu;

    public LoginPage() {
//        super(driver);
        headerMenu = new HeaderMenu();
    }

    @Step("Login with credentials")
    public void login(String email, String password) {
        WebDriverContainer.getDriver().findElement(getLocator("LoginPage.emailInput")).sendKeys(email);
        WebDriverContainer.getDriver().findElement(getLocator("LoginPage.passwordInput")).sendKeys(password);
        WebDriverContainer.getDriver().findElement(getLocator("LoginPage.loginButton")).click();
    }
}
