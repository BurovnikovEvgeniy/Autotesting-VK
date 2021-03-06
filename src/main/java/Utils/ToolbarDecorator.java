package Utils;

import org.openqa.selenium.By;

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
        $(openPathOnToolbar).click();
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
        return !$(toolbar).isDisplayed();
    }
}

