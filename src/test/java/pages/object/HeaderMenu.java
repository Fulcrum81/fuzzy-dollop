package pages.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HeaderMenu {

    private By homePageButton = By.cssSelector("i[title='Home']");
    private By rubberDucksLink = By.cssSelector("#site-menu .category-1>a");
    private By subcategoryLink = By.cssSelector("#site-menu .category-2>a");

    public HeaderMenu() {

    }

    public void clickSubcategoryLink() {
        Actions actions = new Actions(WebDriverContainer.getDriver());

        actions.moveToElement(WebDriverContainer.getDriver().findElement(rubberDucksLink))
                .click(WebDriverContainer.getDriver().findElement(subcategoryLink)).perform();
    }

    public void clickHomeLink() {
        WebDriverContainer.getDriver().findElement(homePageButton).click();
    }
}
