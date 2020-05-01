package ru.geekbrains.main.site.at;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic(value = "Тест сайта Geekbrains")
@Feature(value = "Проверка с переходами по меню")
public class NavigationTest extends BaseTest {

    @Story(value = "Тестирование навигации")
    @ParameterizedTest(name="{index}==>Тест навигации: {0}")
    @MethodSource("stringProvider")
    void testWithArgMethodSource(String str) {
        driver.get("https://geekbrains.ru/career");
        page.getNavigation().ButtonClick(str);

        assertEquals(str, page.getNavPageTitle().getText());
        HeaderCheck();
        FooterCheck();
    }

    static Stream<String> stringProvider() {
        return Stream.of("Вебинары", "Форум",  "Блог",  "Тесты", "Карьера","Курсы");
    }
}
