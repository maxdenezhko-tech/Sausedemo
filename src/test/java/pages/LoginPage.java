package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.User;

public class LoginPage extends BasePage {
    private final By loginInput = By.cssSelector("#user-name");
    private final By passwordInput = By.cssSelector("#password");
    private final By submitButton = By.cssSelector("#login-button");
    private final By errorField = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открывваем страницу авторизации")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Логинимся под кредами пользователя: = {user.name}, пароль=******")
    public void login(User user) {
        fillInLoginField(user.getName());
        fillInPasswordField(user.getPassword());
        driver.findElement(submitButton).click();
    }

    @Step("Заполняем поле ввода логина")
    public void fillInLoginField(String login) {
        driver.findElement(loginInput).sendKeys(login);
    }

    @Step("Заполняем поле ввода пароля")
    public void fillInPasswordField(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Проверяем факт отображения сообщения об ошибке")
    public boolean isErrorDisplayed() {
        return driver.findElement(errorField).isDisplayed();
    }

    @Step("Проверяем текст ошибки")
    public String getErrorText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorField));
        return driver.findElement(errorField).getText();
    }
}
