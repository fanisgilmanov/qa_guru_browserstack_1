package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidSearchTests extends TestBase {
    @Test
    @DisplayName("Поиск в Wikipedia по слову BrowserStack")
    void searchTestBrowserStack() {
        step("Поиск BrowserStack", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("BrowserStack");
        });
        step("Проверка найденного контента по BrowserStack", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));

        step("Удаление введеного текста в поле поиск", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/search_close_btn")).click());
    }



    @Test
    @DisplayName("Поиск в Wikipedia по слову TestExecute")
    void searchTestTestExecute() {
        step("Поиск TestExecute", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("TestExecute");
        });
        step("Проверка найденного контента по TestExecute", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
        step("Удаление введеного текста в поле поиск", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/search_close_btn")).click());
    }
}
