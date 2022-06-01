package Pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;

import Utils.MiniUserToolbar;
import Utils.PostInterface;
import Windows.TopToolbar.DiscussionWindow;
import Windows.TopToolbar.MarksWindow;
import Windows.TopToolbar.MessageWindow;
import Windows.TopToolbar.MusicWindow;
import Windows.TopToolbar.NotificationsWindow;
import Windows.TopToolbar.PostWindow;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage implements PostInterface {
    public static String USER_NAME = "//*[contains(@data-l, \"t,userPage\")]";
    public static String NEWS_TOOLBAR = "//*[contains(@class, \"filter filter__nowrap h-mod\")]";
    public static String USER_MAIN_MENU = "//*[contains(@class, \"nav-side __navigation __user-main\")]";

    public static final By POST_BUTTON = new By.ByXPath("//a[contains(@data-l, \"t,userStatuses\")]");

    @Step("Проверили, что вошли на страницу как {firstAndLastName}")
    public boolean isUsersPage(String firstAndLastName) {
        try {
            return $(By.xpath(USER_NAME)).shouldHave(text(firstAndLastName)).isDisplayed();
        } catch (ElementNotFound e) {
            return false;
        }
    }

    @Step("Корректный выход из аккауунта")
    public LoginPage logOut() {
        MiniUserToolbar miniUserToolbar = new MiniUserToolbar();
        miniUserToolbar.goOut();
        return new LoginPage();
    }

    @Override
    @Step("Проверка того, что мы находимся на главной странице OK.RU")
    public boolean check() {
        return $(By.xpath(NEWS_TOOLBAR)).shouldBe(Condition.visible).isDisplayed()
                && $(By.xpath(USER_MAIN_MENU)).shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Открытие страницы постов")
    public PostPage openPostPage() {
        $(POST_BUTTON)
                .shouldBe(Condition.visible)
                .click();
        return new PostPage();
    }

    @Step("Открытие окна музыки")
    public MusicWindow openMusicWindow() {
        return new MusicWindow();
    }

    @Step("Открытие окна обсуждений")
    public DiscussionWindow openDiscussionWindow() {
        return new DiscussionWindow();
    }

    @Step("Открытие окна оценок")
    public MarksWindow openMarksWindow() {
        return new MarksWindow();
    }

    @Step("Открытие окна сообщений")
    public MessageWindow openMessageWindow() {
        return new MessageWindow();
    }

    @Step("Открытие окна уведомлений")
    public NotificationsWindow openNotificationsWindow() {
        return new NotificationsWindow();
    }

    @Step("Открытие конструктора постов")
    public PostWindow openPostWindow() {
        return new PostWindow();
    }

}
