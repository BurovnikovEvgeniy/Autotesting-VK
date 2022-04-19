package Utils;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TopToolbarDecorator {
    private static final By TOP_TOOLBAR = new By.ByXPath(".//*[contains(@data-l, \"t,navigationToolbar\")]");

    public static void open(By path) {
        if (checkPossibilityInteraction()) {
            throw new RuntimeException("Illegal logic");
        }
        $(path).click();
    }
    public static void close() {
        if (checkPossibilityInteraction()) {
            throw new RuntimeException("Toolbar was not used. Not a single window is open");
        }
        $(TOP_TOOLBAR).click();
    }
    private static boolean checkPossibilityInteraction() {
        return !$(TopToolbarDecorator.TOP_TOOLBAR).isDisplayed();
    }
}

