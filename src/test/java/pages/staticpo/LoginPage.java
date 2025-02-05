package pages.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");

    public static void login(WebDriver driver, String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
