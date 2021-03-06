package Utils;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MiniUserToolbar extends ToolbarDecorator {
    private static final By MINI_USER_TOOLBAR = new By.ByXPath("//*[contains(@class, \"ucard-mini toolbar_ucard js-toolbar-menu\")]");
    private static final By GO_OUT_PLACE = new By.ByXPath("//*[contains(@class, \"toolbar_accounts-user-info\")]");
    private static final By GO_OUT_BOTTOM = new By.ByXPath(".//*[contains(@data-l, \"t,logout\")]");
    private static final By GO_OUT_CONFIRM = new By.ByXPath(".//*[contains(@class, \"button-pro form-actions_yes\") and contains(@value, \"Выйти\")]");


    public MiniUserToolbar() {
        super(MINI_USER_TOOLBAR);
        this.open(MINI_USER_TOOLBAR);
    }

    public void close() {
        super.close(MINI_USER_TOOLBAR);
    }
    public void goOut() {
     $(GO_OUT_PLACE).find(GO_OUT_BOTTOM).click();
     $(GO_OUT_CONFIRM).click();
    }
}
