package Tests.LogOut;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Pages.LoginPage;
import Pages.MainPage;
import TestBots.User;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LogOutTest extends BaseTest {
    @Test
    @DisplayName("Тест выхода из системы")
    @Description(value = "Проверка работы выхода из системы")
    @Severity(SeverityLevel.BLOCKER)
    //@Disabled
    public void logOut() {
        String password = null;
        try {
            password = Files.readString(Paths.get("src/main/resources/password"));
        } catch (IOException e) {
            e.printStackTrace();
            assert false;
        }
        LoginPage loginPage = new LoginPage();
        Assertions.assertTrue(loginPage.check());

        MainPage mainPage = loginPage.doLogin(new User("89111833275", password, ""));
        Assertions.assertTrue(mainPage.check());
        Assertions.assertTrue(mainPage.logOut().check());
    }

}
