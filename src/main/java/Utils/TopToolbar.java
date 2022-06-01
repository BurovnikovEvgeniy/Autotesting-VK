package Utils;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import Pages.GuestsPage;
import Pages.MainPage;

import static com.codeborne.selenide.Selenide.$;

public class TopToolbar extends ToolbarDecorator {

    private static final By TOP_TOOLBAR = new By.ByXPath(".//*[contains(@data-l, \"t,navigationToolbar\")]");
    private static final By POINT_TO_MAIN_PAGE = new By.ByXPath(".//*[contains(@id, \"topPanelLeftCorner\")]");

    private static final By GUESTS_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,guests\")]");
    public TopToolbar() {
        super(TOP_TOOLBAR);
    }

    public GuestsPage goToGuestsPage() {
        $(GUESTS_BUTTON).shouldBe(Condition.visible).click();
        return new GuestsPage();
    }
    public static MainPage goToMainPage() {
        $(POINT_TO_MAIN_PAGE).shouldBe(Condition.visible).click();
        return new MainPage();
    }
}

