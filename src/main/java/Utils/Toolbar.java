package Utils;

import org.openqa.selenium.By;

public interface Toolbar {
    public void open(By path);

    public void close(By path);

    public boolean isVisibleToolbar();
}
