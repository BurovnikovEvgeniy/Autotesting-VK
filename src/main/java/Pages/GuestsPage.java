package Pages;


import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class GuestsPage extends BasePage {

    private static final By GUESTS_PANEL = new By.ByXPath(".//*[contains(@id, \"listBlockPanelUserGuests\")]");

    @Override
    @Step("Проверка находимся ли мы на странице гостей")
    public boolean check() {
        return $(GUESTS_PANEL).shouldBe(Condition.visible).isDisplayed();
    }
}
