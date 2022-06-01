package Tests.TopToolbar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Pages.LoginPage;
import Pages.MainPage;
import Tests.BaseTest;
import Windows.TopToolbar.Window;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TopToolbarTest extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    public void beginAllTests() {
        mainPage = new LoginPage().doLogin(user);
    }

    public void checkWindows(Window window) {
        Assertions.assertTrue(window.check());
        window.close();
        Assertions.assertTrue(mainPage.check());
    }

    @Test
    @DisplayName("Тест верхней главной панели")
    @Description(value = "Проверка работы верхней главной панели")
    @Severity(SeverityLevel.BLOCKER)
    //@Disabled
    public void toolbarWindowsTest(){
        Assertions.assertTrue(mainPage.check());
        checkWindows(mainPage.openMessageWindow());
        checkWindows(mainPage.openDiscussionWindow());
        checkWindows(mainPage.openMarksWindow());
        checkWindows(mainPage.openMusicWindow());
        checkWindows(mainPage.openNotificationsWindow());
    }
}
