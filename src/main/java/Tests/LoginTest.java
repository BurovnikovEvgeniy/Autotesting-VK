package Tests;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import Pages.LoginPage;
import Pages.MainPage;
import TestBots.User;

public class LoginTest extends Tests.Test {

    @Test
    public void loginWithRightDataTest() {
        String password = null;
        try {
            password = Files.readString(Paths.get("src/main/resources/password"));
        } catch (IOException e) {
            e.printStackTrace();
            assert false;
        }
        User user = new User("89111833275", password, "Евгений Буровников");
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.doLogin(user);
        assert mainPage.isUsersPage(user.getFirstAndLastName());
    }

    @Test
    public void loginWithIncorrectDataTest() {
        String login = "***";
        String password = "***";
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin(login, password);
        assert loginPage.isHaveErrorWithLoginOrPassword();
    }
}

