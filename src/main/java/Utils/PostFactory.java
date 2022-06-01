package Utils;

import Pages.MainPage;
import Windows.TopToolbar.PostWindow;

public class PostFactory {
    public static PostWindow get(PostInterface page) {
        if (isMainPage(page)) {
            TopToolbar.goToMainPage();
        }
        return PostInterface.openPostWindow();
    }

    private static boolean isMainPage(PostInterface page) {
        return page.getClass() == MainPage.class;
    }

}
