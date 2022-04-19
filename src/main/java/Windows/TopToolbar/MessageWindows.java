package Windows.TopToolbar;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MessageWindows {

    private static final By FIELD_MESSAGE = new By.ByXPath(".//*[contains(@name ,\"input\")]");

    public void sendMessage(By recipient, String text) {
        $(recipient).click();
        $(FIELD_MESSAGE).shouldHave(text("Напишите сообщение.."));
        $(FIELD_MESSAGE).setValue(text);
    }
}
