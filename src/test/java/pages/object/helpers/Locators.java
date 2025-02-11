package pages.object.helpers;

import org.openqa.selenium.By;
import pages.object.enums.LocatorType;

import java.io.InputStream;
import java.util.Properties;

public class Locators {
    private static Properties props = new Properties();

    static {
        InputStream is = Locators.class.getResourceAsStream("/locators.properties");

        try {
            props.load(is);
        } catch (Exception e) {
            System.out.println("Couldn't load property file: " + e.getMessage());
        }
    }

    public static By getLocator(String element) {
        String locator = props.getProperty(element);

        String[] parsedLocator = locator.split("=", 2);

        switch (LocatorType.valueOf(parsedLocator[0])) {
            case id -> { return By.id(parsedLocator[1]); }
            case name -> { return By.name(parsedLocator[1]); }
            case className -> { return By.className(parsedLocator[1]); }
            case css -> { return By.cssSelector(parsedLocator[1]); }
            case xpath -> { return By.xpath(parsedLocator[1]); }
        }
        return null;
    }
}
