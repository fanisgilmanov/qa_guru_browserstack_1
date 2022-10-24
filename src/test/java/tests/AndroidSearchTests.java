package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AndroidSearchTests extends TestBase {
    @Test
    @Tag("android")
    @Feature("Мобильное приложение Wikipedia")
    @Story("Поиск в Wikipedia")
    @DisplayName("Проверка поля Search")
    void searchTestAppium() {
        back();
        step("Вводим значение в поле Search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Проверяем, что заданное значение найдено", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("android")
    @Feature("Мобильное приложение Wikipedia")
    @Story("Проверка вкладок на стартовой странице Wikipedia")
    @DisplayName("Проверка вкладки Search")
    void checkSearchTabTest() {
        back();
        step("Нажимаем на вкладку Search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_search")).click();
        });
        step("Проверяем, что открылась нужная страница", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/history_title")).shouldHave(Condition.text("History"));
        });
    }

    @Test
    @Tag("android")
    @Feature("Мобильное приложение Wikipedia")
    @Story("Проверка вкладок на стартовой странице Wikipedia")
    @DisplayName("Проверка вкладки Saved")
    void checkSavedTabTest() {
        back();
        step("Нажимаем на вкладку Saved", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_reading_lists")).click();
        });
        step("Проверяем, что открылась нужная страница", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/positiveButton")).shouldHave(Condition.text("LOG IN / JOIN WIKIPEDIA"));
        });
    }
}
