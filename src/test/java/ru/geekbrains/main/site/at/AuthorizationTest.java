package ru.geekbrains.main.site.at;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic(value = "Тест сайта Geekbrains")
@Feature(value = "Проверка с переходами по странице")
public class AuthorizationTest extends BaseTest{

    private String userlogin = "hao17583@bcaoo.com";
    private String userpwd = "hao17583";

    @Story(value = "Авторизация")
    @Step("Тестирование авторизации")
    @Description("Проверка входа с заданными параметрами")
    @Test
    @DisplayName("Проверка входа с заданными идентификационными данными")
    public void AuthorizTest(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
//        1. Перейти на страницу авторизация https://geekbrains.ru/login
        driver.get("https://geekbrains.ru/login");
//        2. Ввести логин : hao17583@bcaoo.com
//        3. Пароль: hao17583
        AuthorizationPage authorizationClass =
                PageFactory.initElements(driver, AuthorizationPage.class);
                authorizationClass.userLogin(userlogin,userpwd);
        //  5. Проверить, что отобразилась страница "Главная"
        authorizationClass.checkTitle("Главная");
//        6. Нажать в навигации "Курсы"
        driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/courses\"]"))
                .click();
//        7. Нажать в шапке сайта "Курсы"
        WebElement headerCoursesButton = driver.findElement(By.xpath("//*[@id=\"cour-link\"]"));
        wait.until(d->headerCoursesButton.isDisplayed());
        headerCoursesButton.click();

        authorizationClass.checkBoxesSwitch();
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
