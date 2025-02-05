package pages.fluent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginMessagePage {

    private WebDriver driver;
    private By message = By.cssSelector("#notices>.notice");

    public LoginMessagePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginMessagePage validateMessage(String expectedMessage) {
        Assert.assertEquals(driver.findElement(message).getText(), expectedMessage);
        return this;
    }
}
