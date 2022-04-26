package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import Pages.LoginPage;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class Test {
    @BeforeEach
    void init() {
        open(LoginPage.url);
    }

    @AfterEach
    void close(){
        closeWindow();
    }
}
