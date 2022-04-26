package Windows.TopToolbar;

import org.openqa.selenium.By;

import Utils.TopToolbar;

public class GuestsWindow implements Window {
    private static final By GUESTS_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,guests\")]");
    private static final TopToolbar topToolbar = new TopToolbar();

    public GuestsWindow() {
        topToolbar.open(GUESTS_BUTTON);
    }

    @Override
    public void close() {
        topToolbar.backToMainPage();
    }
}
