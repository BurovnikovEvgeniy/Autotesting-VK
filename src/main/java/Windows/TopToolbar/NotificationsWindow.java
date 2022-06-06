package Windows.TopToolbar;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import Utils.TopToolbar;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class NotificationsWindow implements Window {
    private static final By NOTIFICATIONS_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,notifications\")]");
    private static final TopToolbar topToolbar = new TopToolbar();
    private static final By NOTIF_OPEN_STATUS
            = new By.ByXPath("//*[contains(@class, \"toolbar_nav_a toolbar_nav_a__notif toolbar_nav_a__notif__active\")]");

    public NotificationsWindow() {
        topToolbar.open(NOTIFICATIONS_BUTTON);
    }

    @Override
    @Step("Проверка того, что открыто окно уведомлений")
    public boolean check() {
        return $(NOTIF_OPEN_STATUS).shouldBe(Condition.visible).isDisplayed();
    }

    @Override
    @Step("Закрыть окно уведомлений")
    public void close() {
        topToolbar.close(NOTIFICATIONS_BUTTON);
    }
}
