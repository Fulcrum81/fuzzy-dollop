package pages.staticpo;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeMethod
    public void methodSetup() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--ignore-certificate-errors");

        Configuration.browser = CHROME;
        Configuration.pageLoadTimeout = 5000;
        Configuration.timeout = 5000;
        Configuration.browserSize = "1920x1080";

        open("https://litecart.stqa.ru/en/");

        WebDriver driver = new ChromeDriver(options);

        WebDriverRunner.setWebDriver(driver);

    }

    @AfterMethod
    public void methodTeardown() {
//        driver.quit();
    }
}
