package Pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.ex.ElementNotFound;

import Utils.MiniUserToolbar;
import Utils.TopToolbar;
import Windows.TopToolbar.MessageWindows;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    public static String USER_NAME = "//*[contains(@data-l, \"t,userPage\")]";


    public boolean isUsersPage(String firstAndLastName) {
        try {
            return $(By.xpath(USER_NAME)).shouldHave(text(firstAndLastName)).isDisplayed();
        } catch (ElementNotFound e) {
            return false;
        }
    }

    public LoginPage logOut() {
        MiniUserToolbar miniUserToolbar = new MiniUserToolbar();
        miniUserToolbar.goOut();
        return new LoginPage();
    }
}
