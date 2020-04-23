package ru.geekbrains.main.site.at;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected Navigation navigation;

    void HeaderCheck () {
        WebElement header = driver.findElement(By.cssSelector("header[id=\"top-menu\"]"));
        Assertions.assertTrue(header.isDisplayed());
    }

    void FooterCheck () {
        WebElement footer = driver.findElement(By.cssSelector("footer[class=\"site-footer\"]"));
        Assertions.assertTrue(footer.isDisplayed());
    }

    @BeforeEach
    void setUp() {
        //System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        //driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Изначально браузер открывается в полэкрана шириной и боковое меню не отображается
        // fullscreen() не отрабатывает и после максимизации возвращается к исходному размеру
        driver.manage().window().setSize(new Dimension(1200, 1000));
        navigation = PageFactory.initElements(driver,Navigation.class);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
