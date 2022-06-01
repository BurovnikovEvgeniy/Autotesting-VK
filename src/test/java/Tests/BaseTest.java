package Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import TestBots.SetUser;
import TestBots.User;
import Utils.ScreenshotExtension;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(ScreenshotExtension.class)
public class BaseTest {

    public static final String url = "https://ok.ru/";
    protected static final User user = SetUser.EvgeniyBurovnikov;
    @BeforeAll
    static void cleanAllureResults() {
//        for (File myFile : Objects.requireNonNull(new File(String.valueOf(Paths.get("allure-results"))).listFiles()))
//            if (myFile.isFile()) {
//                myFile.delete();
//            }
    }

    @BeforeEach
    void init() {
        open(url);
    }
}
