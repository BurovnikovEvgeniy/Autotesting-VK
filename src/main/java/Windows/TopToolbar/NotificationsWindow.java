package Windows.TopToolbar;

import org.openqa.selenium.By;

import Utils.TopToolbar;

public class NotificationsWindow implements Window {
    private static final By NOTIFICATIONS_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,notifications\")]");
    private static final TopToolbar topToolbar = new TopToolbar();

    public NotificationsWindow() {
        topToolbar.open(NOTIFICATIONS_BUTTON);
    }

    @Override
    public void close() {
        topToolbar.close(NOTIFICATIONS_BUTTON);
    }
}
