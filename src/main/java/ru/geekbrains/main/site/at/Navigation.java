package ru.geekbrains.main.site.at;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigation {
    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/events\"]")
    private WebElement eventsButton;
    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/topics\"]")
    private WebElement topicsButton;
    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/posts\"]")
    private WebElement postsButton;
    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/tests\"]")
    private WebElement testsButton;
    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/career\"]")
    private WebElement careerButton;
    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/courses\"]")
    private WebElement coursesButton;
    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement navPageTitle;

    public WebElement getNavPageTitle() {
        return navPageTitle;
    }

    public void eventsButtonClick() {
        eventsButton.click();
    }

    public void topicsButtonClick() {
        topicsButton.click();
    }

    public void postsButtonClick() {
        postsButton.click();
    }

    public void testsButtonClick() {
        testsButton.click();
    }

    public void careerButtonClick() {
        careerButton.click();
    }

    public void coursesButtonClick() {
        coursesButton.click();
    }

    public void ButtonClick(String nameButton) {
        switch (nameButton) {
            case "Вебинары": {
                eventsButtonClick();
                break;
            }
            case "Форум": {
                topicsButtonClick();
                break;
            }

            case "Блог": {
                postsButtonClick();
                break;
            }

            case "Тесты": {
                testsButtonClick();
                break;
            }

            case "Карьера": {
                careerButtonClick();
                break;
            }

            case "Курсы": {
                coursesButtonClick();
                break;
            }
            default: throw new NotFoundException("Кнопка с именем: '" + nameButton + "' не найдена");
        }
    }
}
