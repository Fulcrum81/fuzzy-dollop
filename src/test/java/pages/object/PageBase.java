package pages.object;

import org.openqa.selenium.WebDriver;

public class PageBase {

    protected WebDriver driver;
//
//    protected PageBase(WebDriver driver) {
//        this.driver = driver;
//    }

    public String getTitle() {
        return driver.getTitle();
    }
}
