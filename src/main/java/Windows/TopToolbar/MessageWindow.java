package Windows.TopToolbar;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import Utils.TopToolbar;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MessageWindow implements Window {

    private static final By MESSAGE_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,messages\")]");
    private static final By MESSAGE_STATUS_OPEN
            = new By.ByXPath("//*[contains(@class, \"toolbar_nav_a toolbar_nav_a__messa js-msg-tt h-mod toolbar_nav_a__messa__active\")]");
    private static final TopToolbar topToolbar = new TopToolbar();

    public MessageWindow() {
        topToolbar.open(MESSAGE_BUTTON);
    }

    @Override
    @Step("Проверка того, что открытое окно соотвествует окну сообщений")
    public boolean check() {
        return $(MESSAGE_STATUS_OPEN).shouldBe(Condition.visible).isDisplayed();
    }

    @Override
    @Step("Закрыть окно сообщений")
    public void close() {
        topToolbar.close(MESSAGE_BUTTON);
    }
}
