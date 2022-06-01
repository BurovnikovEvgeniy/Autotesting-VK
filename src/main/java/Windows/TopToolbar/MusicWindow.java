package Windows.TopToolbar;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import Utils.Music;
import Utils.TopToolbar;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MusicWindow implements Window {
    private static final By MUSIC_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,music\")]");
    private static final By SEARCH_MUSIC_FIELD
            = new By.ByXPath("//wm-search-form//*[contains(@data-tsid, \"inner_input\")]");
    private static final By LIST_SEARCH_MUSIC = new By.ByXPath("//wm-track[contains(@data-tsid, \"track\")]");
    private static final By USER_MUSIC_BUTTON = new By.ByXPath("//a[contains(@class, \"link __library\")]");
    private static final By ACTIVE_BUTTON_MUSIC
            = new By.ByXPath("//*[contains(@class, \"toolbar_nav_a toolbar_nav_a__audio h-mod toolbar_nav_a__audio__active\")]");
    private static final By SEARCH_MUSIC_BUTTON = new By.ByXPath("//wm-icon[contains(@data-tsid, \"submit_search_button\")]");
    private static final By COUNT_USER_MUSIC = new By.ByXPath("//wm-notification-counter[contains(@count, \"\")]");

    private static final TopToolbar topToolbar = new TopToolbar();

    public MusicWindow() {
        topToolbar.open(MUSIC_BUTTON);
    }

    @Step("Проверка того, что коллекция пользователя содержить заданную композицию")
    public boolean checkCertainMusicInUsersCollection(Music.MusicalComposition composition) {
        $(USER_MUSIC_BUTTON)
                .shouldBe(Condition.visible)
                .click();
        for (Music el : getUsersMusic()) {
            if (el.getTitle().contains(composition.getTitle()) && el.getArtist().contains(composition.getArtist())) {
                return true;
            }
        }
        return false;
    }

    @Step("Добавить существующую композицию в коллекцию пользователя")
    public MusicWindow addExistMusic(Music.MusicalComposition composition) {
        List<Music> music = searchMusic(composition);
        for (Music el : music) {
            if (el.getTitle().contains(composition.getTitle()) && el.getArtist().contains(composition.getArtist())) {
                el.addToUsersCollection();
                break;
            }
        }
        return this;
    }

    //@Attachment
    @Step("Удалить все композиции в коллекции пользователя")
    public MusicWindow deleteAllUsersMusic() {
        List<Music> usersMusic = getUsersMusic();
        for (Music music : usersMusic) {
            music.deleteFromUsersCollection();
        }
        return this;
    }

    @Step("Получить кол-во композиций в сборнике пользователя")
    public int getCountUsersMusic() {
        Selenide.refresh();
        if ($(COUNT_USER_MUSIC).exists())
            return Integer.parseInt($(COUNT_USER_MUSIC).getText());
        return 0;
    }

    @Override
    @Step("Проверка того, что открытое окно соотвествует окну музыки")
    public boolean check() {
        return $(ACTIVE_BUTTON_MUSIC).shouldBe(Condition.exist).isDisplayed();
    }

    @Override
    @Step("Закрыть окно музыки")
    public void close() {
        topToolbar.close(MUSIC_BUTTON);
    }

    private List<Music> getUsersMusic() {
        $(USER_MUSIC_BUTTON)
                .shouldBe(Condition.enabled)
                .shouldBe(Condition.visible)
                .click();
        ElementsCollection selenideElements = $$(LIST_SEARCH_MUSIC);
        selenideElements.get(0)
                .should(Condition.visible);
        List<Music> usersMusic = new ArrayList<>();
        for (SelenideElement el : selenideElements) {
            el.shouldBe(Condition.visible);
            usersMusic.add(new Music(el));
        }
        return usersMusic;
    }

    private List<Music> searchMusic(Music.MusicalComposition composition) {
        $(SEARCH_MUSIC_FIELD)
                .shouldBe(Condition.visible)
                .clear();
        $(SEARCH_MUSIC_FIELD)
                .setValue(composition.getTitle() + " " + composition.getArtist());
        $(SEARCH_MUSIC_BUTTON)
                .shouldBe(Condition.enabled)
                .shouldBe(Condition.visible)
                .click();
        ElementsCollection selenideElements = $$(LIST_SEARCH_MUSIC);
        selenideElements.get(0)
                .should(Condition.visible);
        List<Music> music = new ArrayList<>();
        for (SelenideElement el : selenideElements) {
            music.add(new Music(el));
        }
        return music;
    }
}
