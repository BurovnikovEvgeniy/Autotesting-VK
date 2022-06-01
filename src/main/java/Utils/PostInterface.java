package Utils;

import Windows.TopToolbar.PostWindow;

public interface PostInterface {
    static PostWindow openPostWindow() {
        return new PostWindow();
    }
}
