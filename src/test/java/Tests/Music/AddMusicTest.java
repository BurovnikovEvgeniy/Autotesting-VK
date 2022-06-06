package Tests.Music;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;

import Pages.LoginPage;
import Pages.MainPage;
import Tests.BaseTest;
import Utils.Music;
import Windows.TopToolbar.MusicWindow;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AddMusicTest extends BaseTest {

    private static MusicWindow musicWindow;

    @BeforeEach
    public void beginAllTests() {
        MainPage mainPage = new LoginPage().doLogin(user);
        musicWindow = mainPage.openMusicWindow();
    }


    @ParameterizedTest
    @CsvSource({"Summertime Sadness, Lana Del Rey", "Dance Monkey, Tones And I"})
    @Tag("Music")
    @DisplayName("Тест возможности добавления новой музыки в коллекцию")
    @Description("Проверка возможности добавления новой музыки в плейлист user'а")
    @Severity(SeverityLevel.NORMAL)
    //@Disabled
    public void addOneMusicToUserMusicList(String title, String artist) {
        Music.MusicalComposition composition = new Music.MusicalComposition(title, artist);
        Assertions.assertTrue(musicWindow.check());
        musicWindow.addExistMusic(composition);
        Assertions.assertTrue(musicWindow.checkCertainMusicInUsersCollection(composition));
    }


    static class MusicArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(new Music.MusicalComposition("Gasoline", "Halsey"),
                            new Music.MusicalComposition("We Are The Champions (Live)", "Queen"))
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(MusicArgumentsProvider.class)
    @Tag("Music")
    @DisplayName("Тест изменения в плейлисте при добавлении новой музыки в коллекцию")
    @Description("Проверка изменения в плейлисте user'а при множественном добавлении музыки")
    @Severity(SeverityLevel.NORMAL)
    //@Disabled
    public void addSeveralSong(Music.MusicalComposition firstMusic,
                               Music.MusicalComposition secondMusic) {
        Assertions.assertTrue(musicWindow.check());
        int initialAmount = musicWindow.getCountUsersMusic();
        musicWindow.addExistMusic(firstMusic);
        int finalAmount = musicWindow.getCountUsersMusic();
        Assertions.assertEquals(1, finalAmount - initialAmount);
        musicWindow.addExistMusic(secondMusic);
        finalAmount = musicWindow.getCountUsersMusic();
        Assertions.assertEquals(2, finalAmount - initialAmount);
        Assertions.assertTrue(musicWindow.checkCertainMusicInUsersCollection(firstMusic));
        Assertions.assertTrue(musicWindow.checkCertainMusicInUsersCollection(firstMusic));
    }

    @AfterEach
    public void afterAllTests() {
        musicWindow
                .deleteAllUsersMusic()
                .close();
    }
}
