package Pages;

import org.openqa.selenium.By;

import TestBots.User;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    public LoginPage() {}

    private static final By EMAIL_FIELD = new By.ById("field_email");
    private static final By PASSWORD_FIELD = new By.ById("field_password");
    private static final By LOG_IN_BUTTON
            = new By.ByXPath("//*[contains(@class, \"login-form-actions\")]/*[contains(@class, \"button-pro\")]");
    private static final By LOGIN_OR_PASSWORD_ERROR = new By.ByXPath("//*[contains(@class, \"input-e login_error\")]");

    public static final String url = "https://ok.ru/";

    public MainPage doLogin(User user) {
        $(EMAIL_FIELD).sendKeys(user.getLogin());
        $(PASSWORD_FIELD).sendKeys(user.getPassword());
        $(LOG_IN_BUTTON).click();
        if ($(LOGIN_OR_PASSWORD_ERROR).isDisplayed()) {
            throw new IllegalArgumentException("Invalid login or password values");
        }
        return new MainPage();
    }
    public MainPage doLogin(String login, String password) {
        User user = new User
                .UserBuilder()
                .addLogin(login)
                .addPassword(password)
                .build();
        return doLogin(user);
    }
}
