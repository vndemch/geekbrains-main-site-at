package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class NavigationTest extends BaseTest {

    void headerCheck() {
        WebElement header = driver.findElement(By.cssSelector("header[id=\"top-menu\"]"));
        Assertions.assertTrue(header.isDisplayed());
    }

    void footerCheck() {
        WebElement footer = driver.findElement(By.cssSelector("footer[class=\"site-footer\"]"));
        Assertions.assertTrue(footer.isDisplayed());
    }

    @ParameterizedTest(name="{index}==>Тест навигации: {1}")
    @MethodSource("stringAndStringProvider")
    void testWithTwoArgMethodTest(String str, String str2) {
//        System.out.println("Тест " + str2);
        driver.get("https://geekbrains.ru/career");
//        Вебинары
        WebElement EventsButton = driver.findElement(By.cssSelector(str));
        EventsButton.click();

        WebElement EventsPageTitle = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        assertEquals(str2, EventsPageTitle.getText());
        headerCheck();
        footerCheck();
    }

    static Stream<Arguments> stringAndStringProvider() {
        return Stream.of(
                arguments("[class*=\"main-page-hidden\"] [href=\"/events\"]", "Вебинары"),
                arguments("[class*=\"main-page-hidden\"] [href=\"/topics\"]", "Форум"),
                arguments("[class*=\"main-page-hidden\"] [href=\"/posts\"]", "Блог"),
                arguments("[class*=\"main-page-hidden\"] [href=\"/tests\"]", "Тесты"),
                arguments("[class*=\"main-page-hidden\"] [href=\"/career\"]", "Карьера"),
                arguments("[class*=\"main-page-hidden\"] [href=\"/courses\"]", "Курсы")
        );
    }
}
