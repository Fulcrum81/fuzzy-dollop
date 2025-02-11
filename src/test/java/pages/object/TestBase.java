package pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.object.enums.Browser;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    protected void methodSetup() {
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome"));

        driver = switch (browser) {
            case chrome -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-certificate-errors");
                yield new ChromeDriver(options);
            }
            case firefox -> new FirefoxDriver();
            case edge -> new EdgeDriver();
            case safari -> new SafariDriver();
        };

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");

        //login
    }



    @AfterMethod
    protected void methodTeardown() {
        driver.quit();
    }
}
