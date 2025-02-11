package pages.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentPOTest {

    private WebDriver driver;

    private String loginSuccessMessage = "You are now logged in as %s.";
    private String regularUserEmail = "vadim.zubovich@gmail.com";
    private String regularUserPassword = "Test1234!";
    private String regularUserName = "Vadim Zubovich";

    @BeforeMethod
    public void methodSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void methodTeardown() {
//        driver.quit();
    }

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .enterEmail(regularUserEmail)
                .enterPassword(regularUserPassword)
                .clickLoginButton()
                .validateMessage(loginSuccessMessage);
    }

}
