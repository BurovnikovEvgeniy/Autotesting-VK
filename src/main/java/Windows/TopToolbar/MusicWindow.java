package Windows.TopToolbar;

import org.openqa.selenium.By;

import Utils.TopToolbar;

public class MusicWindow implements Window {
    private static final By MUSIC_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,music\")]");
    private static final TopToolbar topToolbar = new TopToolbar();

    public MusicWindow() {
        topToolbar.open(MUSIC_BUTTON);
    }

    @Override
    public void close() {
        topToolbar.close(MUSIC_BUTTON);
    }
}
