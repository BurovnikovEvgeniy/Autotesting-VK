package Windows.TopToolbar;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import Utils.TopToolbar;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DiscussionWindow implements Window {
    private static final By DISCUSSIONS_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,discussions\")]");
    private static final By DISCUSSIONS_STATUS_OPEN
            = new By.ByXPath("//*[contains(@class, \"toolbar_nav_a toolbar_nav_a__discu toolbar_nav_a__discu__active\")]");
    private static final TopToolbar topToolbar = new TopToolbar();

    public DiscussionWindow() {
        topToolbar.open(DISCUSSIONS_BUTTON);
    }

    @Override
    @Step("Проверка того, что открытое окно соотвествует обсуждениям")
    public boolean check() {

        return $(DISCUSSIONS_STATUS_OPEN).shouldBe(Condition.visible).isDisplayed();
    }

    @Override
    @Step("Закрыть окно обсуждений")
    public void close() {
        topToolbar.close(DISCUSSIONS_BUTTON);
    }
}
