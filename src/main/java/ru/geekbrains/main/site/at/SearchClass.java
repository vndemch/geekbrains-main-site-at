package ru.geekbrains.main.site.at;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchClass {

    @FindBy(xpath = "//div[@class='search-page-block'][1]/div[@class='stickyTitleWrap']/header/h2")
    private WebElement ProfessionsBlock;
    @FindBy(xpath = "//div[@class='search-page-block'][2]/div[@class='stickyTitleWrap']/header/h2")
    private WebElement CoursesBlock;
    @FindBy(xpath = "//div[@class='search-page-block'][3]/div[@class='stickyTitleWrap']/header/h2")
    private WebElement EventsBlock;
    @FindBy(xpath = "//div[@class='search-page-block'][4]/div[@class='stickyTitleWrap']/header/h2")
    private WebElement PostsBlock;
    @FindBy(xpath = "//div[@class='search-page-block'][5]/div[@class='stickyTitleWrap']/header/h2")
    private WebElement TopicsBlock;
    @FindBy(xpath = "//div[@class='search-page-block'][6]/div[@class='stickyTitleWrap']/header/h2")
    private WebElement TestsBlock;
    @FindBy(xpath = "//div[@class='search-page-block'][7]/div[@class='stickyTitleWrap']/header/h2")
    private WebElement ProjectsAndCompaniesBlock;

    public WebElement getProfessionsBlock() {
        return ProfessionsBlock;
    }

    public WebElement getCoursesBlock() {
        return CoursesBlock;
    }

    public WebElement getEventsBlock() {
        return EventsBlock;
    }

    public WebElement getPostsBlock() {
        return PostsBlock;
    }

    public WebElement getTopicsBlock() {
        return TopicsBlock;
    }

    public WebElement getTestsBlock() {
        return TestsBlock;
    }

    public WebElement getProjectsAndCompaniesBlock() {
        return ProjectsAndCompaniesBlock;
    }


    @FindBy(xpath = "//*[@id=\"professions\"]/div[1]/header/ul/li/a/span")
    private WebElement ProfessionsCount;
    @FindBy(xpath = "//header[@class='search-page-block__header']/ul/li/a[@data-tab='courses']/span")
    private WebElement CoursesCount;
    @FindBy(xpath = "//header[@class='search-page-block__header']/ul/li/a[@data-tab='webinars']/span")
    private WebElement EventsCount;
    @FindBy(xpath = "//header[@class='search-page-block__header']/ul/li/a[@data-tab='blogs']/span")
    private WebElement PostsCount;
    @FindBy(xpath = "//header[@class='search-page-block__header']/ul/li/a[@data-tab='forums']/span")
    private WebElement TopicsCount;
    @FindBy(xpath = "//header[@class='search-page-block__header']/ul/li/a[@data-tab='blogs']/span")
    private WebElement TestsCount;
    @FindBy(xpath = "//header[@class='search-page-block__header']/ul/li/a[@data-tab='blogs']/span")
    private WebElement ProjectsAndCompaniesCount;

    @FindBy(xpath = "//*[@id=\"top-menu\"]/div/ul/li[2]/a")
    private WebElement searchField;
    @FindBy(css = "[class=\"search-panel__search-field\"]")
    private WebElement searchString;

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSearchString() {
        return searchString;
    }

    public void sendSearchString (String srchString) {
        this.getSearchField().click();
        this.getSearchString().sendKeys(srchString);
    }

    public WebElement getProfessionsCount() {
        return ProfessionsCount;
    }

    public WebElement getCoursesCount() {
        return CoursesCount;
    }

    public WebElement getEventsCount() {
        return EventsCount;
    }

    public WebElement getPostsCount() {
        return PostsCount;
    }

    public WebElement getTopicsCount() {
        return TopicsCount;
    }

    public WebElement getTestsCount() {
        return TestsCount;
    }

    public WebElement getProjectsAndCompaniesCount() {
        return ProjectsAndCompaniesCount;
    }

    //List<WebElement> elementList         = driver.findElements(By.xpath("//div/div/section/div[2]/h3/a"));

}
