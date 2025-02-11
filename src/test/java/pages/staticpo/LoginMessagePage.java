package pages.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginMessagePage {

    private static By message = By.cssSelector("#notices>.notice");

    public static void validateMessage(String expectedMessage) {
        $(message).shouldHave(text(expectedMessage));
    }
}
