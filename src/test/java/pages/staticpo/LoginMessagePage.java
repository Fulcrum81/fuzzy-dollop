package pages.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginMessagePage {

    private static By message = By.cssSelector("#notices>.notice");

    public static String getMessage(WebDriver driver) {
        return driver.findElement(message).getText();
    }
}
