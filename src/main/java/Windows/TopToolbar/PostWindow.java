package Windows.TopToolbar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import Utils.Music;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PostWindow implements Window {
    private static final By FIELD_POST = new By.ByXPath("//*[contains(@class, \"pf-head_cnt\")]");
    private static final By POST_AREA = new By.ByXPath("//div[contains(@class, \"posting_itx emoji-tx\")]");
    private static final By ATTACH_MUSIC_BUTTON = new By.ByXPath("//div[contains(@class, \"posting_ac_i  js-music-btn h-mod\")]");
    private static final By FIELD_SEARCH_MUSIC = new By.ByXPath("//*[contains(@data-id, \"searchInput\")]");
    private static final By POSTING_LIST_TRACK = new By.ByXPath("//*[contains(@data-json, \"trackId\")]");
    private static final By ADD_MUSIC_BUTTON = new By.ByXPath("//a[contains(@class, \"button-pro form-actions_yes\")]");
    private static final By SHARE_YOUR_POST = new By.ByXPath("//*[contains(@class, \"posting_submit button-pro\")]");
    private static final By DELETE_DRAFT_BUTTON = new By.ByXPath("//*[contains(@data-action, \"clearDraft\")]");
    private static final By TRACK_FIELD_CHECK = new By.ByXPath("//*[contains(@class, \"posting-tracks\")]");


    public PostWindow() {
        $(FIELD_POST)
                .shouldBe(Condition.enabled)
                .shouldBe(Condition.visible)
                .click();
    }

    @Step("Добавить сообщение в пост")
    public PostWindow addText(String text) {
        $(POST_AREA)
                .shouldBe(Condition.visible)
                .setValue(text);
        return this;
    }

    @Step("Добавить музыкальную композицию в пост")
    public PostWindow addMusic(Music.MusicalComposition composition) {
        $(ATTACH_MUSIC_BUTTON)
                .shouldBe(Condition.enabled)
                .shouldBe(Condition.visible)
                .click();
        $(FIELD_SEARCH_MUSIC)
                .shouldBe(Condition.visible)
                .setValue(composition.getTitle() + " " + composition.getArtist())
                .sendKeys(Keys.ENTER);
        ElementsCollection listTracks = $$(POSTING_LIST_TRACK);
        listTracks.get(0).shouldBe(Condition.visible);
        for (SelenideElement selenideElement : listTracks) {
            if (selenideElement.getText().contains(composition.getTitle())
                    && selenideElement.getText().contains(composition.getArtist())) {
                selenideElement
                        .shouldBe(Condition.enabled)
                        .shouldBe(Condition.visible)
                        .click();
                $(ADD_MUSIC_BUTTON)
                        .shouldBe(Condition.enabled)
                        .shouldBe(Condition.visible)
                        .click();
                break;
            }
        }
        return this;
    }

    @Step("Удалить созданный ранее шаблон поста")
    public PostWindow deleteDraft() {
        if ($(DELETE_DRAFT_BUTTON).exists()) {
            $(DELETE_DRAFT_BUTTON)
                    .shouldBe(Condition.enabled)
                    .shouldBe(Condition.visible)
                    .click();
        }
        return this;
    }

    @Step("Создать пост")
    public void create() {
        $(SHARE_YOUR_POST)
                .shouldBe(Condition.enabled)
                .shouldBe(Condition.visible)
                .click();
    }

    @Override
    @Step("Проверка того, что окно создания поста открыто")
    public boolean check() {
        return $(POST_AREA)
                .shouldBe(Condition.visible)
                .isDisplayed();
    }

    @Override
    @Step("Закрыть окно создания поста")
    public void close() {
        $(POST_AREA)
                .shouldBe(Condition.visible)
                .sendKeys(Keys.ESCAPE);
    }


    @Step("Проверка того, что пост содержит музыку в шаблоне")
    public boolean checkTracksExistInPost() {
        return $(TRACK_FIELD_CHECK).exists();
    }

    @Step("Проверка того, что созданный пост содержит заданный текст")
    public boolean checkTextPost(String expectedText) {
        return expectedText.equals($(POST_AREA).shouldBe(Condition.visible).getText());
    }
}
