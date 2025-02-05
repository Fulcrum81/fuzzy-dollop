package pages.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginMessagePage extends PageBase {

    public HeaderMenu headerMenu;
    private By message = By.cssSelector("#notices>.notice");

    public LoginMessagePage(WebDriver driver) {
        this.driver = driver;
//        super(driver);
        headerMenu = new HeaderMenu(driver);
    }

    public String getMessage() {
        return driver.findElement(message).getText();
    }
}
