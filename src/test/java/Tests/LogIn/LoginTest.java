package Tests.LogIn;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Pages.LoginPage;
import Pages.MainPage;
import TestBots.SetUser;
import TestBots.User;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginTest extends BaseTest {

    @Test
    @Description(value = "Проверка входа в систему с верными пользовательскими данными")
    @DisplayName("Тест входа в систему с верными данными")
    @Severity(SeverityLevel.BLOCKER)
    //@Disabled
    public void loginWithRightDataTest() {
        User user = SetUser.EvgeniyBurovnikov;
        LoginPage loginPage = new LoginPage();
        Assertions.assertTrue(loginPage.check());
        MainPage mainPage = loginPage.doLogin(user);
        Assertions.assertTrue(mainPage.isUsersPage(user.getFirstAndLastName()));
    }

    @Test
    @DisplayName("Тест входа в систему с неверными данными")
    @Description(value = "Проверка входа в систему с неверными пользовательскими данными")
    @Severity(SeverityLevel.BLOCKER)
    //@Disabled
    public void loginWithIncorrectDataTest() {
        User user = new User.UserBuilder()
                .addLogin("***")
                .addPassword("***")
                .build();
        LoginPage loginPage = new LoginPage();
        Assertions.assertTrue(loginPage.check());
        loginPage.doLogin(user);
        Assertions.assertTrue(loginPage.isHaveErrorWithLoginOrPassword());
        Assertions.assertTrue(loginPage.check());
    }
}

