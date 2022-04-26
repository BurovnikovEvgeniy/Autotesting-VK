package Utils;

import org.openqa.selenium.By;

import Pages.MainPage;

import static com.codeborne.selenide.Selenide.$;

public class TopToolbar extends ToolbarDecorator {

    private static final By TOP_TOOLBAR = new By.ByXPath(".//*[contains(@data-l, \"t,navigationToolbar\")]");
    private static final By POINT_TO_MAIN_PAGE = new By.ByXPath(".//*[contains(@id, \"topPanelLeftCorner\")]");


    public TopToolbar() {
        super(TOP_TOOLBAR);
    }

    public MainPage backToMainPage() {
        $(POINT_TO_MAIN_PAGE).click();
        return new MainPage();
    }
}
