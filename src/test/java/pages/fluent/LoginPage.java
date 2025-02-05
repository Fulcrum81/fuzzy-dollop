package pages.fluent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginMessagePage login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();

        return new LoginMessagePage(driver);
    }

    public LoginPage enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public pages.fluent.LoginMessagePage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginMessagePage(driver);
    }
}
