package Utils;

import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;

import com.codeborne.selenide.Selenide;

import io.qameta.allure.Allure;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ScreenshotExtension implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        Allure.getLifecycle().addAttachment(
                "Screenshot",
                "image/png",
                "png",
                Selenide.screenshot(OutputType.BYTES)
        );
        getWebDriver().close();
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        getWebDriver().close();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        getWebDriver().close();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        getWebDriver().close();
    }
}
