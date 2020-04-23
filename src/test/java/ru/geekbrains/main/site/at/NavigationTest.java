package ru.geekbrains.main.site.at;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationTest extends BaseTest {

    @ParameterizedTest(name="{index}==>Тест навигации: {0}")
    @MethodSource("stringProvider")
    void testWithArgMethodSource(String str) {
        driver.get("https://geekbrains.ru/career");
        navigation.ButtonClick(str);

        assertEquals(str, navigation.getNavPageTitle().getText());
        HeaderCheck();
        FooterCheck();
    }

    static Stream<String> stringProvider() {
        return Stream.of("Вебинары", "Форум",  "Блог",  "Тесты", "Карьера","Курсы");
    }
}
