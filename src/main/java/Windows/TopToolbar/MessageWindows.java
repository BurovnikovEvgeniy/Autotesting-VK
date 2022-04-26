package Windows.TopToolbar;

import org.openqa.selenium.By;

import Utils.TopToolbar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MessageWindows implements Window {

    private static final By MESSAGE_BUTTON = new By.ByXPath(".//*[contains(@data-l, \"t,messages\")]");
    private static final By FIELD_MESSAGE = new By.ByXPath(".//*[contains(@name ,\"input\")]");
    private static final TopToolbar topToolbar = new TopToolbar();

    public MessageWindows() {
        topToolbar.open(MESSAGE_BUTTON);
    }

    public void sendMessage(By recipient, String text) {
        $(recipient).click();
        $(FIELD_MESSAGE).shouldHave(text("Напишите сообщение.."));
        $(FIELD_MESSAGE).setValue(text);
    }

    @Override
    public void close() {
        topToolbar.close(MESSAGE_BUTTON);
    }
}
