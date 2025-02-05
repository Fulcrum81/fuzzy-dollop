package pages.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    public HeaderMenu headerMenu;
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
//        super(driver);
        headerMenu = new HeaderMenu(driver);
    }

    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
