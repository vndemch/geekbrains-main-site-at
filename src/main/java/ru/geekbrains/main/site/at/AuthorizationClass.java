package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationClass {

    @FindBy (xpath = "//*[@id=\"user_email\"]")
    private WebElement login_field;

    @FindBy (xpath = "//*[@id=\"user_password\"]")
    private WebElement pwd_field;

    @FindBy (xpath = "//*[@data-testid=\"login-submit\"]")
    private WebElement loginButton;

    public WebElement getLogin_field() {
        return login_field;
    }

    public WebElement getPwd_field() {
        return pwd_field;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    @Step("Ввод логина, пароля, вход в систему")
    public void userLogin(String login, String pwd) {
        getLogin_field().sendKeys(login);
        getPwd_field().sendKeys(pwd);
        getLoginButton().click();
    }

}
