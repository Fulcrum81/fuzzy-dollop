package pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    protected void methodSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(options);
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
