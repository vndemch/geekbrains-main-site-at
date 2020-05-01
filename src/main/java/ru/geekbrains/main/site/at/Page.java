package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Page {

    private Navigation navigation;

    public Page(WebDriver driver) {
        this.navigation = PageFactory.initElements(driver,Navigation.class);
    }
    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement navPageTitle;

    public WebElement getNavPageTitle() {
        return navPageTitle;
    }

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement pagePopUpClose;

    public Page PopUpClose() {
        pagePopUpClose.click();
        return this;
    }

    public Page checkTitle(String expextedTitle) {
        String actualTitle = navPageTitle.getText();
        assertThat(expextedTitle, equalToCompressingWhiteSpace(actualTitle));
        return this;
    }

    public Navigation getNavigation() {
        return navigation;
    }
}
