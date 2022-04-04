package Tests;

import org.junit.Test;

import Pages.LoginPage;
import Pages.MainPage;
import TestBots.User;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    @Test
    public void testLogin() {
        open(LoginPage.url);
        User user = new User("89111833275", "***", "Егений Буровников");
        LoginPage loginPage = new LoginPage();
        try {
            MainPage mainPage = loginPage.login(user);
            if (mainPage.checkUsersPage(user.getFirstAndLastName())) {
                throw new IllegalArgumentException("Bot errors");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
