package Pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import Utils.PostInterface;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PostPage extends BasePage implements PostInterface {

    private static final By ACTIVE_BUTTON_POST
            = new By.ByXPath("//a[contains(@class, \"mctc_navMenuSec  mctc_navMenuActiveSec\")]");
    private static final By USER_POST_LIST
            = new By.ByXPath("//*[contains(@tsid, \"userStatusShares\")]");
    private static final By POINT_TO_DELETE_BUTTON
            = new By.ByXPath(".//span[contains(@class, \"new_topic_icodown\")]");
    private static final By DELETE_POST_BUTTON
            = new By.ByXPath(".//div[@id=\"hook_Block_ShortcutMenu\"]//a[contains(@hrefattrs,\"StatusLayer_deleteButton\")]");
    private static final By SUCCESS_DELETE_POST
            = new By.ByXPath("//div[contains(@class, \"feed __deleted\")]");
    @Override
    public boolean check() {
        return $(ACTIVE_BUTTON_POST).shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Удаление всех постов пользователя")
    public PostPage deleteAllPost() {
        ElementsCollection listPosts = $$(USER_POST_LIST);
        if (listPosts.isEmpty()){
            return this;
        }
        listPosts.get(0).shouldBe(Condition.visible);
        for (SelenideElement el: listPosts) {
            $(POINT_TO_DELETE_BUTTON)
                    .shouldBe(Condition.visible)
                    .hover();
            $(DELETE_POST_BUTTON)
                    .shouldBe(Condition.enabled)
                    .shouldBe(Condition.visible)
                    .click();
            $(SUCCESS_DELETE_POST).shouldBe(Condition.visible);
            Selenide.refresh();
        }
        return new PostPage();
    }

    @Step("Перезагрузка страницы")
    public PostPage reload(){
        Selenide.refresh();
        return new PostPage();
    }

    @Step("Проверка того, что пользователь имеет посты")
    public boolean isPostsExist() {
        return $$(USER_POST_LIST).size() != 0;
    }
}
