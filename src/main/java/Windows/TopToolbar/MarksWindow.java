package Windows.TopToolbar;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import Utils.TopToolbar;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MarksWindow implements Window{
    private static final By MARKS_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,marks\")]");
    private static final By MARKS_STATUS_OPEN
            = new By.ByXPath("//*[contains(@class, \"h-mod toolbar_nav_a toolbar_nav_a__feedback toolbar_nav_a__feedback__active\")]");
    private static final TopToolbar topToolbar = new TopToolbar();


    public MarksWindow() {
        topToolbar.open(MARKS_BUTTON);
    }

    @Override
    @Step("Проверка того, что открытое окно соотвествует оценкам")
    public boolean check() {
        return $(MARKS_STATUS_OPEN).shouldBe(Condition.visible).isDisplayed();
    }

    @Override
    @Step("Закрыть окно оценок")
    public void close() {
        topToolbar.close(MARKS_BUTTON);
    }
}
