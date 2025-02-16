package pages.object;

import org.openqa.selenium.WebDriver;

public class PageBase {

//
//    protected PageBase(WebDriver driver) {
//        this.driver = driver;
//    }

    public String getTitle() {
        return WebDriverContainer.getDriver().getTitle();
    }
}
