package pages.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HeaderMenu {

    private WebDriver driver;

    private By homePageButton = By.cssSelector("i[title='Home']");
    private By rubberDucksLink = By.cssSelector("#site-menu .category-1>a");
    private By subcategoryLink = By.cssSelector("#site-menu .category-2>a");

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSubcategoryLink() {
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(rubberDucksLink))
                .click(driver.findElement(subcategoryLink)).perform();
    }

    public void clickHomeLink() {
        driver.findElement(homePageButton).click();
    }
}
