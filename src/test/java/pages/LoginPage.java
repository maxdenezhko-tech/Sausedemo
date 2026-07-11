package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private final By loginInput = By.cssSelector("#user-name");
    private final By passwordInput = By.cssSelector("#password");
    private final By submitButton = By.cssSelector("#login-button");
    private final By errorField = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String login, String password) {
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorField).isDisplayed();
    }

    public String getErrorText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorField));
        return driver.findElement(errorField).getText();
    }
}
