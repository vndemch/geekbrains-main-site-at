package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class SearchTest extends BaseTest {

    @Test
    void EnterTextTest() {
        driver.get("https://geekbrains.ru/career");
        //    Нажать на кнопку Поиск
        WebElement SearchButton = driver.findElement(By.xpath("//*[@id=\"top-menu\"]/div/ul/li[2]/a"));
        SearchButton.click();
        //    В поле Поиск ввести текст: java
        WebElement inputSearch = driver.findElement(By.cssSelector("[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");
        //    Проверить, что отобразились блоки:
        //        Профессии
        WebElement ProfessionsBlock = driver.findElement(By.xpath("//div[@class='search-page-block'][1]/div[@class='stickyTitleWrap']/header/h2"));
        //        Курсы
        WebElement CoursesBlock = driver.findElement(By.xpath("//div[@class='search-page-block'][2]/div[@class='stickyTitleWrap']/header/h2"));
        //        Вебинары
        WebElement EventsBlock = driver.findElement(By.xpath("//div[@class='search-page-block'][3]/div[@class='stickyTitleWrap']/header/h2"));
        //        Блоги
        WebElement PostsBlock = driver.findElement(By.xpath("//div[@class='search-page-block'][4]/div[@class='stickyTitleWrap']/header/h2"));
        //        Форум
        WebElement TopicsBlock = driver.findElement(By.xpath("//div[@class='search-page-block'][5]/div[@class='stickyTitleWrap']/header/h2"));
        //        Тесты
        WebElement TestsBlock = driver.findElement(By.xpath("//div[@class='search-page-block'][6]/div[@class='stickyTitleWrap']/header/h2"));
        //        Проекты и компании
        WebElement ProjectsAndCompaniesBlock = driver.findElement(By.xpath("//div[@class='search-page-block'][7]/div[@class='stickyTitleWrap']/header/h2"));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(d->ProfessionsBlock.isDisplayed());
        wait.until(d->CoursesBlock.isDisplayed());
        wait.until(d->EventsBlock.isDisplayed());
        wait.until(d->PostsBlock.isDisplayed());
        wait.until(d->TopicsBlock.isDisplayed());
        wait.until(d->TestsBlock.isDisplayed());
        wait.until(d->ProjectsAndCompaniesBlock.isDisplayed());

        Assertions.assertEquals("Профессии",ProfessionsBlock.getText());
        Assertions.assertEquals("Курсы",CoursesBlock.getText());
        Assertions.assertEquals("Вебинары",EventsBlock.getText());
        Assertions.assertEquals("Блоги",PostsBlock.getText());
        Assertions.assertEquals("Форум",TopicsBlock.getText());
        Assertions.assertEquals("Тесты",TestsBlock.getText());
        Assertions.assertEquals("Проекты и компании",ProjectsAndCompaniesBlock.getText());

        //        Профессий не менее чем 2
        //        Профессии
        WebElement ProfessionsCount = driver.findElement(By.xpath("//*[@id=\"professions\"]/div[1]/header/ul/li/a/span"));
        assertThat(Integer.parseInt(ProfessionsCount.getText()), greaterThanOrEqualTo(2));
        //        Курсы
        //        Курсов более 15
        WebElement CoursesCount = driver.findElement(By.xpath("//header[@class='search-page-block__header']/ul/li/a[@data-tab='courses']/span"));
        assertThat(Integer.parseInt(CoursesCount.getText()), greaterThan(15));
        //        Вебинары
        //        Вебинаров больше чем 180, но меньше 300
        WebElement EventsCount = driver.findElement(By.xpath("//header[@class='search-page-block__header']/ul/li/a[@data-tab='webinars']/span"));
        assertThat(Integer.parseInt(EventsCount.getText()),
                allOf(greaterThan(180),
                        lessThan(300)));
        //        Блоги
        //        Блогов более 300
        WebElement PostsCount = driver.findElement(By.xpath("//header[@class='search-page-block__header']/ul/li/a[@data-tab='blogs']/span"));
        assertThat(Integer.parseInt(PostsCount.getText()), greaterThan(300));
        //        Форум
        //        Форумов не 350
        WebElement TopicsCount = driver.findElement(By.xpath("//header[@class='search-page-block__header']/ul/li/a[@data-tab='forums']/span"));
        assertThat(Integer.parseInt(TopicsCount.getText()), not(equalTo(350)));
        //        Тесты
        //        Тестов не 0
        WebElement TestsCount = driver.findElement(By.xpath("//header[@class='search-page-block__header']/ul/li/a[@data-tab='blogs']/span"));
        assertThat(Integer.parseInt(TestsCount.getText()), not(equalTo(0)));
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
