package Utils;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Music {

    public static class MusicalComposition {
        private final String title;
        private final String artist;

        public MusicalComposition(String title, String artist) {
            this.title = title;
            this.artist = artist;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }
    }

    private final SelenideElement music;

    private static final By TITLE_MUSIC = new By.ByXPath(".//a[contains(@data-tsid,\"track_name\")]");
    private static final By ARTIST_MUSIC = new By.ByXPath(".//a[contains(@data-tsid,\"track_artist\")]");
    private static final By ADD_TRACK_BUTTON
            = new By.ByXPath(".//wm-track-add-button[contains(@data-l, \"t,add\")]");
    private static final By MESSAGE_SUCCESS_ADDITION
            = new By.ByXPath("//div[contains(@data-tsid, \"suggest_header\")]");
    private static final By REMOVE_TRACK_BUTTON
            = new By.ByXPath(".//wm-icon[contains(@data-tsid, \"remove_track\")]");


    public Music(SelenideElement music) {
        this.music = music;
    }

    public String getArtist() {
        return music.find(ARTIST_MUSIC).getText();
    }

    public String getTitle() {
        return music.find(TITLE_MUSIC).getText();
    }

    @Step("Добавление композиции в коллекцию пользователя")
    public void addToUsersCollection() {
        music
                .hover()
                .find(ADD_TRACK_BUTTON)
                .shouldBe(Condition.enabled)
                .shouldBe(Condition.visible)
                .click();
        $(MESSAGE_SUCCESS_ADDITION).shouldBe(Condition.visible);
    }

    @Step("Удаление композиции в коллекции пользователя")
    public void deleteFromUsersCollection() {
        music
                .hover()
                .find(REMOVE_TRACK_BUTTON)
                .shouldBe(Condition.visible)
                .click();
    }
}
