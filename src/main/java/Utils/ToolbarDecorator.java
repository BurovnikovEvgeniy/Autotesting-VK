package Utils;


import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ToolbarDecorator implements Toolbar {
    private final By toolbar;

    public ToolbarDecorator(By toolbarLocator) {
        toolbar = toolbarLocator;
    }

    @Override
    public void open(By openPathOnToolbar) {
        if (isVisibleToolbar()) {
            throw new RuntimeException("Illegal logic");
        }
        $(openPathOnToolbar).shouldBe(Condition.visible).click();
    }
    @Override
    public void close(By closePathOnToolbar) {
        if (isVisibleToolbar()) {
            throw new RuntimeException("Toolbar was not used. Not a single window is open");
        }
        $(closePathOnToolbar).click();
    }

    @Override
    public boolean isVisibleToolbar() {
        return !$(toolbar).shouldBe(Condition.visible).isDisplayed();
    }
}

