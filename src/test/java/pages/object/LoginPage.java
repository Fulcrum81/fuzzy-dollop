package pages.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.object.helpers.Locators;

import static pages.object.helpers.Locators.getLocator;

public class LoginPage extends PageBase {

    public HeaderMenu headerMenu;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
//        super(driver);
        headerMenu = new HeaderMenu(driver);
    }

    public void login(String email, String password) {
        driver.findElement(getLocator("LoginPage.emailInput")).sendKeys(email);
        driver.findElement(getLocator("LoginPage.passwordInput")).sendKeys(password);
        driver.findElement(getLocator("LoginPage.loginButton")).click();

        String color = driver.findElement(getLocator("LoginPage.loginButton")).getCssValue("background");

        Assert.assertEquals(color, "#");
    }
}
