package Tests;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import Pages.LoginPage;
import TestBots.User;

public class MainPageTest extends Tests.Test {
    @Test
    public void logOut() {
        String password = null;
        try {
            password = Files.readString(Paths.get("src/main/resources/password"));
        } catch (IOException e) {
            e.printStackTrace();
            assert false;
        }
        assert new LoginPage()
                .doLogin("89111833275", password)
                .logOut()
                .isLoginPage();
    }

}
