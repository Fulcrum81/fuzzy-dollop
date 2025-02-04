import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {

    WebDriver driver;

    @BeforeMethod
    public void methodSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void methodTeardown() {
//        driver.quit();
    }

    @Test
    public void seleniumTest1() {
        driver.get("https://belhard.academy/?utm_medium=cpc&utm_source=google&utm_campaign=Poisk_obshchaya&utm_term=belhard%20academy&gad_source=1&gclid=Cj0KCQiAwOe8BhCCARIsAGKeD54suby4-YMR0p2y9LVTuqec_pWiWnia51vnnQzeIaa1-kzF6UGzfMgaAoQeEALw_wcB");

//        WebElement text = driver.findElement(By.xpath("//*[contains(text(),'Удобный формат обучения')]"));
        WebElement textPart1 = driver.findElement(By.cssSelector("[src='https://static.tildacdn.biz/tild3230-3936-4465-a164-316530616330/star_hand_quality_gu.svg']+div"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(textPart1).keyDown(Keys.CONTROL).keyDown(Keys.ALT).keyDown(Keys.DELETE).release().moveToLocation(150, 200).release().perform();

//        textPart1.click();
//        WebElement textPart2 = driver.findElement(By.cssSelector("[src='https://static.tildacdn.biz/tild3230-3936-4465-a164-316530616330/star_hand_quality_gu.svg']+div p+p>span"));
        Assert.assertEquals(textPart1.getText(), "Более 25 лет на\nрынке IT-образования");
    }

    @Test
    public void rubberDuck() {

        driver.get("https://litecart.stqa.ru/en/");

        WebElement yellowDuckLink = driver.findElement(By.xpath("//div[@id='box-most-popular']//a"));

        WebElement yellowDuckImage = yellowDuckLink.findElement(By.xpath(".//img"));

        yellowDuckImage.click();


        //div[@id='box-most-popular']//img[@alt='Yellow Duck']
    }

    @Test
    public void alertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals(alertText, "I am a JS Alert");
    }

    @Test
    public void confirmOkTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
    }

    @Test
    public void selectTest() {

        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1");

//        WebElement sizeSelect = driver.findElement(By.name("options[Size]"));
//        sizeSelect.click();
//        sizeSelect.findElement(By.cssSelector("[value='Small']")).click();

        Select sizeSelectSelenium = new Select(driver.findElement(By.name("options[Size]")));
        sizeSelectSelenium.selectByValue("Small");


    }

    @Test
    public void ballTest() {
        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1");

        Select sizeSelectSelenium = new Select(driver.findElement(By.name("options[Size]")));
        sizeSelectSelenium.selectByValue("Small");
        driver.findElement(By.name("add_cart_product")).click();

        waitForJQuery(driver, 3);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));


        int actualQuantity = Integer.parseInt(driver.findElement(By.cssSelector("span.quantity")).getText());

        Assert.assertEquals(actualQuantity, 1);

    }

    public void waitForJQuery(WebDriver driver, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        return (Boolean) js.executeScript("return jQuery.active === 0");
                    }
                });
    }

    @Test
    public void multipleWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String initialHandle = driver.getWindowHandle();

        driver.findElement(By.cssSelector("[href='/windows/new']")).click();

        String newTabHandle = driver.getWindowHandles().toArray()[1].toString();

        driver.switchTo().window(newTabHandle);

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");

        driver.close();

        driver.switchTo().window(initialHandle);
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Opening a new window");
    }

    @Test
    public void frameTest() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");

        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(), "RIGHT");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");

        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(), "MIDDLE");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(), "BOTTOM");
    }

    @Test
    public void shadowRootTest() {
        driver.get("https://developer.mozilla.org/en-US/docs/Web/API/Web_components/Using_shadow_DOM");
        new Actions(driver).scrollToElement(driver.findElement(By.id("frame_encapsulation_from_javascript"))).perform();

        driver.switchTo().frame("frame_encapsulation_from_javascript");

        WebElement rootElement = driver.findElement(By.id("host"));
        SearchContext context = rootElement.getShadowRoot();
        WebElement span = context.findElement(By.cssSelector("span"));

        System.out.println(span.getText());

    }
}
