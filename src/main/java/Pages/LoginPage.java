package Pages;

import java.util.NoSuchElementException;

import Locators.LoginPageLocators;
import TestBots.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    public static final String url = "https://ok.ru/";

    public LoginPage() {
        open(url);
    }

    public MainPage login(User user) {
        $(LoginPageLocators.EMAIL_FIELD).sendKeys(user.getLogin());
        $(LoginPageLocators.PASSWORD_FIELD).sendKeys(user.getPassword());
        $(LoginPageLocators.LOG_IN_BUTTON).click();
        if ($(LoginPageLocators.LOGIN_OR_PASSWORD_ERROR).isDisplayed()) {
            throw new IllegalArgumentException("Invalid login or password values");
        }
        return new MainPage();
    }
}
