package Pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import TestBots.User;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private static final By EMAIL_FIELD = new By.ByXPath("//*[contains(@id, \"field_email\")]");
    private static final By PASSWORD_FIELD = new By.ById("field_password");
    private static final By LOG_IN_BUTTON
            = new By.ByXPath("//*[contains(@class, \"login-form-actions\")]/*[contains(@class, \"button-pro\")]");
    private static final By LOGIN_OR_PASSWORD_ERROR = new By.ByXPath("//*[contains(@class, \"input-e login_error\")]");

    public LoginPage() {
    }

    @Step("Логинимся в свой аккаунт")
    public MainPage doLogin(User user) {
        $(EMAIL_FIELD)
                .shouldBe(Condition.visible)
                .clear();
        $(EMAIL_FIELD).sendKeys(user.getLogin());
        $(PASSWORD_FIELD)
                .shouldBe(Condition.visible)
                .clear();
        $(PASSWORD_FIELD).sendKeys(user.getPassword());
        $(LOG_IN_BUTTON).shouldBe(Condition.visible).click();
        return new MainPage();
    }

    @Step("Проверяем, что находимся на странице регитстрации")
    public boolean check() {
        return $(EMAIL_FIELD).shouldBe(Condition.visible).isDisplayed()
                && $(PASSWORD_FIELD).shouldBe(Condition.visible).isDisplayed()
                && $(LOG_IN_BUTTON).shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Проверяем, есть ли ошибка при неверном входе")
    public boolean isHaveErrorWithLoginOrPassword() {
        return check() && $(LOGIN_OR_PASSWORD_ERROR).shouldBe(Condition.visible).isDisplayed();
    }

}
