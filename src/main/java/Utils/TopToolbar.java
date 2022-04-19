package Utils;

import org.openqa.selenium.By;

import Windows.TopToolbar.DiscussionWindow;
import Windows.TopToolbar.GuestsWindow;
import Windows.TopToolbar.MarksWindow;
import Windows.TopToolbar.MessageWindows;
import Windows.TopToolbar.MusicWondow;
import Windows.TopToolbar.NotificationsWindow;

public class TopToolbar extends TopToolbarDecorator {
    private static final By MESSAGE_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,messages\")]");
    private static final By DISCUSSIONS_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,discussions\")]");
    private static final By NOTIFICATIONS_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,notifications\")]");
    private static final By GUESTS_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,guests\")]");
    private static final By MARKS_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,marks\")]");
    private static final By MUSIC_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,music\")]");

    public static MessageWindows openMessageWindow() {
        open(MESSAGE_BUTTON);
        return new MessageWindows();
    }

    public static DiscussionWindow openDiscussionWindow() {
        open(DISCUSSIONS_BUTTON);
        return new DiscussionWindow();
    }

    public static NotificationsWindow openNotificationsWindow() {
        open(NOTIFICATIONS_BUTTON);
        return new NotificationsWindow();
    }

    public static GuestsWindow openGuestsWindow() {
         open(GUESTS_BUTTON);
         return new GuestsWindow();
    }

    public static MarksWindow openMarksWindow() {
        open(MARKS_BUTTON);
        return new MarksWindow();
    }

    public static MusicWondow openMusicWindow() {
        open(MUSIC_BUTTON);
        return new MusicWondow();
    }
}
