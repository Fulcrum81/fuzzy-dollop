package pages.object;

import com.epam.reportportal.service.ReportPortal;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.qameta.allure.Allure;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.object.enums.Browser;
import pages.object.listeners.ScreenshotListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Calendar;

import static org.openqa.selenium.OutputType.FILE;

@Listeners(ReportPortalTestNGListener.class)
public class TestBase {

    @BeforeMethod
    protected void methodSetup() {

        WebDriverContainer.getDriver().get("https://litecart.stqa.ru/en/");

        //login
    }



    @AfterMethod
    protected void methodTeardown(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            File screenshot = ((TakesScreenshot)WebDriverContainer.getDriver()).getScreenshotAs(FILE);
//            try {
//                Allure.addAttachment("screenshot", new FileInputStream(screenshot));
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//
//        }

        WebDriverContainer.closeDriver();
    }
}
