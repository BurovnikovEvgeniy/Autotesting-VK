package Locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By EMAIL_FIELD = By.id("field_email");
    public static final By PASSWORD_FIELD = By.id("field_password");
    public static final By LOG_IN_BUTTON
            = By.xpath("//*[contains(@class, \"login-form-actions\")]/*[contains(@class, \"button-pro\")]");
    public static final By LOGIN_OR_PASSWORD_ERROR = By.className("input-e login_error");
}
