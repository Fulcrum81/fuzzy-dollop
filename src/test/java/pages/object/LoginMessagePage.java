package pages.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginMessagePage extends PageBase {

    public HeaderMenu headerMenu;
    private By message = By.cssSelector("#notices>.notice");

    public LoginMessagePage() {
        headerMenu = new HeaderMenu();
    }

    @Step("Validate login result message")
    public void validateMessage(String actualMessage) {
        Assert.assertEquals(WebDriverContainer.getDriver().findElement(message).getText(), actualMessage);;
    }
}
