package Windows.TopToolbar;

import org.openqa.selenium.By;

import Utils.TopToolbar;

public class MarksWindow implements Window{
    private static final By MARKS_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,marks\")]");
    private static final TopToolbar topToolbar = new TopToolbar();

    public MarksWindow() {
        topToolbar.open(MARKS_BUTTON);
    }

    @Override
    public void close() {
        topToolbar.close(MARKS_BUTTON);
    }
}
