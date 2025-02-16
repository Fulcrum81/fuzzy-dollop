package pages.object.listeners;

import com.epam.reportportal.service.ReportPortal;
import io.qameta.allure.Allure;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import pages.object.WebDriverContainer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;

import static org.openqa.selenium.OutputType.FILE;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        File screenshot = ((TakesScreenshot)WebDriverContainer.getDriver()).getScreenshotAs(FILE);

        try {
            Allure.addAttachment("screenshot", new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        ReportPortal.emitLog("screenshot", "ERROR", Calendar.getInstance().getTime(), screenshot);

    }

}
