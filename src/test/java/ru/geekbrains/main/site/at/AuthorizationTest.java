package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class AuthorizationTest extends BaseTest{

    @Test
    public void AuthorizTest(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
//        1. Перейти на страницу авторизация https://geekbrains.ru/login
        driver.get("https://geekbrains.ru/login");
//        2. Ввести логин : hao17583@bcaoo.com
//        3. Пароль: hao17583
        driver.findElement(By.xpath("//*[@id=\"user_email\"]"))
                .sendKeys("hao17583@bcaoo.com");
        driver.findElement(By.xpath("//*[@id=\"user_password\"]"))
                .sendKeys("hao17583");
//        4. Нажать кнопку войти
        driver.findElement(By.xpath("//*[@data-testid=\"login-submit\"]")).click();
//        5. Проверить что отобразилась страница "Главная"
        WebElement pageTitle = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        //assertThat("Главная",equalToIgnoringWhiteSpace(pageTitle.getText()));
        assertEquals("Главная", pageTitle.getText());
//        6. Нажать в навигации "Курсы"
        driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/courses\"]"))
                .click();
//        7. Нажать в шапке сайта "Курсы"
        WebElement headerCoursesButton = driver.findElement(By.xpath("//*[@id=\"cour-link\"]"));
        wait.until(d->headerCoursesButton.isDisplayed());
        headerCoursesButton.click();

//        8. Выбрать в фильтрах чекбокс "Бесплатные"
        driver.findElement(By.xpath("//*[@id=\"filter-0\"]"))
                .click();
//        9. Выбрать в фильтрах чекбокс "Тестирование"
        driver.findElement(By.xpath("//*[@id=\"filter-9\"]"))
                .click();
//        10. Проверить что в выборке отображается курсы "Тестирование ПО. Уровень 1"
//        11. Проверить что в выборке отображается курсы "Тестирование ПО. Уровень 2"
        List<WebElement> coursesList = driver.findElements(
                By.xpath("//*/span[@class=\"gb-course-card__title-text\"]"));
        int testCount = 0;
        for (WebElement testCourse: coursesList){
//            System.out.println("|"+testCourse.getText()+"|");
            if ((testCourse.getText().indexOf("Тестирование ПО. Уровень 1") > -1)||
                    (testCourse.getText().indexOf("Тестирование ПО. Уровень 2") > -1)) testCount++;
        }
            assertThat(testCount,equalTo(2));
    }
}
