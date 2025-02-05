package pages.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMessagePage {

    @FindBy(css = "#notices>.notice")
    private WebElement message;

    public String getMessage() {
        return message.getText();
    }
}
