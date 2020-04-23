package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class SearchTest extends BaseTest {

    @Test
    void EnterTextTest() throws InterruptedException {
        driver.get("https://geekbrains.ru/career");
        //    Нажать на кнопку Поиск
//        driver.findElement(By.xpath("//*[@id=\"top-menu\"]/div/ul/li[2]/a")).click();
//        //    В поле Поиск ввести текст: java
//        driver.findElement(By.cssSelector("[class=\"search-panel__search-field\"]")).sendKeys("java");
        //    Проверить, что отобразились блоки:
        SearchClass searchClass = PageFactory.initElements(driver,SearchClass.class);
        searchClass.sendSearchString("java");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(d->searchClass.getProfessionsBlock().isDisplayed());
        wait.until(d->searchClass.getCoursesBlock().isDisplayed());
        wait.until(d->searchClass.getEventsBlock().isDisplayed());
        wait.until(d->searchClass.getPostsBlock().isDisplayed());
        wait.until(d->searchClass.getTopicsBlock().isDisplayed());
        wait.until(d->searchClass.getTestsBlock().isDisplayed());
        wait.until(d->searchClass.getProjectsAndCompaniesBlock().isDisplayed());

        Assertions.assertEquals("Профессии",
                searchClass.getProfessionsBlock().getText());
        Assertions.assertEquals("Курсы",
                searchClass.getCoursesBlock().getText());
        Assertions.assertEquals("Вебинары",
                searchClass.getEventsBlock().getText());
        Assertions.assertEquals("Блоги",
                searchClass.getPostsBlock().getText());
        Assertions.assertEquals("Форум",
                searchClass.getTopicsBlock().getText());
        Assertions.assertEquals("Тесты",
                searchClass.getTestsBlock().getText());
        Assertions.assertEquals("Проекты и компании",
                searchClass.getProjectsAndCompaniesBlock().getText());

        //        Профессий не менее чем 2
        //        Профессии
        assertThat(Integer.parseInt(searchClass.getProfessionsCount().getText()),
                greaterThanOrEqualTo(2));
        //        Курсы
        //        Курсов более 15
        assertThat(Integer.parseInt(searchClass.getCoursesCount().getText()),
                greaterThan(15));
        //        Вебинары
        //        Вебинаров больше чем 180, но меньше 300
        assertThat(Integer.parseInt(searchClass.getEventsCount().getText()),
                allOf(greaterThan(180),
                        lessThan(300)));
        //        Блоги
        //        Блогов более 300
        assertThat(Integer.parseInt(searchClass.getPostsCount().getText()),
                greaterThan(300));
        //        Форум
        //        Форумов не 350
        assertThat(Integer.parseInt(searchClass.getTopicsCount().getText()),
                not(equalTo(350)));
        //        Тесты
        //        Тестов не 0
        assertThat(Integer.parseInt(searchClass.getTestsCount().getText()),
                not(equalTo(0)));
        //        Проекты и компании
        //        В Проектах и компаниях отображается GeekBrains
        List<WebElement> elementList = driver.findElements(By.xpath("//div/div/section/div[2]/h3/a"));

        int ElementinList = -1;
        for(WebElement ListElement: elementList) {
            if (ElementinList == -1) ElementinList = ListElement.getText().indexOf("GeekBrains");
        }
        Assertions.assertTrue(ElementinList != -1);
    }
}
