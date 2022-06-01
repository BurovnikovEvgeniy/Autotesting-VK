package Pages;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;

public abstract class BasePage {
    public BasePage() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    public abstract boolean check();
}
