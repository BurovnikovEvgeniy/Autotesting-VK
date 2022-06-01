package Tests.Music;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.PostPage;
import Tests.BaseTest;
import Utils.Music;
import Utils.PostFactory;
import Utils.RandomValueGenerator;
import Utils.TopToolbar;
import Windows.TopToolbar.PostWindow;
import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AddPostTest extends BaseTest {
    private MainPage mainPage;
    private RandomValueGenerator<String> messages;
    private RandomValueGenerator<Music.MusicalComposition> compositions;
    @BeforeEach
    public void beginAllTests() {
        mainPage = new LoginPage().doLogin(user);
        messages = new RandomValueGenerator<>(new ArrayList<>(Arrays.asList("Hello","It's impossible","Very cool")));
        compositions = new RandomValueGenerator<>(new ArrayList<>(Arrays.asList(
                new Music.MusicalComposition("Summertime Sadness", "Lana Del Rey"),
                new Music.MusicalComposition("Пчеловод", "RASA"),
                new Music.MusicalComposition("I Want To Break Free", "Queen")
        )));
    }

    @Test
    @Tag("Posts")
    @DisplayName("Тест создания поста")
    @Description("Создается пост, добавляет туда текст, затем проверяет, что новый пост был создан")
    @Severity(SeverityLevel.MINOR)
    public void addPostConstructorTest() {
        Assertions.assertTrue(TopToolbar.goToMainPage().check());
        PostWindow post = PostFactory.get(mainPage);
        Assertions.assertTrue(post.check());
        post
                .deleteDraft().
                addText(messages.generate());
        Assertions.assertTrue(post.checkTextPost(messages.get()));
        post.create();

        PostPage postPage = mainPage.openPostPage();
        Assertions.assertTrue(postPage.check());
        Assertions.assertTrue(postPage.isPostsExist());
    }

    @Test
    @Flaky
    @Tag("Posts")
    @DisplayName("Тест создания поста с музыкой и текстом")
    @Description("Создается пост, добавляет туда музыку и текст, затем проверяет, что новый пост был создан")
    @Severity(SeverityLevel.MINOR)
    public void abilityAttachMusicToPost() {
        PostPage postPage = mainPage.openPostPage();
        Assertions.assertTrue(postPage.check());
        PostWindow post = PostFactory.get(postPage);
        Assertions.assertTrue(post.check());
        post
                .deleteDraft()
                .addMusic(compositions.generate())
                .addText(messages.generate());
        Assertions.assertTrue(post.checkTracksExistInPost());
        Assertions.assertTrue(post.checkTextPost(messages.get()));
        post.create();
        Assertions.assertTrue(postPage.check());
        Assertions.assertTrue(postPage.isPostsExist());
    }



    @AfterEach
    public void afterAllTests() {
        TopToolbar.goToMainPage()
                .openPostPage()
                .deleteAllPost();
    }
}
