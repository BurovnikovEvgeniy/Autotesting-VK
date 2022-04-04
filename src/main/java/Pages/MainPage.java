package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    public static String USER_NAME = "//*[contains(@class, \"tico ellip\") and contains(text(), \"%s\")]";

    public boolean checkUsersPage(String firstAndLastName) {
        return $(By.xpath(String.format(USER_NAME, firstAndLastName))).isDisplayed();
    }
}
