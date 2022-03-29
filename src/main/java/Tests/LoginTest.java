package Tests;

import org.junit.Test;
import org.openqa.selenium.By;

import Locators.MainPageLocators;
import Pages.LoginPage;
import Pages.MainPage;
import TestBots.User;

import static com.codeborne.selenide.Selenide.$;

public class LoginTest {
    @Test
    public void testLogin() {
        User user = new User("89111833275", "195106039*", "Егений Буровников");
        LoginPage loginPage = new LoginPage();
        try {
            MainPage mainPage = loginPage.login(user);
            if ($(By.xpath(String.format(MainPageLocators.USER_NAME, user.getFirstAndLastName()))).isDisplayed()) {
                throw new IllegalArgumentException("Bot errors");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
