package Windows.TopToolbar;

import org.openqa.selenium.By;

import Utils.TopToolbar;

public class DiscussionWindow implements Window {
    private static final By DISCUSSIONS_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,discussions\")]");
    private static final TopToolbar topToolbar = new TopToolbar();

    DiscussionWindow() {
        topToolbar.open(DISCUSSIONS_BUTTON);
    }

    @Override
    public void close() {
        topToolbar.close(DISCUSSIONS_BUTTON);
    }
}
