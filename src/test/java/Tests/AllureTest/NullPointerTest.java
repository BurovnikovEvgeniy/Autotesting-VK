package Tests.AllureTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import Tests.BaseTest;
import io.qameta.allure.Description;

public class NullPointerTest extends BaseTest {
    @Tag("NullPointer")
    @Test
    @DisplayName("Тест категории \"Нет данных\"")
    @Description("Должен попасть в категорию \"Нет данных\", выбрасывая NullPointerException")
    public void testCategoryNullPointer() {
        throw new NullPointerException();
    }
}

