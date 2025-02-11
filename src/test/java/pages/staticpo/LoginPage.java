package pages.staticpo;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");

    public static void login(String email, String password) {
        $(emailInput).sendKeys(email);
        $(passwordInput).sendKeys(password);
        $(loginButton).click();
        $(loginButton).shouldHave(Condition.cssValue("background", "#kjvhsdkvjhs"));

    }
}
